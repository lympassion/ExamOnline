package com.loti.controller.Router;

import com.loti.controller.Utils.FormatUtil;
import com.loti.controller.Utils.JwtUtil;
import com.loti.dao.mapper.TeacherMapper;
import com.loti.dao.pojo.Entity.User.Admin;
import com.loti.dao.pojo.Entity.User.MyUser;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.loti.service.StudentService;
import com.loti.service.TeacherService;
import com.loti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RouterController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

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
    public Map<String,Object> loginControl(MyUser user, HttpSession session){
        int error_code = 102;
        String error_type = "user no exist";

        MyUser usr = userService.checkUser(user);
        System.out.println(user.toString());
        try {
            if(usr == null){
                return new HashMap<String, Object>(){{
                    put("code", 101);
                    put("msg", "name not exist");
                    put("token",null);
                }};
            }
            String jwt = JwtUtil.generateToken(user.userId);
            System.out.println(jwt);
            session.setAttribute("userId",jwt);
            return new HashMap<String, Object>(){{
                put("code", 0);
                put("msg","ok");
                put("token",jwt);
            }};

        }catch (NullPointerException e){
            error_code = 105;
            error_type = "username invalid";
        }
        int finalError_code = error_code;
        String finalError_type = error_type;
        return new HashMap<String, Object>(){{
            put("code", finalError_code);
            put("msg", finalError_type);
            put("token",null);
        }};
    }

    @RequestMapping(value = "/user/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getUserInfo(@RequestParam("uid") int userId){
        String username = "",path = "";
        try {
            if(FormatUtil.getFirstNum(userId) == MyUser.ROLE_STUDENT){
                Student student = studentService.getInfoById(userId);
                username = student.getStudentName();
                path = student.getStudentPicture();
            }else if(FormatUtil.getFirstNum(userId) == MyUser.ROLE_TEACHER){
                Teacher teacher = teacherService.SelectTeacherById(userId);
                username = teacher.getTeacherName();
                path = teacher.getTeacherPicture();
            }else if(FormatUtil.getFirstNum(userId) == MyUser.ROLE_ADMIN){
                username = MyUser.ADMIN_NAME;
                path = MyUser.ADMIN_PHOTO;
            }else{
                return new HashMap<String, Object>(){{
                    put("code", 101);
                    put("msg", "user not exist");
                }};
            }
            String finalPath = path;
            String finalUsername = username;
            return new HashMap<String, Object>(){{
                put("code", 0);
                put("msg", "ok");
                put("data",new HashMap<String,String>(){{put("userAvatar", finalPath);put("userRealname", finalUsername);}});
            }};
        }catch (Exception e){
            return new HashMap<String, Object>(){{
                put("code", 102);
                put("msg", "database error");
            }};
        }
    }

    @RequestMapping(value = "/user/logout",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> logoutControl(@RequestBody String userId,HttpSession session){
        int user_id = Integer.parseInt(userId.substring(userId.indexOf("=")+1));
        MyUser myUser = userService.checkUserById(user_id);
        if(myUser == null){
            return new HashMap<String, Object>(){{
                put("code", 104);
                put("msg", "user not exist");
            }};
        }
        session.removeAttribute("userId");
        return new HashMap<String, Object>(){{
            put("code", 0);
            put("msg", "ok");
        }};
    }

}
