package com.loti.service;

import com.loti.dao.pojo.Entity.QuesSet;
import com.loti.dao.pojo.Entity.Question;
import com.loti.dao.pojo.Entity.Trans.ReviewQues;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuesService {
    Question GetQuesByQid(int ques_id);
    QuesSet selectQues(int stuId, int quesId);

    List<Question> GetQuesByTypeName(int type,String course_name);
    List<QuesSet> getQuesSetByStu(int stuId);
    List<ReviewQues> getReviewByStu(int stuId,int examId);

    String GetCourseName();
    int getScoreById(int q_id);

    void InsertQuestion(Question question);
    void insertQuesSet(QuesSet quesSet);
}
