package com.loti.dao.pojo.Entity.User;

import org.springframework.stereotype.Component;

@Component
public class MyUser {
    public int userId;
    public String password;

    public final static int ROLE_STUDENT = 1;
    public final static int ROLE_TEACHER = 2;
    public final static int ROLE_ADMIN = 3;

    public final static String ADMIN_NAME = "ADMIN";
    public final static String ADMIN_PHOTO = "/img/avatar2/1.png";

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

    @Override
    public String toString() {
        return "MyUser{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                '}';
    }

    public int getRole(){
        return Integer.parseInt(String.valueOf(userId).substring(0,1));
    }
}
