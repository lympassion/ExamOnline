package com.loti.dao.pojo.Entity;

import org.springframework.stereotype.Component;

@Component
public class Classe {
    int classId;
    String courseName;
    int teacherId;
    String className;
    int studentCnt;

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
}
