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
}
