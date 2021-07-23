package com.loti.controller.role;

import com.loti.controller.trans.ExamMsg;
import com.loti.controller.trans.PaperInfo;
import com.loti.dao.pojo.Entity.Classe;
import com.loti.dao.pojo.Entity.Exam;
import com.loti.dao.pojo.Entity.RealPaper;
import com.loti.dao.pojo.Entity.StudentClass;
import com.loti.dao.pojo.Entity.Trans.TransClass;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.loti.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ClassService classService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private ExamService examService;
    @Autowired
    private StuExamService stuExamService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private QuesService quesService;

    @RequestMapping(value = "/getAllPaper",method = RequestMethod.GET)
    @ResponseBody
    public List<PaperInfo> getAllPaperInfo(@RequestParam("cname") String course_name){
        List<PaperInfo> paperInfos = new LinkedList<>();
        List<Integer> paperIdList = paperService.getRPaperIdByCourse(course_name);
        try {
            for(int paper_id:paperIdList){
                PaperInfo paperInfo = new PaperInfo();
                paperInfo.setPaperId(paper_id);
                paperInfo.setPaperName(paperService.getPaperNameById(paper_id));
                paperInfo.setQuestion0Num(paperService.getTypeCnt(0,paper_id));
                paperInfo.setQuestion1Num(paperService.getTypeCnt(1,paper_id));
                paperInfo.setQuestion2Num(paperService.getTypeCnt(2,paper_id));
                paperInfo.setQuestion4Num(paperService.getTypeCnt(4,paper_id));
                paperInfo.setPaperScore(paperService.getPaperScoreById(paper_id));
                paperInfos.add(paperInfo);
            }
            return paperInfos;
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value = "/getAllClassByCourse",method = RequestMethod.GET)
    @ResponseBody
    public List<TransClass> getAllClassByCourse(@RequestParam("cname") String course_name){
        return classService.getClassInfoByCourse(course_name);
    }

    @RequestMapping(value = "/getAllClass",method = RequestMethod.GET)
    @ResponseBody
    public List<TransClass> getAllClass(){
        return classService.getAllClassInfo();
    }

    @RequestMapping(value = "/getAllClassName",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getAllClassName(){
        return classService.getAllClassName();
    }

    @RequestMapping(value = "/getAllStudent",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "/getAllTeacher",method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @RequestMapping(value = "/getAllExam",method = RequestMethod.GET)
    @ResponseBody
    public List<Exam> getExamInfo(){
        return examService.getAllExam();
    }

    @RequestMapping(value = "/newExamSubmit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> examSubmit(@RequestBody ExamMsg examMsg){
        System.out.println(examMsg.toString());
        int total_score = paperService.getPaperScoreById(examMsg.getPaperId());
        String[] classList = examMsg.getClassId().split(",");
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

    @RequestMapping(value = "/newClassSubmit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> classSubmit(@RequestBody Map<String,String> classInfo){
        System.out.println(classInfo.toString());
        String[] studentList = classInfo.get("studentId").split(",");
        List<String> ClassNameList = classService.getAllClassName();
        if(ClassNameList.contains(classInfo.get("className"))){
            return new HashMap<String, Object>(){{
               put("code",102);put("msg","classname already exist");
            }};
        }
        int teacherId = Integer.parseInt(classInfo.get("teacherId"));
        Classe classe = new Classe(0,classInfo.get("courseName"),teacherId,
                                    classInfo.get("className"),studentList.length);
        try {
            classService.InsertClass(classe);
            for(String studentId:studentList){
                classService.InsertStuClass(new StudentClass(0,Integer.parseInt(studentId),classe.getClassId()));
                studentService.setStuClass(Integer.parseInt(studentId),classe.getClassName());
            }
            return new HashMap<String, Object>(){{
                put("code",0);put("msg","ok");
            }};
        }catch (NullPointerException e){
            return new HashMap<String, Object>(){{
                put("code",101);put("msg","database error");
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

    @RequestMapping(value = "/getTeachersNoClass",method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> TeacherNoClass(@RequestParam("cname") String courseName){
        return  teacherService.SelectNotClass(courseName);
    }

    @RequestMapping(value = "/getStudentUniCourse",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudentUniCourse(@RequestParam("cname") String courseName){
        return studentService.getStuUniCourse(courseName);
    }

}
