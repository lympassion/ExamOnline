package com.loti.dao.pojo.Entity;

import org.springframework.stereotype.Component;

@Component
public class StudentClass {
    int id;
    int studentId;
    int classId;

    StudentClass(){}
    public StudentClass(int id, int studentId, int classId) {
        this.id = id;
        this.studentId = studentId;
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
