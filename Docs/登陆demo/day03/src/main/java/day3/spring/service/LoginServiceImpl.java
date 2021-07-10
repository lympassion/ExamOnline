package day3.spring.service;


import day3.spring.domain.AjaxResult;

import day3.spring.domain.User;
import day3.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl  implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public AjaxResult login(User user){

        String id = user.getId();
        if ("".equals(id)){
            return new AjaxResult("账号不能为空",1L);
        }

        String type = user.getType();
        if(type.equals("student")){
            User user1 = userMapper.selectStudent(id);
            if (user1 == null){
                return new AjaxResult("用户不存在",1L);
            }
            if (!user.getPassword().equals(user1.getPassword())){
                return new AjaxResult("密码错误",1L);
            }
        }
        if(type.equals("teacher")){
            User user1 = userMapper.selectTeacher(id);
            if (user1 == null){
                return new AjaxResult("用户不存在",1L);
            }
            if (!user.getPassword().equals(user1.getPassword())){
                return new AjaxResult("密码错误",1L);
            }
        }
        if(type.equals("admin")){
            User user1 = userMapper.selectAdmin(id);
            if (user1 == null){
                return new AjaxResult("用户不存在",1L);
            }
            if (!user.getPassword().equals(user1.getPassword())){
                return new AjaxResult("密码错误",1L);
            }
        }
        if(!type.equals("student")&&!type.equals("teacher")&&!type.equals("admin")){
            return new AjaxResult("用户类型不存在",1L);
        }

        return new AjaxResult("登录成功",0L);

    }
}
