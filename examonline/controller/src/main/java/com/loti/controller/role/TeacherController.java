package com.loti.controller.role;

import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.dao.pojo.Entity.User.Teacher;
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

}
