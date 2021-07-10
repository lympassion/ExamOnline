package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.User.Student;

import java.util.List;

public interface StuMapper {
    List<Student> getAllstudent();
    List<Student> selectById(String id);
}
