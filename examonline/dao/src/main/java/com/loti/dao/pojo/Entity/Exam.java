package com.loti.dao.pojo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Exam {
    private int examId;
    private String examName;
    private String courseName;
    private int paperId;
    private int totalScore;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp startTime;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp endTime;
    private int examTime;//format :second

    Exam(){}
    public Exam(int examId, String examName, String courseName, int paperId, int totalScore, Timestamp startTime, Timestamp endTime, int examTime) {
        this.examId = examId;
        this.examName = examName;
        this.courseName = courseName;
        this.paperId = paperId;
        this.totalScore = totalScore;
        this.startTime = startTime;
        this.endTime = endTime;
        this.examTime = examTime;
    }

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
