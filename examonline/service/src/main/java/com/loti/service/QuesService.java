package com.loti.service;

import com.loti.dao.pojo.Entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuesService {
    void InsertQuestion(Question question);
    Question GetQuesByQid(int ques_id);
    List<Question> GetQuesByTypeName(int type,String course_name);
    String GetCourseName();
    int getScoreById(int q_id);
}
