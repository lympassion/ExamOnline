package com.loti.dao.pojo.Entity.User;

import org.springframework.stereotype.Component;

@Component
public class Admin {
    int adminId;
    String adminName;
    int adminGender;
    String adminEmail;
    String adminPassword;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getAdminGender() {
        return adminGender;
    }

    public void setAdminGender(int adminGender) {
        this.adminGender = adminGender;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
