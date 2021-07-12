package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.User.MyUser;
import com.loti.dao.pojo.Entity.User.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuMapper {
    List<Student> getAllstudent();
    void InsertStudent(Student student);
    Student selectById(int id);
    Student selectByIdAndPass(MyUser user);
}
