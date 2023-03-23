package com.example.schoolregistrationform.database;

import com.example.schoolregistrationform.models.Course;
import com.example.schoolregistrationform.models.Employee;
import com.example.schoolregistrationform.models.Student;

public class Schema {

    public static final String DROP_TBL_STUDENT = "DROP TABLE IF EXISTS " + Table.TBL_STUDENT;
    public static final String DROP_TBL_EMPLOYEE = "DROP TABLE IF EXISTS " + Table.TBL_EMPLOYEE;
    public static final String DROP_TBL_COURSE = "DROP TABLE IF EXISTS " + Table.TBL_COURSE;

    public static final String CREATE_TBL_STUDENT = "CREATE TABLE " + Table.TBL_STUDENT +" (" +
            Student.CLM_STUDENTID  + " INTEGER PRIMARY KEY," +
            Student.CLM_FIRSTNAME + " TEXT," +
            Student.CLM_LASTNAME + " TEXT," +
            Student.CLM_MIDDLENAME + " TEXT," +
            Student.CLM_GENDER + " TEXT," +
            Student.CLM_BIRTHDAY + " DATE," +
            Student.CLM_AGE + " INTEGER," +
            Student.CLM_DATE_REGISTERED + " DATE," +
            Student.CLM_COURSE + " TEXT)";

    public static final String CREATE_TBL_EMPLOYEE = "CREATE TABLE " + Table.TBL_EMPLOYEE + " (" +
            Employee.CLM_EMPLOYEE_ID + " INTEGER PRIMARY KEY," +
            Employee.CLM_USERNAME + " TEXT UNIQUE," +
            Employee.CLM_PASSWORD + " TEXT," +
            Employee.CLM_FIRSTNAME + " TEXT," +
            Employee.CLM_LAST_NAME  + " TEXT," +
            Employee.CLM_MIDDLENAME + " TEXT, " +
            Employee.CLM_PROFILE +" BLOB)";

    public static final String CREATE_TBL_COURSE = "CREATE TABLE " + Table.TBL_COURSE + "(" +
            Course.CLM_ID + " INT PRIMARY KEY," +
            Course.CLM_CODE + " TEXT," +
            Course.CLM_NAME + " TEXT)";

}
