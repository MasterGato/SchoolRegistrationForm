package com.example.schoolregistrationform;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.schoolregistrationform.database.Instance;
import com.example.schoolregistrationform.models.Student;

import org.w3c.dom.Text;

import java.time.LocalDate;

public class StudentInformation extends AppCompatActivity {

    private TextView tvId;
    private TextView tvName;
    private TextView tvBirthday;
    private TextView tvCourse;
    private TextView tvGender;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_information);

        tvId = findViewById(R.id.tv_student_id);
        tvName = findViewById(R.id.tv_name);
        tvBirthday = findViewById(R.id.tv_bday);
        tvCourse = findViewById(R.id.tv_course);
        tvGender = findViewById(R.id.tv_gender);

        String studentId = getIntent().getStringExtra("student_id");

        Instance instance = new Instance(this);
        SQLiteDatabase db = instance.getReadableDatabase();
        String query = "SELECT * FROM Students WHERE student_id = " + studentId;
        Cursor cursor = db.rawQuery(query, null);

        Student student = new Student();
        if (cursor.moveToNext()) {
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
        }

        int age = LocalDate.now().getYear() - student.getBirthDay().getYear();

        tvId.setText(String.valueOf(student.getStudentId()));
        tvName.setText(student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName());
        tvBirthday.setText(student.getBirthDay().toString() + " ( " + age + " years old)");
        tvCourse.setText(student.getCourse());
        tvGender.setText(student.getGender());
    }
}