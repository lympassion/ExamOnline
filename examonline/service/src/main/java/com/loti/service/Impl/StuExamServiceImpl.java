package com.loti.service.Impl;

import com.loti.dao.mapper.StuExamMapper;
import com.loti.dao.pojo.Entity.StudentExam;
import com.loti.service.StuExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StuExamServiceImpl implements StuExamService {

    @Autowired(required = false)
    private StuExamMapper stuExamMapper;

    @Override
    public StudentExam getStuExamById(int exam_id, int stu_id,int ques_id) {
        return stuExamMapper.SelectStuExamById(exam_id,stu_id,ques_id);
    }

    @Override
    public void InsertStuExam(StudentExam studentExam) {
        stuExamMapper.InsertStuExam(studentExam);
    }

    @Override
    public void InsertInitStuExamByClass(int class_id, int exam_id) {
        stuExamMapper.InsertInitStuExamByClass(class_id,exam_id);
    }
}
