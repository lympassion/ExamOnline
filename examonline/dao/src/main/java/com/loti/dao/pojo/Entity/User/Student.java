package com.loti.dao.pojo.Entity.User;


import com.loti.dao.pojo.Entity.Class;

public class Student extends User{
    private String username;
    private boolean gender;
    private Class s_class;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Class getS_class() {
        return s_class;
    }

    public void setS_class(Class s_class) {
        this.s_class = s_class;
    }
}
