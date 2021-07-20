package com.loti.service;

import com.loti.dao.pojo.Entity.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {
    //获取学生没考试和考试的exam列表
    List<Exam> getStudentNotTest(int stu_id);
    List<Exam> getStudentTest(int stu_id);
    //获取学生的所有考试情况
    List<Exam> getStudentExam(int stu_id);
    //获取部分参数
    int getExamTime(int exam_id);
    int getPaperId(int exam_id);
    int getTotalScore(int exam_id);
    //略略略
    void InsertExam(Exam exam);
    List<Exam> getAllExam();
    List<Exam> getExamByTeacherId(int teacher_id);
}
