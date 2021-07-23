package com.loti.service;

import com.loti.dao.pojo.Entity.QuesSet;
import com.loti.dao.pojo.Entity.Question;
import com.loti.dao.pojo.Entity.Trans.ReviewQues;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuesService {
    //根据试题id获取
    Question GetQuesByQid(int ques_id);
    //获取错题集
    QuesSet selectQues(int stuId, int quesId);
    //获取课程名称下指定类型的题目
    List<Question> GetQuesByTypeName(int type,String course_name);
    List<QuesSet> getQuesSetByStu(int stuId);
    //方便传输前端的数据集合
    List<ReviewQues> getReviewByStu(int stuId,int examId,int paper_id);
    //获取全部题目
    List<Question> getAllQues();
    String GetCourseName();
    int getScoreById(int q_id);

    void InsertQuestion(Question question);
    void insertQuesSet(QuesSet quesSet);
    void removeQues(int ques_id);
}
