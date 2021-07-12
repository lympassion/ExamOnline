package com.loti.controller.Router;


import com.loti.controller.Utils.JwtUtil;
import com.loti.dao.pojo.Entity.User.MyUser;
import com.loti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RouterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String index(){
        return "auth/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "auth/login";
    }

    @RequestMapping(value = "/student/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> loginControl(MyUser user){
        int error_code = 102;
        String error_type = "user no exist";

        MyUser usr = userService.checkUser(user);

        System.out.println(usr);
        String role = usr.getRole();

        if(role ==null){
            error_code = 105;
            error_type = "username invalid";
        }
        if(usr!=null){
            String jwt = JwtUtil.generateToken(role,String.valueOf(user.userId));//TODO
            return new HashMap<String, Object>(){{
                put("code", 0);
                put("msg","ok");
                put("token",jwt);
            }};
        }else {
            String finalError_type = error_type;
            int finalError_code = error_code;
            return new HashMap<String, Object>(){{
                put("code", finalError_code);
                put("msg", finalError_type);
                put("token",null);
            }};
        }
    }

//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public String register(){
//        //TODO
//        return  "auth/register";
//    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> register( Map<String,String> UserMap){
        switch (UserMap.get("usertype")){
            case "student":
                //studentService
                break;
            case  "teacher":
                //teacherService
                break;
            default:
                return null;
        }
        return null;//TODO
    }

}
