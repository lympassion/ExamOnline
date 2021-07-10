package com.loti.controller.Utils;

import com.loti.dao.pojo.Entity.User.Student;
import com.loti.dao.pojo.Entity.User.Teacher;

import java.util.Map;

public class FormatUtil {
    public static boolean GenderFormat(String gender){
        return gender.equals("male");
    }

    public static Student MapToStudent(Map<String,String> map){
        Student student = new Student();
        student.setUser_id(map.get("username"));
        student.setPassword(map.get("password"));
        student.setUsername(map.get("realname"));
        //student.setS_class(map.get("class"));     classService
        student.setGender(GenderFormat(map.get("gender")));
        return student;
    }

    public static Teacher MapToTeacher(Map<String,String> map){
        Teacher teacher = new Teacher();
        teacher.setUser_id(map.get("username"));
        teacher.setPassword(map.get("password"));
        teacher.setUsername(map.get("realname"));
        teacher.setGender(GenderFormat(map.get("gender")));
        return teacher;
    }

}
