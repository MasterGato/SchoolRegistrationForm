package com.example.schoolregistrationform.utils;

import android.content.Context;
import android.widget.Toast;

public class Toaster {
    public static void make(Context context, String message) {
        Toast.makeText(context, message , Toast.LENGTH_SHORT).show();
    }
}
