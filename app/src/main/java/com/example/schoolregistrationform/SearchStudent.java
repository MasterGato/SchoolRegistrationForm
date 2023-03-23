
package com.example.schoolregistrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SearchStudent extends AppCompatActivity {

    private EditText etStudentId;
    private EditText etStudentName;
    private EditText etStudentCourse;

    private Button btnRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);

        etStudentId = findViewById(R.id.et_student_id);
        etStudentName = findViewById(R.id.et_student_name);
        etStudentCourse =findViewById(R.id.et_search_course);

        btnRecords = findViewById(R.id.btn_view_records);
        btnRecords.setOnClickListener(e -> {
            if (!etStudentId.getText().toString().isEmpty()) {
                Intent intent = new Intent(this, StudentRecords.class);
                intent.putExtra("student_id", etStudentId.getText().toString());
                startActivity(intent);
            }

            else if (!etStudentName.getText().toString().isEmpty()) {
                Intent intent = new Intent(this, StudentRecords.class);
                intent.putExtra("student_name", etStudentName.getText().toString());
                startActivity(intent);
            }

            else if (!etStudentCourse.getText().toString().isEmpty()) {
                Intent intent = new Intent(this, StudentRecords.class);
                intent.putExtra("student_course", etStudentCourse.getText().toString().toUpperCase());
                startActivity(intent);
            }

            else {
                Intent intent = new Intent(this, StudentRecords.class);
                startActivity(intent);
            }
        });
    }
}
