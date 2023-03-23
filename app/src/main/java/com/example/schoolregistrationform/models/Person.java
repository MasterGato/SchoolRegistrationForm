package com.example.schoolregistrationform.models;

public abstract class Person {

    public static final String CLM_FIRSTNAME = "first_name";
    public static final String CLM_LASTNAME = "last_name";
    public static final String CLM_MIDDLENAME =" middle_name";

    private String firstName;
    private String lastName;
    private String middleName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
