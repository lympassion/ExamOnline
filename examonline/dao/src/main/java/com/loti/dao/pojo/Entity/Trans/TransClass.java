package com.loti.dao.pojo.Entity.Trans;

import org.springframework.stereotype.Component;

@Component
public class TransClass {
    int classId;
    String className;
    String courseName;
    int teacherId;
    String teacherName;
    int studentCnt;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getStudentCnt() {
        return studentCnt;
    }

    public void setStudentCnt(int studentCnt) {
        this.studentCnt = studentCnt;
    }
}
