package com.loti.controller.trans;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class ExamEnd {
    private int examId;
    private String examName;
    private String courseName;
    private int paperId;
    private int totalScore;
    private int subScore;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp startTime;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp endTime;
    private int examTime;

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getSubScore() {
        return subScore;
    }

    public void setSubScore(int subScore) {
        this.subScore = subScore;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public int getExamTime() {
        return examTime;
    }

    public void setExamTime(int examTime) {
        this.examTime = examTime;
    }
}
