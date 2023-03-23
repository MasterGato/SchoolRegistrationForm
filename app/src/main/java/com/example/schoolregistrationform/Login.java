package com.example.schoolregistrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolregistrationform.database.Instance;
import com.example.schoolregistrationform.database.Table;
import com.example.schoolregistrationform.utils.StudentData;
import com.example.schoolregistrationform.utils.Toaster;

public class Login extends AppCompatActivity {

    private Context context;

    private Instance instance;
    private SQLiteDatabase db;

    private TextView signUp;

    private EditText etUsername;
    private EditText etPassword;

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StudentData.genrateData(this);

        context = this;
        instance = new Instance(this);
        db = instance.getReadableDatabase();

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        btnLogin = findViewById(R.id.btn_login);
        signUp = findViewById(R.id.tv_signup);

        signUp.setOnClickListener(e -> {
            Intent intent = new Intent(this, RegisterEmployee.class);
            startActivity(intent);
        });
        btnLogin.setOnClickListener(e -> {
            Instance instance = new Instance(this);
            SQLiteDatabase db = instance.getReadableDatabase();
            Cursor cursor = db.query(
                    Table.TBL_EMPLOYEE,
                    new String[]{"username", "password"},
                    null,
                    null,
                    null,
                    null,
                    null
            );

            while (cursor.moveToNext()) {
                Log.i("Username", cursor.getString(0));
                Log.i("Password", cursor.getString(1));

                String currentUsername = etUsername.getText().toString();
                String currentPassword = etPassword.getText().toString();

                if (currentPassword.equals(cursor.getString(1)) &&
                        currentUsername.equals(cursor.getString(0))
                ) {
                    Toaster.make(this, "Welcome " + currentUsername + "!");

                    Intent intent = new Intent(this, Dashboard.class);
                    startActivity(intent);
                }
            }

            Toaster.make(context, "No user with " + etUsername.getText().toString() + " found");
        });
    }
}