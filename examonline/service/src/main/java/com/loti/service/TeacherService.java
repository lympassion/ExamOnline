package com.loti.service;

import com.loti.dao.pojo.Entity.Paper;
import com.loti.dao.pojo.Entity.User.Student;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    //新增学生信息
    void AddStudent(Student student);
    //注销学生信息
    void DeleteStudent(Student student);
    //新增试题功能
    void AddPaper(Paper paper);
    //试卷组卷 TODO

}
