package com.loti.dao.pojo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class StudentPicture {
    int studentPictureId;
    int studentId;
    int examId;
    String picturePath;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    Timestamp pictureTime;

    public int getStudentPictureId() {
        return studentPictureId;
    }

    public void setStudentPictureId(int studentPictureId) {
        this.studentPictureId = studentPictureId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Timestamp getPictureTime() {
        return pictureTime;
    }

    public void setPictureTime(Timestamp pictureTime) {
        this.pictureTime = pictureTime;
    }
}
