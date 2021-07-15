package com.loti.service;

import com.loti.dao.pojo.Entity.Paper;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.dao.pojo.Entity.User.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    Teacher SelectTeacherById(int id);
    void InsertTeacher(Teacher teacher);
}
