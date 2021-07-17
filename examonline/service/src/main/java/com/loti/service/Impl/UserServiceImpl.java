package com.loti.service.Impl;

import com.loti.dao.mapper.AdminMapper;
import com.loti.dao.mapper.StuMapper;
import com.loti.dao.mapper.TeacherMapper;
import com.loti.dao.pojo.Entity.User.Admin;
import com.loti.dao.pojo.Entity.User.MyUser;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.loti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private StuMapper stuMapper;
    @Autowired(required = false)
    private TeacherMapper teacherMapper;
    @Autowired(required = false)
    private AdminMapper adminMapper;

    @Override
    public MyUser checkUser(MyUser user) {
        if(user.getRole().equals(MyUser.ROLE_STUDENT)) {
            Student student = stuMapper.selectByIdAndPass(user);
            System.out.println(student);
            if(student == null)
                return null;
            return new MyUser(student.getStudentId(),student.getStudentPassword());
        }
        if(user.getRole().equals(MyUser.ROLE_TEACHER)){
            Teacher teacher = teacherMapper.SelectTeacherByIdAndPass(user);
            if(teacher == null)
                return null;
            return new MyUser(teacher.getTeacherId(),teacher.getTeacherPassword());
        }
        if(user.getRole().equals(MyUser.ROLE_ADMIN)){
            Admin admin = adminMapper.selectByIdAndPass(user);
            if(admin == null)
                return null;
            return new MyUser(admin.getAdminId(),admin.getAdminPassword());
        }
        return null;
    }

    @Override
    public MyUser checkUserById(int id) {
        if(String.valueOf(id).substring(0,1).equals(MyUser.ROLE_STUDENT)) {
            Student student = stuMapper.selectById(id);
            return new MyUser(student.getStudentId(),student.getStudentPassword());
        }
        if(String.valueOf(id).substring(0,1).equals(MyUser.ROLE_TEACHER)){
            Teacher teacher = teacherMapper.SelectTeacherById(id);
            return new MyUser(teacher.getTeacherId(),teacher.getTeacherPassword());
        }if(String.valueOf(id).substring(0,1).equals(MyUser.ROLE_ADMIN)){
            Admin admin = adminMapper.selectAdminById(id);
            return new MyUser(admin.getAdminId(),admin.getAdminPassword());
        }
        return null;
    }
}
