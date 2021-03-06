package com.loti.service;

import com.loti.dao.pojo.Entity.StudentExam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StuExamService {
    StudentExam getStuExamById(int exam_id,int stu_id,int ques_id);
    void InsertStuExam(StudentExam studentExam);
    void InsertInitStuExamByClass(int class_id,int exam_id);
    List<StudentExam> getStuExamByExamStu(int exam_id,int stu_id);
    void updateScore(int exam_id,int stu_id,int ques_id,int score);
    int getStuExamTypeCnt(int stu_id,int exam_id,int type);
    List<Double> getRateByExam(int exam_id,int paper_id,int score0,int score1,int score2,int score3,int score4);
}
