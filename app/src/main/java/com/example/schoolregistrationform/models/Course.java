package com.example.schoolregistrationform.models;

public class Course {

    public static final String CLM_ID = "course_id";
    public static final String CLM_CODE = "course_code";
    public static final String CLM_NAME = "course_name";

    private Long courseId;
    private String coureCode;
    private String name;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCoureCode() {
        return coureCode;
    }

    public void setCoureCode(String coureCode) {
        this.coureCode = coureCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
