package com.loti.controller.role;

import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.controller.trans.ExamMsg;
import com.loti.dao.mapper.StuClassMapper;
import com.loti.dao.pojo.Entity.Exam;
import com.loti.dao.pojo.Entity.Paper;
import com.loti.dao.pojo.Entity.Question;
import com.loti.dao.pojo.Entity.RealPaper;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.loti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private QuesService quesService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private ExamService examService;
    @Autowired
    private ClassService classService;
    @Autowired
    private StuExamService stuExamService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> register(@RequestBody Map<String,String> UserMap){
        try {
            Teacher teacher = new Teacher(0,UserMap.get("realname"),
                    FormatUtil.GenderFormat(UserMap.get("gender")),"Mori@gmail.com",
                    UserMap.get("password"));
            teacherService.InsertTeacher(teacher);
            String jwt = JwtUtil.generateToken("teacher",String.valueOf(teacher.getTeacherId()));
            return new HashMap<String, Object>(){{
                put("code",0);put("msg","ok");put("token",jwt);put("userId",teacher.getTeacherId());
            }};
        }catch (NullPointerException e){
            return new HashMap<String, Object>(){{
                put("code",101);put("msg","参数不正确");put("token",null);put("userId",null);
            }};
        }
    }

    @RequestMapping(value = "/getAllCourseName",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCourse(){
        String courseList = quesService.GetCourseName();
        if(courseList == null)
            return new HashMap<String, Object>(){{
               put("code",101);put("msg","参数不正确");
            }};
        return new HashMap<String, Object>(){{
            put("code",0);put("msg","ok");put("data",courseList);
        }};
    }

    @RequestMapping(value = "/getQuestions0",method = RequestMethod.GET)
    @ResponseBody
    public List<Question> getQues0(@RequestParam("cname") String courseName){
        return quesService.GetQuesByTypeName(0,courseName);
    }

    @RequestMapping(value = "/getQuestions1",method = RequestMethod.GET)
    @ResponseBody
    public List<Question> getQues1(@RequestParam("cname") String courseName){
        return quesService.GetQuesByTypeName(1,courseName);
    }

    @RequestMapping(value = "/getQuestions2",method = RequestMethod.GET)
    @ResponseBody
    public List<Question> getQues2(@RequestParam("cname") String courseName){
        return quesService.GetQuesByTypeName(2,courseName);
    }

    @RequestMapping(value = "/getQuestions4",method = RequestMethod.GET)
    @ResponseBody
    public List<Question> getQues4(@RequestParam("cname") String courseName){
        return quesService.GetQuesByTypeName(4,courseName);
    }

    @RequestMapping(value = "/newPaperSubmit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> paperSubmit(@RequestBody Map<String,String> paperInfo){
        System.out.println(paperInfo.toString());
        String paperName = paperInfo.get("paperName");
        String courseName = paperInfo.get("courseName");
        String[] questions0 = paperInfo.get("questions0").split(",");
        String[] questions1 = paperInfo.get("questions1").split(",");
        String[] questions2 = paperInfo.get("questions2").split(",");
        String[] questions4 = paperInfo.get("questions4").split(",");
        int order = 0;
        int total_score = 0;

        RealPaper realPaper = new RealPaper(0,paperName,courseName,0);
        paperService.InsertRealPaper(realPaper);
        int paper_id = realPaper.getPaperId();

        try {
            for(String s:questions0){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,0,Integer.parseInt(s),order++
                ));
                total_score += quesService.getScoreById(Integer.parseInt(s));
            }
            for(String s:questions1){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,1,Integer.parseInt(s),order++
                ));
                total_score += quesService.getScoreById(Integer.parseInt(s));
            }
            for(String s:questions2){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,2,Integer.parseInt(s),order++
                ));
                total_score += quesService.getScoreById(Integer.parseInt(s));
            }
            for(String s:questions4){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,4,Integer.parseInt(s),order++
                ));
                total_score += quesService.getScoreById(Integer.parseInt(s));
            }
            paperService.updateScore(paper_id,total_score);
            return new HashMap<String, Object>(){{
               put("code",0);put("msg","ok");
            }};
        } catch (NullPointerException e){
            return new HashMap<String, Object>(){{
                put("code",106);put("msg","database error");
            }};
        }
    }

    @RequestMapping(value = "/getAllPapers",method = RequestMethod.GET)
    @ResponseBody
    public List<RealPaper> getAllPaper(){
        return paperService.getAllRealPaper();
    }

    @RequestMapping(value = "/removePaper",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> removePaper(@RequestParam("pid") String paperId){
        List<Integer> paperList = paperService.getAllRPaperId();
        if(!paperList.contains(Integer.parseInt(paperId))){
            return new HashMap<String, Object>(){{
               put("code",102);put("msg","paper id not exist");
            }};
        }
        paperService.DeleteRPaperById(Integer.parseInt(paperId));
        return new HashMap<String, Object>(){{
            put("code",0);put("msg","ok");
        }};
    }

    @RequestMapping(value = "/newExamSubmit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> examSubmit(@RequestBody ExamMsg examMsg){
        System.out.println(examMsg.toString());
        int total_score = paperService.getPaperScoreById(examMsg.getPaperId());
        String[] classList = examMsg.getClassIdList().split(",");
        try {
            for(String classe : classList){
                Exam exam = new Exam(0,examMsg.getExamName(),
                        examMsg.getCourseName(),examMsg.getPaperId(),total_score,examMsg.getStartTime(),
                        examMsg.getEndTime(),examMsg.getTimeLong());
                examService.InsertExam(exam);
                classService.updateExamById(Integer.parseInt(classe),exam.getExamId());
                stuExamService.InsertInitStuExamByClass(Integer.parseInt(classe),exam.getExamId());
            }
            return new HashMap<String, Object>(){{
               put("code",0);put("msg","ok");
            }};
        }catch (NullPointerException e){
            return new HashMap<String, Object>(){{
                put("code",101);put("msg","database error");
            }};//error control
        }
    }
}
