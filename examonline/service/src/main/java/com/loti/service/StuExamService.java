package com.loti.service;

import com.loti.dao.pojo.Entity.StudentExam;
import org.springframework.stereotype.Service;

@Service
public interface StuExamService {
    StudentExam getStuExamById(int exam_id,int stu_id,int ques_id);
    void InsertStuExam(StudentExam studentExam);
}
