package com.loti.controller.role;

import com.loti.dao.pojo.Entity.Exam;
import com.loti.service.ExamService;
import com.loti.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ExamService examService;

    @RequestMapping(value = "/getAllExam/{sid}",method = RequestMethod.GET)
    @ResponseBody
    public List<Exam> getExamInfo(@PathVariable("sid") int studentId){
        if(studentId==0)
            return null;
        return examService.getStudentExam(studentId);
    }

    @RequestMapping(value = "/getEndedExam/{sid}",method = RequestMethod.GET)
    @ResponseBody
    public List<Exam> getExamTest(@PathVariable("sid") int studentId){
        if(studentId == 0)
            return null;
        return examService.getStudentTest(studentId);
    }

    @RequestMapping(value = "/getExamReady/{sid}",method = RequestMethod.GET)
    public List<Exam> getExamNotTest(@PathVariable("sid") int studentId){
        if(studentId == 0)
            return null;
        return examService.getStudentNotTest(studentId);
    }

}
