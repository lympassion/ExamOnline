package com.loti.dao.pojo.Entity.User;

public class Teacher extends User{
    private String username;
    private boolean gender;

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
}
