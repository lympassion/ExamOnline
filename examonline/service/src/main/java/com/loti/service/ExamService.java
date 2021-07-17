package com.loti.service;

import com.loti.dao.pojo.Entity.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {
    List<Exam> getStudentNotTest(int stu_id);
    List<Exam> getStudentTest(int stu_id);
    List<Exam> getStudentExam(int stu_id);
    int getExamTime(int exam_id);
    void InsertExam(Exam exam);
    List<Exam> getAllExam();
    List<Exam> getExamByTeacherId(int teacher_id);
    int getPaperId(int exam_id);
}
