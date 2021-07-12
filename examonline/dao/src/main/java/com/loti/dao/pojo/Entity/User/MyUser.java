package com.loti.dao.pojo.Entity.User;

import org.springframework.stereotype.Component;

@Component
public class MyUser {
    public int userId;
    public String password;

    public final static String ROLE_STUDENT = "1";
    public final static String ROLE_TEACHER = "2";
    public final static String ROLE_ADMIN = "3";

    MyUser() {}

    public MyUser(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getRoleStudent() {
        return ROLE_STUDENT;
    }

    public static String getRoleTeacher() {
        return ROLE_TEACHER;
    }

    public static String getRoleAdmin() {
        return ROLE_ADMIN;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                '}';
    }

    public String getRole(){
        return String.valueOf(userId).substring(0,1);
    }
}
