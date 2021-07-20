package com.loti.service;

import com.loti.dao.pojo.Entity.Paper;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.dao.pojo.Entity.User.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    //根据教师id获取教师信息
    Teacher SelectTeacherById(int id);
    //添加教师
    void InsertTeacher(Teacher teacher);
    //略略略
    List<Teacher> getAllTeacher();
    //选取没有课程的老师
    List<Teacher> SelectNotClass(String courseName);
    void updateTeacher(int teacherId,String teacherName,int teacherGender,String teacherPassword,
                       String teacherPicture);
}
