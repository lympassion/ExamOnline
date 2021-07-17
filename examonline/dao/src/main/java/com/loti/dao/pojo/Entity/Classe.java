package com.loti.dao.pojo.Entity;

import org.springframework.stereotype.Component;

@Component
public class Classe {
    int classId;
    String courseName;
    int teacherId;
    int examId;
    String className;
    int studentCnt;

    Classe(){}

    public Classe(int classId, String courseName, int teacherId, int examId, String className, int studentCnt) {
        this.classId = classId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.examId = examId;
        this.className = className;
        this.studentCnt = studentCnt;
    }

    public Classe(int classId, String courseName, int teacherId, String className, int studentCnt) {
        this.classId = classId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.className = className;
        this.studentCnt = studentCnt;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStudentCnt() {
        return studentCnt;
    }

    public void setStudentCnt(int studentCnt) {
        this.studentCnt = studentCnt;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}
