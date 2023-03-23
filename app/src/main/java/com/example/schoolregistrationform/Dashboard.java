package com.example.schoolregistrationform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

public class Dashboard extends AppCompatActivity {

    private CardView cvRegister;
    private CardView cvSearchStudent;
    private CardView cvManage;
    private CardView cvContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cvSearchStudent = findViewById(R.id.cv_search);
        cvSearchStudent.setOnClickListener(e -> {
            Intent intent = new Intent(this, SearchStudent.class);
            startActivity(intent);
        });

        cvManage = findViewById(R.id.cv_manage);
        cvManage.setOnClickListener(e -> {
            Intent intent = new Intent(this, manage_student.class);
            startActivity(intent);
        });

        cvContactUs = findViewById(R.id.cv_contact);
        cvContactUs.setOnClickListener(e -> {
            Intent intent = new Intent(this, ContactUs.class);
            startActivity(intent);
        });
        cvRegister = findViewById(R.id.cv_register);
        cvRegister.setOnClickListener(e -> {
            Intent intent = new Intent(this, RegisterStudent.class);
            startActivity(intent);
        });
    }
}