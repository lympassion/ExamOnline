package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.Exam;
import com.loti.dao.pojo.Entity.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamMapper {
    Exam SelectExamByCourseId(String course_name);
    Exam SelectExamByExamId(int id);
    //插入exam表
    void InsertExam(Exam exam);
    //根据学生id查询exam表
    List<Exam> SelectExamByStuId(int id);
    //根据学生id查询已经参加考试的exam表
    List<Exam> SelectExamByStuIdTested(int id);
    //根据学生id查询未参加考试的exam表
    List<Exam> SelectExamByStuIdNotTest(int id);
    //查询所有考试
    List<Exam> getAllExam();
    //根据老师id查询
    List<Exam> getExamByTeacherId(int id);
    //根据考试id查询考试时间
    int SelectExamTimeByExamId(int id);
    //通过exam id获取试卷id
    int SelectPaperId(int id);
}
