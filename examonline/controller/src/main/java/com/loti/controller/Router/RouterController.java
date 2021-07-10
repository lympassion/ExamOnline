package com.loti.controller.Router;


import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.loti.dao.pojo.Entity.User.User;
import com.loti.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RouterController {

    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String index(){
        return "index";
    }

//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    public String login(){
//        return "auth/login";
//    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> loginControl(@RequestBody User user){
        int error_code = 101;
        String error_type = "";
        String role ="";//temp
        String userid = "";//temp
        User usr = new User(); //UserService TODO
        if(usr!=null){
            String jwt = JwtUtil.generateToken(role,userid);//TODO
            return new HashMap<String, Object>(){{
                put("code", 0);
                put("msg","ok");
                put("token",jwt);
            }};
        }else {
            return new HashMap<String, Object>(){{
                put("code",error_code);
                put("msg",error_type);
                put("token",null);
            }};
        }
    }

//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public String register(){
//        //TODO
//        return  "auth/register";
//    }

    @RequestMapping()
    public Map<String,Object> register(@RequestBody Map<String,String> UserMap){
        switch (UserMap.get("usertype")){
            case "student":
                Student student = FormatUtil.MapToStudent(UserMap);
                //studentService
                break;
            case  "teacher":
                Teacher teacher = FormatUtil.MapToTeacher(UserMap);
                //teacherService
                break;
        }
        return null;//TODO
    }

}
