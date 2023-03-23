package com.example.schoolregistrationform.utils;

import android.widget.EditText;

public class Fields {
    public static boolean areValid(EditText[] fields) {
        for (EditText field : fields) {
            if (field.getText().toString().isEmpty()) {
                setError(fields, "Field cannot be empty");
                return false;
            }
        }

        return true;
    }

    public static void clearFields(EditText[] fields) {
        for (EditText field : fields) {
            field.setText("");
        }
    }

    public static boolean passwordMatch(EditText password1, EditText password2) {
        String passwordOne = password1.getText().toString();
        String passwordTwo = password2.getText().toString();

        if(!passwordIsValid(password1, password2)){
            return true;
        }

        if (passwordOne.equals(passwordTwo)) {
            return true;
        }

        password1.setError("Password do not match");
        password2.setError("Password do not match");

        return false;
    }
    public static boolean passwordIsValid(EditText password1, EditText password2){
        if(password1.length()<8 && password2.length()<8){
            setError(new EditText[]{password1, password2}, "Must be atleast eight characters.");
            return false;


        }


        return true;
    }

    public static void setError(EditText[] fields, String message) {
        for (EditText field: fields) {
            field.setError(message);
        }
    }
}
