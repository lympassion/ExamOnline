package com.loti.service.Impl;

import com.loti.dao.mapper.TeacherMapper;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.loti.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherServiceImpl implements TeacherService {
    @Autowired(required = false)
    private TeacherMapper teacherMapper;

    @Override
    public Teacher SelectTeacherById(int id) {
        return teacherMapper.SelectTeacherById(id);
    }

    @Override
    public void InsertTeacher(Teacher teacher) {
        teacherMapper.InsertTeacher(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherMapper.getAllTeacher();
    }

    @Override
    public List<Teacher> SelectNotClass(String courseName) {
        return teacherMapper.SelectNotClass(courseName);
    }

    @Override
    public void updateTeacher(int teacherId, String teacherName, int teacherGender, String teacherPassword, String teacherPicture) {
        Teacher teacher = teacherMapper.SelectTeacherById(teacherId);
        teacher.setTeacherName(teacherName);
        teacher.setTeacherGender(teacherGender);
        teacher.setTeacherPassword(teacherPassword);
        teacher.setTeacherPicture(teacherPicture);
        teacherMapper.updateTeacherInfo(teacher);
    }

}
