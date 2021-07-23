package com.loti.service.Impl;

import com.loti.dao.mapper.StuExamMapper;
import com.loti.dao.pojo.Entity.StudentExam;
import com.loti.service.StuExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<StudentExam> getStuExamByExamStu(int exam_id, int stu_id) {
        return stuExamMapper.getStuExamByExamStu(exam_id, stu_id);
    }

    @Override
    public void updateScore(int exam_id, int stu_id, int ques_id, int score) {
        stuExamMapper.updateScore(exam_id,stu_id,ques_id,score);
    }

    @Override
    public int getStuExamTypeCnt(int stu_id, int exam_id, int type) {
        return stuExamMapper.getStuExamTypeCnt(stu_id,exam_id,type);
    }

    @Override
    public List<Double> getRateByExam(int exam_id, int paper_id, int score0, int score1, int score2, int score3, int score4) {
        return stuExamMapper.getRateByExam(exam_id,paper_id,score0,score1,score2,score3,score4);
    }

}
