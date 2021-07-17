package com.loti.service;

import com.loti.dao.pojo.Entity.Exam;
import com.loti.dao.pojo.Entity.User.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {
    //通过id查看学生信息
    Student getInfoById(int stu_id);
    //修改学生信息，并存入
    void InsertStu(Student student);
    //查找所有学生
    List<Student> getAllStudent();
    //查找未被分班的学生
    List<Student> getStuUniCourse(String course_name);
}
