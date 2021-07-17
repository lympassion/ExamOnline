package com.loti.service.Impl;

import com.loti.dao.mapper.StuPaperMapper;
import com.loti.dao.pojo.Entity.StudentPaper;
import com.loti.service.StuPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StuPaperServiceImpl implements StuPaperService {

    @Autowired(required = false)
    private StuPaperMapper stuPaperMapper;

    @Override
    public boolean StudentIfTest(int exam_id, int stu_id) {
        return stuPaperMapper.SelectMarkByExamAndStudent(exam_id,stu_id)!=-1;
    }

    @Override
    public List<StudentPaper> getStuPaperByStuId(int stu_id) {
        return stuPaperMapper.SelectStuPaperByRecId(stu_id);
    }

    @Override
    public void UpdateIfTestInfo(int exam_id, int stu_id) {
        stuPaperMapper.updateStudentTestInfoById(exam_id,stu_id);
    }

    @Override
    public void InsertStuPaper(StudentPaper studentPaper) {
        stuPaperMapper.InsertStuPaper(studentPaper);
    }

    @Override
    public void updateScorePart1(int exam_id, int stu_id, int score_1) {
        stuPaperMapper.updateScorePart1(exam_id,stu_id,score_1);
    }

    @Override
    public void updateScorePart2(int exam_id, int stu_id, int score_2) {
        stuPaperMapper.updateScorePart2(exam_id,stu_id,score_2);
    }
}
