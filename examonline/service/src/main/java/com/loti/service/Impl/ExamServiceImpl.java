package com.loti.service.Impl;

import com.loti.dao.mapper.ExamMapper;
import com.loti.dao.pojo.Entity.Exam;
import com.loti.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamServiceImpl implements ExamService {
    @Autowired(required = false)
    private ExamMapper examMapper;

    @Override
    public List<Exam> getStudentNotTest(int stu_id) {
        List<Exam> examList = examMapper.SelectExamByStuIdNotTest(stu_id);
        examList.removeIf(exam -> exam.getEndTime().getTime() < System.currentTimeMillis());
        return examList;
    }

    @Override
    public List<Exam> getStudentTest(int stu_id) {
        return examMapper.SelectExamByStuIdTested(stu_id);
    }

    @Override
    public List<Exam> getStudentExam(int stu_id) {
        return examMapper.SelectExamByStuId(stu_id);
    }

    @Override
    public int getExamTime(int exam_id) {
        return examMapper.SelectExamTimeByExamId(exam_id);
    }

    @Override
    public void InsertExam(Exam exam) {
        examMapper.InsertExam(exam);
    }

    @Override
    public List<Exam> getAllExam() {
        return examMapper.getAllExam();
    }

    @Override
    public List<Exam> getExamByTeacherId(int teacher_id) {
        return examMapper.getExamByTeacherId(teacher_id);
    }

    @Override
    public Exam getExamById(int examId) {
        return examMapper.SelectExamByExamId(examId);
    }

    @Override
    public int getPaperId(int exam_id) {
        return examMapper.SelectPaperId(exam_id);
    }

    @Override
    public int getTotalScore(int exam_id) {
        return examMapper.getTotalScore(exam_id);
    }

}
