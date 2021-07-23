package com.loti.service;

import com.loti.dao.pojo.Entity.StudentPaper;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.List;

@Service
public interface StuPaperService {
    //判断学生是否已经参加测试
    boolean StudentIfTest(int exam_id,int stu_id);
    //略略略
    List<StudentPaper> getStuPaperByStuId(int stu_id);
    List<StudentPaper> getStuPaperByExamId(int exam_id);
    //获取学生客观主观题成绩
    int selectScorePart1(int exam_id,int stu_id);
    int selectScorePart2(int exam_id,int stu_id);
    //获取一趟考试中处于lower和up分数之间的人数
    int selectCnt(int exam_id, double lower, double up);
    //更新学生考试信息
    void UpdateIfTestInfo(int exam_id,int stu_id);

    void InsertStuPaper(StudentPaper studentPaper);
    //更新学生客观主观题目分数
    void updateScorePart1(int exam_id,int stu_id,int score_1);
    void updateScorePart2(int exam_id,int stu_id,int score_2);
    //更新学生考试总分
    void updateScore(int exam_id,int stu_id,int score);
}
