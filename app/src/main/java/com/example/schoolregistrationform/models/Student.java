package com.example.schoolregistrationform.models;

import android.content.Intent;

import java.time.LocalDate;

public class Student extends Person {

    public static final String CLM_STUDENTID = "student_id";
    public static final String CLM_GENDER = "gender";
    public static final String CLM_BIRTHDAY = "birthday";
    public static final String CLM_DATE_REGISTERED = "date_registered";
    public static final String CLM_COURSE = "course";
    public static final String CLM_AGE = "age";

    private Long studentId;
    private String gender;
    private LocalDate birthDay;
    private LocalDate dateRegistered;
    private String course;
    private Integer age;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDate dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
