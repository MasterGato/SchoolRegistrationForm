package com.example.schoolregistrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.schoolregistrationform.database.Instance;
import com.example.schoolregistrationform.database.Table;
import com.example.schoolregistrationform.models.Employee;
import com.example.schoolregistrationform.utils.Fields;

public class RegisterEmployee extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etMiddleName;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etPasswordRetype;

    private EditText[] fields;

    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_employee);

        etFirstName = findViewById(R.id.et_FirstName);
        etLastName = findViewById(R.id.et_LastName);
        etMiddleName = findViewById(R.id.et_MiddleName);
        etUsername = findViewById(R.id.et_RegUsername);
        etPassword = findViewById(R.id.et_RegPassword);
        etPasswordRetype = findViewById(R.id.et_RegPasswordConfirm);

        fields = new EditText[] {
                etFirstName, etLastName,
                etUsername, etPasswordRetype, etPassword,
        };

        btnRegister = findViewById(R.id.btn_Register);
        btnRegister.setOnClickListener(e -> {
            if (!Fields.areValid(fields)) {
                return;
            }

            if (!Fields.passwordMatch(etPassword, etPasswordRetype)) {
                return;
            }

            Employee employee = new Employee();

            employee.setFirstName(etFirstName.getText().toString());
            employee.setLastName(etLastName.getText().toString());
            employee.setMiddleName(etMiddleName.getText().toString());
            employee.setUserName(etUsername.getText().toString());
            employee.setPassword(etPassword.getText().toString());

            saveEmployee(employee);

            finish();
        });
    }

    private void saveEmployee(Employee employee) {
        Instance instance = new Instance(this);
        SQLiteDatabase db = instance.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Employee.CLM_FIRST_NAME, employee.getFirstName());
        values.put(Employee.CLM_LAST_NAME, employee.getLastName());
        values.put(Employee.CLM_MIDDLE_NAME, employee.getMiddleName());
        values.put(Employee.CLM_USERNAME, employee.getUserName());
        values.put(Employee.CLM_PASSWORD, employee.getPassword());
        db.insert(Table.TBL_EMPLOYEE, null, values);
    }
}