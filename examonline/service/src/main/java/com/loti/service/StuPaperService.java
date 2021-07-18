package com.loti.service;

import com.loti.dao.pojo.Entity.StudentPaper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StuPaperService {
    boolean StudentIfTest(int exam_id,int stu_id);
    List<StudentPaper> getStuPaperByStuId(int stu_id);
    List<StudentPaper> getStuPaperByExamId(int exam_id);

    int selectScorePart1(int exam_id,int stu_id);
    int selectScorePart2(int exam_id,int stu_id);

    void UpdateIfTestInfo(int exam_id,int stu_id);
    void InsertStuPaper(StudentPaper studentPaper);
    void updateScorePart1(int exam_id,int stu_id,int score_1);
    void updateScorePart2(int exam_id,int stu_id,int score_2);
}
