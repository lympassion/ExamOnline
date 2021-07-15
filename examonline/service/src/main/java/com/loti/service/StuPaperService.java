package com.loti.service;

import com.loti.dao.pojo.Entity.StudentPaper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StuPaperService {
    boolean StudentIfTest(int exam_id,int stu_id);
    List<StudentPaper> getStuPaperByStuId(int stu_id);
    void UpdateIfTestInfo(int exam_id,int stu_id);
    void InsertStuPaper(StudentPaper studentPaper);
}
