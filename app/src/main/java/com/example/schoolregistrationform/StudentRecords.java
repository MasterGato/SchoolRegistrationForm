package com.example.schoolregistrationform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;

import com.example.schoolregistrationform.database.Instance;
import com.example.schoolregistrationform.models.Student;
import com.example.schoolregistrationform.models.StudentAdapter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRecords extends AppCompatActivity {

    private StudentAdapter adapter;
    private RecyclerView rv;
    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_records);

        students = new ArrayList<>();

        Instance instance = new Instance(this);
        SQLiteDatabase db = instance.getReadableDatabase();

        if (getIntent().hasExtra("student_id")) {
            String query = "SELECT * FROM STUDENTS WHERE student_id = " + getIntent().getStringExtra("student_id");
            Student student = new Student();
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToNext()) {
                student.setStudentId(cursor.getLong(0));
                student.setFirstName(cursor.getString(1));
                student.setLastName(cursor.getString(2));
                student.setMiddleName(cursor.getString(3));
                student.setGender(cursor.getString(4));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    student.setBirthDay(LocalDate.parse(cursor.getString(5)));
                    student.setDateRegistered(LocalDate.parse(cursor.getString(6)));
                    student.setCourse(cursor.getString(7));
                }
            }

            students.add(student);
        } else if (getIntent().hasExtra("student_name")) {
            String query = "SELECT * FROM STUDENTS WHERE last_name = " + "'" + getIntent().getStringExtra("student_name") + "'";
            Cursor cursor = db.rawQuery(query, null);

            while (cursor.moveToNext()) {
                Student student = new Student();

                student.setStudentId(cursor.getLong(0));
                student.setFirstName(cursor.getString(1));
                student.setLastName(cursor.getString(2));
                student.setMiddleName(cursor.getString(3));
                student.setGender(cursor.getString(4));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    student.setBirthDay(LocalDate.parse(cursor.getString(5)));
                    student.setDateRegistered(LocalDate.parse(cursor.getString(6)));
                    student.setCourse(cursor.getString(7));
                }

                students.add(student);

            }

        } else if (getIntent().hasExtra("student_course")) {
            String query = "SELECT * FROM STUDENTS WHERE course = " +  "'" + getIntent().getStringExtra("student_course") + "'";
            Cursor cursor = db.rawQuery(query, null);

            while (cursor.moveToNext()) {
                Student student = new Student();

                student.setStudentId(cursor.getLong(0));
                student.setFirstName(cursor.getString(1));
                student.setLastName(cursor.getString(2));
                student.setMiddleName(cursor.getString(3));
                student.setGender(cursor.getString(4));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    student.setBirthDay(LocalDate.parse(cursor.getString(5)));
                    student.setDateRegistered(LocalDate.parse(cursor.getString(7)));
                    student.setCourse(cursor.getString(8));
                }

                students.add(student);
            }

        } else {
            loadStudents();
        }

        rv = findViewById(R.id.rv_StudentRecords);
        adapter = new StudentAdapter(students);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadStudents() {
        Instance instance = new Instance(this);
        SQLiteDatabase db = instance.getReadableDatabase();

        String query = "SELECT student_id, first_name, last_name FROM Students";
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            Student student = new Student();
            student.setStudentId(cursor.getLong(0));
            student.setFirstName(cursor.getString(1));
            student.setLastName(cursor.getString(2));

            students.add(student);
        }
    }
}