package com.loti.controller.trans;

public class QuesSubInfo {
    int quesSubOrder;
    int questionId;
    int questionScore;
    String questionContent;
    String questionAnswer;
    int score;

    public QuesSubInfo(int quesSubOrder, int questionId, int questionScore, String questionContent, String questionAnswer, int score) {
        this.quesSubOrder = quesSubOrder;
        this.questionId = questionId;
        this.questionScore = questionScore;
        this.questionContent = questionContent;
        this.questionAnswer = questionAnswer;
        this.score = score;
    }

    public int getQuesSubOrder() {
        return quesSubOrder;
    }

    public void setQuesSubOrder(int quesSubOrder) {
        this.quesSubOrder = quesSubOrder;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(int questionScore) {
        this.questionScore = questionScore;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
