package com.loti.dao.pojo.Entity.User;

public class Teacher {
    private int teacherId;
    private String teacherName;
    private int teacherGender;
    private String teacherEmail;
    private String teacherPassword;

    Teacher(){}

    public Teacher(int teacherId, String teacherName, int teacherGender, String teacherEmail, String teacherPassword) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherGender = teacherGender;
        this.teacherEmail = teacherEmail;
        this.teacherPassword = teacherPassword;
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

    public int getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(int teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
