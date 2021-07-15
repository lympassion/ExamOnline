package com.loti.controller.role;

import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.dao.pojo.Entity.Paper;
import com.loti.dao.pojo.Entity.RealPaper;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.loti.service.PaperService;
import com.loti.service.QuesService;
import com.loti.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public Map<String,Object> getQues0(@RequestParam("cname") String courseName){
        return new HashMap<String, Object>(){{
            put("data",quesService.GetQuesByTypeName(0,courseName));
        }};
    }

    @RequestMapping(value = "/getQuestions1",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getQues1(@RequestParam("cname") String courseName){
        return new HashMap<String, Object>(){{
            put("data",quesService.GetQuesByTypeName(1,courseName));
        }};
    }

    @RequestMapping(value = "/getQuestions2",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getQues2(@RequestParam("cname") String courseName){
        return new HashMap<String, Object>(){{
            put("data",quesService.GetQuesByTypeName(2,courseName));
        }};
    }

    @RequestMapping(value = "/getQuestions4",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getQues4(@RequestParam("cname") String courseName){
        return new HashMap<String, Object>(){{
            put("data",quesService.GetQuesByTypeName(4,courseName));
        }};
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

        RealPaper realPaper = new RealPaper(0,paperName,courseName,0);
        paperService.InsertRealPaper(realPaper);
        int paper_id = realPaper.getPaperId();

        try {
            for(String s:questions0){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,0,Integer.parseInt(s),order++
                ));
            }
            for(String s:questions1){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,1,Integer.parseInt(s),order++
                ));
            }
            for(String s:questions2){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,2,Integer.parseInt(s),order++
                ));
            }
            for(String s:questions4){
                paperService.InsertPaper(new Paper(
                        0,paper_id,courseName,4,Integer.parseInt(s),order++
                ));
            }
            return new HashMap<String, Object>(){{
               put("code",0);put("msg","ok");
            }};
        } catch (NullPointerException e){
            return new HashMap<String, Object>(){{
                put("code",106);put("msg","database error");
            }};
        }
    }
}
