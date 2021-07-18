package com.loti.service.Impl;

import com.loti.dao.mapper.QuesMapper;
import com.loti.dao.mapper.QuesSetMapper;
import com.loti.dao.pojo.Entity.QuesSet;
import com.loti.dao.pojo.Entity.Question;
import com.loti.dao.pojo.Entity.Trans.ReviewQues;
import com.loti.service.QuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuesServiceImpl implements QuesService {
    @Autowired(required = false)
    private QuesMapper quesMapper;
    @Autowired(required = false)
    private QuesSetMapper quesSetMapper;

    @Override
    public void InsertQuestion(Question question) {
        quesMapper.InsertQues(question);
    }

    @Override
    public Question GetQuesByQid(int ques_id) {
        return  quesMapper.SelectQuesById(ques_id);
    }

    @Override
    public List<Question> GetQuesByTypeName(int type, String course_name) {
        return quesMapper.SelectQuesByTypeAndName(type,course_name);
    }

    @Override
    public String GetCourseName() {
        List<String> courseList = quesMapper.SelectCourseName();
        String course = "";
        if(!CollectionUtils.isEmpty(courseList)){
            course = String.join(",", courseList);
        }
        return course;
    }

    @Override
    public int getScoreById(int q_id) {
        return quesMapper.SelectScoreById(q_id);
    }

    @Override
    public List<QuesSet> getQuesSetByStu(int stuId) {
        return quesSetMapper.selectQuesSetByStu(stuId);
    }

    @Override
    public List<ReviewQues> getReviewByStu(int stuId, int examId) {
        return quesMapper.getReviewByStu(stuId,examId);
    }

    @Override
    public void insertQuesSet(QuesSet quesSet) {
        quesSetMapper.insertQuesSet(quesSet);
    }

    @Override
    public QuesSet selectQues(int stuId, int quesId) {
        return quesSetMapper.selectQues(stuId,quesId);
    }
}
