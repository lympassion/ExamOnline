package com.loti.service.Impl;

import com.loti.dao.mapper.ExamMapper;
import com.loti.dao.pojo.Entity.Exam;
import com.loti.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

@Component
public class ExamServiceImpl implements ExamService {
    @Autowired(required = false)
    private ExamMapper examMapper;


    @Override
    public List<Exam> getStudentNotTest(int stu_id) {
        return examMapper.SelectExamByStuIdNotTest(stu_id);
    }

    @Override
    public List<Exam> getStudentTest(int stu_id) {
        return examMapper.SelectExamByStuIdTested(stu_id);
    }

    @Override
    public List<Exam> getStudentExam(int stu_id) {
        List<Exam> examList=examMapper.SelectExamByStuId(stu_id);
        examList.removeIf(exam -> exam.getEndTime().getTime() < System.currentTimeMillis());
        return examList;
    }
}
