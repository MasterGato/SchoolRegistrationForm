package com.example.schoolregistrationform;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolregistrationform.database.Instance;
import com.example.schoolregistrationform.database.Table;
import com.example.schoolregistrationform.models.Student;

import java.time.LocalDate;

public class ManageStudent extends AppCompatActivity {

    private EditText et_fname, et_mname, et_lname, et_course, etId;
    private Button btn_update, btn_cancel, btn_search, btn_back;
    Instance instance;
    SQLiteDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        instance = new Instance(this);

        sql = instance.getWritableDatabase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_student);

        etId = findViewById(R.id.et_stu_id);
        et_fname = findViewById(R.id.et_mngFname);
        et_mname = findViewById(R.id.et_mngMname);
        et_lname = findViewById(R.id.et_mngLname);
        et_course = findViewById(R.id.et_mngCourse);

        btn_update = findViewById(R.id.btn_Update);
        btn_search = findViewById(R.id.btn_Search);

        btn_search.setOnClickListener(e -> {
            if (etId.getText().toString().isEmpty()) {
                etId.setError("Id cannot be empty...");
                return;
            }

            String query = "SELECT * FROM STUDENTS WHERE student_id = " + etId.getText().toString();
            SQLiteDatabase db = instance.getReadableDatabase();
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

            etId.setText(String.valueOf(student.getStudentId()));
            et_fname.setText(student.getFirstName());
            et_lname.setText(student.getLastName());
            et_mname.setText(student.getMiddleName());
            et_course.setText(student.getCourse());
//
//            String query = "SELECT * FROM Students WHERE student_id = " + Long.valueOf(etId.getText().toString());
//            Cursor cursor = sql.rawQuery(query, null);
//
//            Student student = new Student();
//            student.setStudentId(cursor.getLong(0));
//            student.setFirstName(cursor.getString(1));
//            student.setMiddleName(cursor.getString(2));
//            student.setLastName(cursor.getString(3));
//            student.setCourse(cursor.getString(8));
//
//            etId.setText(String.valueOf(student.getStudentId()));
//            et_fname.setText(student.getFirstName());
//            et_lname.setText(student.getLastName());
//            et_mname.setText(student.getMiddleName());
//            et_course.setText(student.getCourse());
        });

        btn_update.setOnClickListener(new Update());
//        e -> {
//            if (!Fields.areValid(new EditText[]{
//                    etId, et_fname, et_lname, et_mname, et_course
//            })) {
//                Fields.setError(new EditText[]{
//                        etId, et_fname, et_lname, et_mname, et_course
//                }, "Cannot be empty...");
//                return;
//            }
//
//            String[] columns = {"student_id", "first_name", "last_name", "middle_name", "course"};
//            ContentValues values = new ContentValues()
//        }

    }

    class Update implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String id = etId.getText().toString();
            String fname = et_fname.getText().toString();
            String lname = et_lname.getText().toString();
            String mname = et_mname.getText().toString();
            String course = et_course.getText().toString();

            String field[] = {fname, lname, mname, course};
            update_Student(id, fname, lname, mname, course);

//
//            if (checkEmptyField(field)) {
//                Toast.makeText(manage_student.this, "Enter all required field", Toast.LENGTH_SHORT).show();
//            } else {
//                update_Student(id, fname, lname, mname, course);
//            }

        }
//
//        public boolean checkEmptyField(String field[]) {
//            boolean isField = true;
//            for (int x = 0; x < field.length; x++) {
//                if (field[x].isEmpty()) {
//                    isField = false;
//                    break;
//                }
//            }
//            return isField;
//        }

        private void update_Student(String id, String fname, String lname, String mname, String course) {

            ContentValues cv = new ContentValues();

            cv.put(Student.CLM_STUDENTID, id);
            cv.put(Student.CLM_FIRSTNAME, fname);
            cv.put(Student.CLM_LASTNAME, lname);
            cv.put(Student.CLM_MIDDLENAME, mname);
            cv.put(Student.CLM_COURSE, course);

            String selection = Student.CLM_STUDENTID + " LIKE ?";
            String[] whereArgs = {id};
            sql.update(
                    Table.TBL_STUDENT,
                    cv,
                    selection,
                    whereArgs
            );
        }
    }

}