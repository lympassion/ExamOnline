package com.loti.dao.mapper;

import com.loti.dao.pojo.Entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuesMapper {
    List<Question> SelectAllQues();
    //通过id获取题目
    Question SelectQuesById(int id);
    //根据题型获取题目
    // type: 单选：0 多选：1 判断：2 填空：3 主观题：4
    List<Question> SelectQuesByType(int type);
    //根据课程id获取题目
    List<Question> SelectQuesByCourse(String course_id);
    //添加课程
    void InsertQues(Question question);
    //获取考题课程列表
    List<String> SelectCourseName();
}
