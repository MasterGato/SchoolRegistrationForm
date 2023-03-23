package com.example.schoolregistrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class ContactUs extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPhone;
    private EditText etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_number);
        etAddress = findViewById(R.id.et_address);

        etEmail.setEnabled(false);
        etPhone.setEnabled(false);
        etAddress.setEnabled(false);

        etEmail.setText("theadelle.roda@koronadal.sti.edu.ph");
        etPhone.setText("(083)-228-5989");
        etAddress.setText("Brgy. Santa Luia St, Poblacion, Koronadal City, 9506, South Cotaato");
    }
}