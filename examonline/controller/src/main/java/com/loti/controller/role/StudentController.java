package com.loti.controller.role;

import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.controller.trans.MarkQues;
import com.loti.dao.pojo.Entity.Exam;
import com.loti.dao.pojo.Entity.QuesSet;
import com.loti.dao.pojo.Entity.Question;
import com.loti.dao.pojo.Entity.StudentExam;
import com.loti.dao.pojo.Entity.Trans.ReviewQues;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ExamService examService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private StuPaperService stuPaperService;
    @Autowired
    private StuExamService stuExamService;
    @Autowired
    private QuesService quesService;


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> register(@RequestBody Map<String,String> UserMap){
        try {
            Student student = new Student(
                    0, UserMap.get("realname"), UserMap.get("class"),
                    "123@qq.com", UserMap.get("password"),
                    FormatUtil.GenderFormat(UserMap.get("gender")));
            studentService.InsertStu(student);
            String jwt = JwtUtil.generateToken("student",String.valueOf(student.getStudentId()));
            return new HashMap<String, Object>(){{
                put("code",0);put("msg","ok");put("token",jwt);put("userId",student.getStudentId());
            }};
        }catch (NullPointerException e){
            return new HashMap<String, Object>(){{
                put("code",101);put("msg","参数不正确");put("token",null);put("userId",null);
            }};
        }
    }

    @RequestMapping(value = "/getAllExam",method = RequestMethod.GET)
    @ResponseBody
    public List<Exam> getExamInfo(@RequestParam("sid") int studentId){
        if(studentId==0)
            return null;
        return examService.getStudentExam(studentId);
    }

    @RequestMapping(value = "/getExamEnd",method = RequestMethod.GET)
    @ResponseBody
    public List<Exam> getExamTest(@RequestParam("sid") int studentId){
        if(studentId == 0)
            return null;
        return examService.getStudentTest(studentId);
    }

    @RequestMapping(value = "/getExamReady",method = RequestMethod.GET)
    @ResponseBody
    public List<Exam> getExamNotTest(@RequestParam("sid") int studentId){
        if(studentId == 0)
            return null;
        return examService.getStudentNotTest(studentId);
    }

    @RequestMapping(value = "/getExamPaper",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getQuesInTest(@RequestParam("pid") int paper_id,@RequestParam("eid") int exam_id,
                                            @RequestParam("sid") int stu_id){
        int examTime = examService.getExamTime(exam_id);
        List<Question> questionList= paperService.getQuesByPaperId(paper_id);
        stuPaperService.UpdateIfTestInfo(exam_id,stu_id);
        int quesNum_0 = 0,quesNum_1 = 0, quesNum_2 = 0,quesNum_4 = 0;
        for(Question q:questionList){
            if(q.getQuestionType() == 0)
                quesNum_0 += 1;
            if(q.getQuestionType() == 1)
                quesNum_1 += 1;
            if(q.getQuestionType() == 2)
                quesNum_2 += 1;
            if (q.getQuestionType() == 4)
                quesNum_4 += 1;
        }
        int finalQuesNum_1 = quesNum_0;
        int finalQuesNum_2 = quesNum_1;
        int finalQuesNum_3 = quesNum_2;
        int finalQuesNum_4 = quesNum_4;
        return new HashMap<String, Object>(){{
            put("quesNum",questionList.size());
            put("quesNum_0", finalQuesNum_1);
            put("quesNum_1", finalQuesNum_2);
            put("quesNum_2", finalQuesNum_3);
            put("quesNum_4", finalQuesNum_4);
            put("examTime",examTime);
            put("data",questionList);
        }};
    }


    @RequestMapping(value = "/examSubmit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> ExamSubmit(@RequestBody Map<String, Object> sheet){
        System.out.println(sheet.toString());
        int userId = Integer.parseInt((String)sheet.get("userId"));
        int examId = Integer.parseInt((String)sheet.get("examId"));
        int score_1 = 0;
        if(userId == 0||examId == 0){
            //THROW WRONG CODE
        }
        LinkedHashMap<String, LinkedHashMap<String,Object>> answer= (LinkedHashMap<String, LinkedHashMap<String, Object>>) sheet.get("answer");

        for (Map.Entry<String, LinkedHashMap<String,Object>> temp : answer.entrySet()) {
            int ques_id = (Integer) temp.getValue().get("quesId");
            Question question = quesService.GetQuesByQid(ques_id);
            String stu_ans = (String) temp.getValue().get("quesAnswer");
            String corr_ans = question.getQuestionAnswer();
            int score = 0;
            if(question.getQuestionType()!=FormatUtil.SUBJECT){
                score = FormatUtil.JudgeScore(question.getQuestionType(),stu_ans,corr_ans);
                score_1 += score;
            }

            StudentExam studentExam = new StudentExam();
            studentExam.setExamId(examId);
            studentExam.setStudentId(userId);
            studentExam.setQuestionId(ques_id);
            studentExam.setStudentAnswer(stu_ans);
            studentExam.setStudentScore(score);
            stuExamService.InsertStuExam(studentExam);
        }

        stuPaperService.updateScorePart1(examId,userId,score_1);
        return new HashMap<String, Object>(){{
            put("code",0);
            put("msg","ok");
        }};

    }

    @RequestMapping(value = "/collectQuestion",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> CollectQues(@RequestParam("questionId") int ques_id,@RequestParam("sid") int stuId){
        try {
            if(quesService.selectQues(stuId,ques_id)!=null){
                return new HashMap<String, Object>(){{
                    put("code",101);put("msg","question already exist");
                }};
            }
            QuesSet quesSet = new QuesSet();
            quesSet.setQuestionId(ques_id);
            quesSet.setStudentId(stuId);
            quesService.insertQuesSet(quesSet);
            return new HashMap<String, Object>(){{
                put("code",0);put("msg","ok");
            }};
        }catch (Exception e){
            //ERROR CONTROL
            return new HashMap<String, Object>(){{
                put("code",102);put("msg","database error");
            }};
        }
    }

    @RequestMapping(value = "/getNotebook",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,MarkQues> getMark(@RequestParam("sid") int stuId){
        List<QuesSet> quesSets = quesService.getQuesSetByStu(stuId);
        Map<String,MarkQues> markQuesMap = new LinkedHashMap<>();
        for(QuesSet quesSet:quesSets){
            Question question = quesService.GetQuesByQid(quesSet.getQuestionId());
            markQuesMap.put(String.valueOf(question.getQuestionId()),new MarkQues(quesSet.getSetTime(),
                    question.getQuestionType(),question.getQuestionId(),question.getQuestionContent(),
                    question.getOpa(),question.getOpb(),question.getOpc(),question.getOpd(),
                    question.getQuestionAnswer()));
        }
        return markQuesMap;
    }

    @RequestMapping(value = "/reviewExamPaper",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getReview(@RequestParam("eid") int exam_id,@RequestParam("sid") int stu_id){
        int examTime = examService.getExamTime(exam_id);
        List<ReviewQues> reviewQues = quesService.getReviewByStu(stu_id,exam_id);
        int quesNum_0 = stuExamService.getStuExamTypeCnt(stu_id,exam_id,0);
        int quesNum_1 = stuExamService.getStuExamTypeCnt(stu_id,exam_id,1);
        int quesNum_2 = stuExamService.getStuExamTypeCnt(stu_id,exam_id,2);
        int quesNum_4 = stuExamService.getStuExamTypeCnt(stu_id,exam_id,4);

        return new HashMap<String, Object>(){{
            put("quesNum",quesNum_0+quesNum_1+quesNum_2+quesNum_4);
            put("quesNum_0", quesNum_0);
            put("quesNum_1", quesNum_1);
            put("quesNum_2", quesNum_2);
            put("quesNum_4", quesNum_4);
            put("examTime",examTime);
            put("data",reviewQues);
        }};
    }

}
