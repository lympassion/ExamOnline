package com.loti.service.Impl;

import com.loti.dao.mapper.TeacherMapper;
import com.loti.dao.pojo.Entity.User.Teacher;
import com.loti.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
