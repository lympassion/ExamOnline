package com.loti.controller.role;

import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.dao.pojo.Entity.Exam;
import com.loti.dao.pojo.Entity.Question;
import com.loti.dao.pojo.Entity.StudentExam;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public Map<String,Object> ExamSubmit(@RequestParam Map<String, Object> sheet){
        System.out.println(sheet.toString());
        int userId = Integer.parseInt((String)sheet.get("userId"));
        int examId = Integer.parseInt((String)sheet.get("examId"));
        int total_num = Integer.parseInt((String) sheet.get("num_total"));
        if(userId == 0||examId == 0||total_num ==0){
            //THROW WRONG CODE
        }
        for(int i=1;i<=total_num;i++){
            String ansKey_qid = "answer["+String.valueOf(i)+"][quesId]";
            String ansKsy_qans = "answer["+String.valueOf(i)+"][quesAnswer]";
            int ques_id = Integer.parseInt((String) sheet.get(ansKey_qid));
            String ques_ans = (String) sheet.get(ansKsy_qans);
            StudentExam studentExam = new StudentExam();
            studentExam.setExamId(examId);
            studentExam.setStudentId(userId);
            studentExam.setQuestionId(ques_id);
            studentExam.setStudentAnswer(ques_ans);
            stuExamService.InsertStuExam(studentExam);
        }
        return new HashMap<String, Object>(){{
            put("code",0);
            put("msg","ok");
        }};

    }

}
