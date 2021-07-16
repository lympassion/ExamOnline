package com.loti.controller.trans;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class ExamMsg {
    String examName;
    String courseName;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    Timestamp startTime;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    Timestamp endTime;
    int timeLong;
    int paperId;
    String classIdList;

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

    public int getTimeLong() {
        return timeLong;
    }

    public void setTimeLong(int timeLong) {
        this.timeLong = timeLong;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getClassIdList() {
        return classIdList;
    }

    public void setClassIdList(String classIdList) {
        this.classIdList = classIdList;
    }
}
