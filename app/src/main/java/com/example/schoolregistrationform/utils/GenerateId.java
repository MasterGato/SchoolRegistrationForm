package com.example.schoolregistrationform.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.schoolregistrationform.database.Instance;
import com.example.schoolregistrationform.database.Table;
import com.example.schoolregistrationform.models.Student;
;
import java.util.Random;

public class GenerateId {

    private Instance instance;
    private SQLiteDatabase sql;

    public GenerateId(Context context){
        instance = new Instance(context);
        sql = instance.getReadableDatabase();
    }

    public String createStudentId(){
        Random ran = new Random();
        String num = "0123456789";
        String id = "2002";
        for(int x = 0; x  < 6; x++){
            int getNum = ran.nextInt(9);
            id = id +  num.charAt(getNum);
        }
        String query = "SELECT * FROM " + Table.TBL_STUDENT + " WHERE " + Student.CLM_STUDENTID + " = ?";
        String col[] = {id};
        Cursor cursor = sql.rawQuery(query, col);
        while(cursor.moveToNext()){
            System.out.println(id +" __ " + cursor.getString(0));
            if(id.equals(cursor.getString(0))){
                createStudentId();
                break;
            }
        }
        return id;
    }
}
