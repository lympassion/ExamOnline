package com.loti.controller.Router;

import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.dao.pojo.Entity.User.MyUser;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.service.StudentService;
import com.loti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RouterController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "auth/login";
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> loginControl(MyUser user){
        int error_code = 102;
        String error_type = "user no exist";

        MyUser usr = userService.checkUser(user);
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

    @RequestMapping(value = "/student/register",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> register(@RequestParam Map<String,String> UserMap){
        System.out.println(UserMap.toString());
        if(UserMap == null){
            return new HashMap<String, Object>(){{
                put("code",101);put("msg","参数未获取");put("token",null);
            }};
        }
        switch (UserMap.get("usertype")){
            case "student":
                Student student = new Student(
                        0, UserMap.get("realname"), UserMap.get("class"),
                        "123@qq.com", UserMap.get("password"),
                        FormatUtil.GenderFormat(UserMap.get("gender")));
                studentService.InsertStu(student);//TODO
                String jwt = JwtUtil.generateToken("student",String.valueOf(student.getStudentId()));
                return new HashMap<String, Object>(){{
                    put("code",0);put("msg","ok");put("token",jwt);
                }};
            case  "teacher":
                //teacherService
                break;
            default:
                return new HashMap<String, Object>(){{
                put("code",105);put("msg","参数不合法");put("token",null);
            }};
        }
        return null;//TODO
    }

}
