package com.loti.dao.pojo.Entity;

import org.springframework.stereotype.Component;

@Component
public class StudentPaper {
    int recordId;
    int examId;
    int studentId;
    int studentMark;
    int scorePart1;
    int scorePart2;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(int studentMark) {
        this.studentMark = studentMark;
    }

    public int getScorePart1() {
        return scorePart1;
    }

    public void setScorePart1(int scorePart1) {
        this.scorePart1 = scorePart1;
    }

    public int getScorePart2() {
        return scorePart2;
    }

    public void setScorePart2(int scorePart2) {
        this.scorePart2 = scorePart2;
    }
}
