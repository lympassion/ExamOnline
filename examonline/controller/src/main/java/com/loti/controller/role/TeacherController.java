package com.loti.controller.role;

import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.controller.trans.ExamMsg;
import com.loti.controller.trans.QuesSubInfo;
import com.loti.controller.trans.paperExamInfo;
import com.loti.dao.mapper.StuClassMapper;
import com.loti.dao.pojo.Entity.*;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.loti.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
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
    @Autowired
    private StuPaperService stuPaperService;

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

    @RequestMapping(value = "/getAllExam",method = RequestMethod.GET)
    @ResponseBody
    public List<Exam> getExamInfo(@RequestParam("tid") int teacherId){
        if(teacherId == 0)
            return null;
        return examService.getExamByTeacherId(teacherId);
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

    @RequestMapping(value = "/getStuAnswerPart2",method = RequestMethod.GET)
    @ResponseBody
    public List<QuesSubInfo> getStuAns(@RequestParam("eid") int exam_id,@RequestParam("sid") int stu_id){
        List<StudentExam> studentExams = stuExamService.getStuExamByExamStu(exam_id,stu_id);
        List<QuesSubInfo> quesSubInfos = new LinkedList<>();
        try {
            for(StudentExam studentExam:studentExams){
                int questionId = studentExam.getQuestionId();
                Question question = quesService.GetQuesByQid(questionId);
                if(question.getQuestionType()!=4)
                    continue;
                int paperId = examService.getPaperId(exam_id);
                int order = paperService.getOrderByPaperAndQues(questionId,paperId);
                quesSubInfos.add(new QuesSubInfo(order,questionId,studentExam.getStudentScore()
                        ,question.getQuestionContent(),studentExam.getStudentAnswer()
                        ,question.getQuestionScore()));
            }
            return quesSubInfos;
        }catch (Exception e){
            //ERROR CONTROL
            return null;
        }
   }



   //TODO FOR TEST
   @RequestMapping(value = "/submitExamMark",method = RequestMethod.POST)
   @ResponseBody
   public Map<String,Object> submitExam(@RequestBody Map<String,String> submitData){
        int examId = Integer.parseInt(submitData.get("examId"));
        int stuId = Integer.parseInt(submitData.get("studentId"));
        String[] scores = submitData.get("score").split(",");
        String[] quesIds = submitData.get("questionId").split(",");
        int score_part2 = 0;
        try {
            for(int i=0;i<scores.length;i++){
                stuExamService.updateScore(examId,stuId,
                        Integer.parseInt(quesIds[i]),Integer.parseInt(scores[i]));
                score_part2 += Integer.parseInt(scores[i]);
            }
            stuPaperService.updateScorePart2(examId,stuId,score_part2);
            return new HashMap<String, Object>(){{
                put("code",0);put("msg","ok");
            }};
        }catch (Exception e){
            return new HashMap<String, Object>(){{
                put("code",102);put("msg","database error");
            }};
        }
   }

   @RequestMapping(value = "/getStuScorePart1",method = RequestMethod.GET)
   @ResponseBody
   public List<paperExamInfo> getStuScorePart1(@RequestParam("eid") int examId,@RequestParam("tid") int teacherId){
        return null;
   }
}
