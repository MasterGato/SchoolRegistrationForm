package com.example.schoolregistrationform.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Instance extends SQLiteOpenHelper {

    private static final String DB_NAME = "School.db";
    private static final  Integer VERSION = 1;

    public Instance(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Schema.CREATE_TBL_STUDENT);
        db.execSQL(Schema.CREATE_TBL_EMPLOYEE);
        db.execSQL(Schema.CREATE_TBL_COURSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Schema.DROP_TBL_STUDENT);
        db.execSQL(Schema.DROP_TBL_EMPLOYEE);
        db.execSQL(Schema.DROP_TBL_COURSE);

        onCreate(db);

    }
}
