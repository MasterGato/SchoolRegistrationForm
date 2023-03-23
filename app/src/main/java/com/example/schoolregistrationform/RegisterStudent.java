package com.example.schoolregistrationform;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.schoolregistrationform.database.Instance;
import com.example.schoolregistrationform.database.Table;
import com.example.schoolregistrationform.models.Student;
import com.example.schoolregistrationform.utils.Fields;
import com.example.schoolregistrationform.utils.Toaster;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Random;

public class RegisterStudent extends AppCompatActivity {

    private RadioGroup rbGender;

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etMiddleName;
    private static EditText etBirthdate;
    private EditText etCourse;

    EditText[] fields;

    private Button btnDate;
    private Button btnSubmit;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        etFirstName = findViewById(R.id.et_StdFirstname);
        etLastName = findViewById(R.id.et_StdLastname);
        etMiddleName = findViewById(R.id.et_StdMiddlename2);
        etCourse = findViewById(R.id.et_course);
        etBirthdate = findViewById(R.id.et_StdBirthdate);
        etBirthdate.setEnabled(false);

        fields = new EditText[]{
                etFirstName,
                etLastName,
                etMiddleName,
                etCourse,
                etBirthdate
        };

        btnDate = findViewById(R.id.btn_Date);
        btnSubmit = findViewById(R.id.btn_stdRegSubmit);

        btnDate.setOnClickListener(e -> {
            DialogFragment fragment = new DatePickerFragment();
            fragment.show(getSupportFragmentManager(), "datePicker");
        });

        rbGender = findViewById(R.id.rb_gender);
        rbGender.setOnClickListener(e -> {
            boolean checked = ((RadioButton) e).isChecked();

            // Check which radio button was clicked
            switch (e.getId()) {
                case R.id.rb_male:
                    if (checked)
                        Log.i("Infor", "Male was clicked");
                    Log.i("Infor", "Male was clicked");

                    // Pirates are the best
                    break;
                case R.id.rb_female:
                    if (checked)
                        Log.i("Infor", "Male was clicked");

                    // Ninjas rule
                    break;
            }
        });

        btnSubmit.setOnClickListener(e -> {
            if (!Fields.areValid(fields)) {
                return;
            }

            Random random = new Random();
            Student student = new Student();

            int randomId = random.nextInt(2_000_000);

            student.setStudentId((long) randomId);
            student.setFirstName(etFirstName.getText().toString());
            student.setLastName(etLastName.getText().toString());
            student.setMiddleName(etMiddleName.getText().toString());
            student.setCourse(etCourse.getText().toString().toUpperCase());

            LocalDate birthdate = LocalDate.parse(etBirthdate.getText().toString());
            student.setBirthDay(birthdate);
            student.setAge(LocalDate.now().getYear() - birthdate.getYear());
            student.setDateRegistered(LocalDate.now());

            if (rbGender.getCheckedRadioButtonId() == R.id.rb_male) {
                student.setGender("Male");
            } else if (rbGender.getCheckedRadioButtonId() == R.id.rb_female) {
                student.setGender("Female");
            } else {
                student.setGender("Male");
            }

            saveStudent(student);
            Fields.clearFields(fields);
            Toaster.make(this, "Student saved!");
        });
    }

    private void saveStudent(Student student) {
        Instance instance = new Instance(this);
        SQLiteDatabase db = instance.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Student.CLM_STUDENTID, student.getStudentId());
        values.put(Student.CLM_FIRSTNAME, student.getFirstName());
        values.put(Student.CLM_LASTNAME, student.getLastName());
        values.put(Student.CLM_MIDDLENAME, student.getMiddleName());
        values.put(Student.CLM_BIRTHDAY, student.getBirthDay().toString());
        values.put(Student.CLM_COURSE, student.getCourse());
        values.put(Student.CLM_DATE_REGISTERED, student.getDateRegistered().toString());
        values.put(Student.CLM_GENDER, student.getGender());

        db.insert(Table.TBL_STUDENT, null, values);
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(requireContext(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            String nMonth = month < 10 ? "0" + month : String.valueOf(month);
            String nDay = day < 10 ? "0" + day : String.valueOf(day);
            String nYear = String.valueOf(year);

            String date = nYear + "-" + nMonth + "-" + nDay;
            etBirthdate.setText(date);
        }
    }

}