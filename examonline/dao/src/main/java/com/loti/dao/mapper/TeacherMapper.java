package com.loti.dao.mapper;


import com.loti.dao.pojo.Entity.User.MyUser;
import com.loti.dao.pojo.Entity.User.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {
    List<Teacher> getAllTeacher();
    void InsertTeacher(Teacher teacher);
    Teacher SelectTeacherById(int id);
    Teacher SelectTeacherByIdAndPass(MyUser user);
    List<Teacher> SelectNotClass(String courseName);
}
