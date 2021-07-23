package com.loti.dao.pojo.Entity;

import org.springframework.stereotype.Component;

@Component
public class Paper {
    private int id;
    private int paperId;
    private String courseName;
    private int questionType;
    private int questionId;
    private int questionOrder;

    Paper(){}
    public Paper(int id, int paperId, String courseName, int questionType, int questionId, int questionOrder) {
        this.id = id;
        this.paperId = paperId;
        this.courseName = courseName;
        this.questionType = questionType;
        this.questionId = questionId;
        this.questionOrder = questionOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int questionOrder) {
        this.questionOrder = questionOrder;
    }
}
