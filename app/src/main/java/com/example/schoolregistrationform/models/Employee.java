package com.example.schoolregistrationform.models;

import android.graphics.Bitmap;

public class Employee extends Person{

    public static final String CLM_FIRST_NAME = "first_name";
    public static final String CLM_LAST_NAME = "last_name";
    public static final String CLM_MIDDLE_NAME = "middle_name";
    public static final String CLM_EMPLOYEE_ID = "employee_id";
    public static final String CLM_USERNAME = "username";
    public static final String CLM_PASSWORD = "password";
    public static final String CLM_PROFILE = "profile";

    private Long employeeId;
    private String userName;
    private String password;
    private Bitmap profile;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bitmap getProfile() {
        return profile;
    }

    public void setProfile(Bitmap profile) {
        this.profile = profile;
    }
}

