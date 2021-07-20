package com.loti.controller.role;

import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.controller.trans.QuesSubInfo;
import com.loti.controller.trans.paperExamInfo;
import com.loti.dao.pojo.Entity.*;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.loti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private StuExamService stuExamService;
    @Autowired
    private StuPaperService stuPaperService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> register(@RequestBody Map<String,String> UserMap){
        try {
            Teacher teacher = new Teacher(0,UserMap.get("realname"),
                    FormatUtil.GenderFormat(UserMap.get("gender")),"Mori@gmail.com",
                    UserMap.get("password"));
            teacherService.InsertTeacher(teacher);
            String jwt = JwtUtil.generateToken(teacher.getTeacherId());
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
        int total_score = 0,score_part1 = 0,score_part2 = 0;

        RealPaper realPaper = new RealPaper(0,paperName,courseName,0);
        paperService.InsertRealPaper(realPaper);
        int paper_id = realPaper.getPaperId();

        try {
            for(String s:questions0){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,0,Integer.parseInt(s),order++
                ));
                int ques_score0 = quesService.getScoreById(Integer.parseInt(s));
                total_score += ques_score0;
                score_part1 += ques_score0;
            }
            for(String s:questions1){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,1,Integer.parseInt(s),order++
                ));
                int ques_score1 = quesService.getScoreById(Integer.parseInt(s));
                total_score += ques_score1;
                score_part1 += ques_score1;
            }
            for(String s:questions2){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,2,Integer.parseInt(s),order++
                ));
                int ques_score2 = quesService.getScoreById(Integer.parseInt(s));
                total_score += ques_score2;
                score_part1 += ques_score2;
            }
            for(String s:questions4){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,4,Integer.parseInt(s),order++
                ));
                int ques_score4 = quesService.getScoreById(Integer.parseInt(s));
                total_score += ques_score4;
                score_part2 += ques_score4;
            }
            paperService.updateScore(paper_id,total_score);
            paperService.updateScorePart1(paper_id,score_part1);
            paperService.updateScorePart2(paper_id,score_part2);
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

    @RequestMapping(value = "/getAllExamName",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> getExamName(@RequestParam("tid") int teacherId){
        try {
            if(teacherId == 0)
                return new HashMap<String, Object>(){{
                    put("code",101);put("msg","type error");
                }};
            List<Exam> examList = examService.getExamByTeacherId(teacherId);
            List<String> examString = examList.stream().map(Exam::getExamName).collect(Collectors.toList());
            return new HashMap<String, Object>(){{
                put("code",0);put("msg","ok");put("data",String.join(",",examString));
            }};
        }catch (Exception e){
            return new HashMap<String, Object>(){{
                put("code",102);put("msg","database error");
            }};
        }
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
                quesSubInfos.add(new QuesSubInfo(order,questionId,question.getQuestionScore()
                        ,question.getQuestionContent(),studentExam.getStudentAnswer()
                        ,studentExam.getStudentScore()));
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
            stuPaperService.updateScore(examId,stuId,stuPaperService.selectScorePart1(examId,stuId)+score_part2);
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
   public List<paperExamInfo> getStuScorePart1(@RequestParam("eid") int examId){
        List<paperExamInfo> paperExamInfos = new LinkedList<>();
        List<StudentPaper> studentPapers = stuPaperService.getStuPaperByExamId(examId);
        int paper_id = examService.getPaperId(examId);
        RealPaper realPaper = paperService.getRealPaperById(paper_id);

        for(StudentPaper studentPaper:studentPapers){
            paperExamInfo paperexamInfo = new paperExamInfo();
            paperexamInfo.setStudentName(studentService.getInfoById(studentPaper.getStudentId()).getStudentName());
            paperexamInfo.setStudentId(studentPaper.getStudentId());
            paperexamInfo.setScorePart1(realPaper.getPaperScorePart1());
            paperexamInfo.setMyScorePart1(studentPaper.getScorePart1());
            paperexamInfo.setScorePart2(realPaper.getPaperScorePart2());
            paperexamInfo.setMyScorePart2(studentPaper.getScorePart2());
            paperExamInfos.add(paperexamInfo);
        }
        return paperExamInfos;
   }

   @RequestMapping(value = "/getAnalysedData",method = RequestMethod.GET)
   @ResponseBody
   public Map<String,Object> getAnaData(@RequestParam("ename")String ename,@RequestParam("tid") int teacherId){
        int exam_id = classService.getClassByTeacher(teacherId).getExamId();
        int total_score = examService.getTotalScore(exam_id);
        int paper_id = examService.getPaperId(exam_id);
        int ques_cnt = paperService.getAllCnt(paper_id);
        String dataPie = "";

        dataPie += stuPaperService.selectCnt(exam_id, 0, total_score * 0.6) +",";
        dataPie += stuPaperService.selectCnt(exam_id, total_score * 0.6, total_score * 0.8) +",";
        dataPie += stuPaperService.selectCnt(exam_id, total_score * 0.8, total_score * 0.9) +",";
        dataPie += stuPaperService.selectCnt(exam_id,total_score*0.9,total_score);

        List<Double> rateList = stuExamService.getRateByExam(exam_id,paper_id,
                FormatUtil.SCORE_CHOICE,FormatUtil.SCORE_CHOICE,FormatUtil.JUDGE,
                FormatUtil.SCORE_BLANK, FormatUtil.SCORE_SUB);

        StringBuilder stringBuffer = new StringBuilder("");
        for(Double rate:rateList) {
            stringBuffer.append(rate);
            stringBuffer.append(",");
        }
        String rateString = stringBuffer.toString();
        String finalDataPie = dataPie;
        return new HashMap<String, Object>(){{
           put("dataPie", finalDataPie);put("numBar",ques_cnt);put("dataBar",rateString.substring(0,rateString.length()-1));
        }};
   }

    @RequestMapping(value = "/newQuestionSubmit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> QuestionSubmit(@RequestBody Question question){
        try {
            quesService.InsertQuestion(question);
            return new HashMap<String, Object>(){{
               put("code",0);put("msg","ok");
            }};
        }catch (Exception e){
            return new HashMap<String, Object>(){{
                put("code",102);put("msg","database error");
            }};
        }
    }

    @RequestMapping(value = "/getAllQuestion",method = RequestMethod.GET)
    @ResponseBody
    public List<Question> getAllQuestion(){
        return quesService.getAllQues();
    }

    @RequestMapping(value = "/removeQuestion",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> removeQues(@RequestParam("qid") int ques_id){
        try {
            quesService.removeQues(ques_id);
            return new HashMap<String, Object>(){{
                put("code",0);put("msg","ok");
            }};
        }catch (Exception e){
            return new HashMap<String, Object>(){{
                put("code",102);put("msg","database error");
            }};
        }
    }
}
