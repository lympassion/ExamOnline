package com.loti.service.Impl;

import com.loti.dao.mapper.StuMapper;
import com.loti.dao.pojo.Entity.Exam;
import com.loti.dao.pojo.Entity.User.Student;
import com.loti.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class StuServiceImpl implements StudentService {

    @Autowired(required = false)
    private StuMapper stuMapper;

    @Override
    public Student getInfoById(String id) {
        return null;
    }

    @Override
    public void InsertStu(Student student) {
        stuMapper.InsertStudent(student);
    }

    @Override
    public List<Exam> getExamIn() {
        return null;
    }

    @Override
    public Map<String, String> getRecord(Student student) {
        return null;
    }

    @Override
    public Map<String, String> getWrongAnsRec(Student student) {
        return null;
    }
}
