package com.example.schoolregistrationform.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.schoolregistrationform.database.Instance;
import com.example.schoolregistrationform.database.Table;
import com.example.schoolregistrationform.models.Student;

import java.time.LocalDate;

public class StudentData {

    static Instance instance;
    static SQLiteDatabase sql;

    public static void genrateData(Context context) {

        instance = new Instance(context);

        sql = instance.getWritableDatabase();

        LocalDate now = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            now = LocalDate.now();
        }
        GenerateId gen_id = new GenerateId(context);

        for(int i = 0; i < 10; i++){
            for (int x = 0; x < fname.length; x++) {

                ContentValues vc = new ContentValues();
                vc.put(Student.CLM_STUDENTID, gen_id.createStudentId());
                vc.put(Student.CLM_FIRSTNAME, fname[x]);
                vc.put(Student.CLM_LASTNAME, lname[x]);
                vc.put(Student.CLM_MIDDLENAME, mname[x]);
                vc.put(Student.CLM_GENDER, gender[x]);
                vc.put(Student.CLM_BIRTHDAY, birthdate[x]);
                vc.put(Student.CLM_DATE_REGISTERED, String.valueOf(now));
                vc.put(Student.CLM_COURSE, course[x]);

                sql.insert(Table.TBL_STUDENT, null, vc);

            }
        }



    }


    static String fname[] = {
            "John Michael",
            "Jan Christian",
            "Kenneth",
            "Ritz",
            "Bryan",
            "Bryan",
            "Brian",
            "Jamil",
            "CJ",
            "Jasper",
            "Xavier",
            "Armen",
            "Jules",
            "Hanalyn",
            "RJ",
            "James",
            "Angelo",
            "Angel",
            "Neil",
            "Krissh"
    };
    static String lname[] = {
            "Domingo",
            "Egasan",
            "Calibara",
            "Dela Cruz",
            "Muyco",
            "Barba",
            "Zy",
            "Ang",
            "Dilo",
            "Cruz",
            "Santos",
            "Reyes",
            "Tupas",
            "Aquino",
            "Marcus",
            "Pingoy",
            "Cezar",
            "Lee",
            "Vergara",
            "De Leon"
    };

    static String mname[] = {
            "Tupas",
            "Aquino",
            "Marcus",
            "Pingoy",
            "Cezar",
            "Lee",
            "Vergara",
            "De Leon",
            "Domingo",
            "Egasan",
            "Calibara",
            "Dela Cruz",
            "Muyco",
            "Barba",
            "Zy",
            "Ang",
            "Dilo",
            "Cruz",
            "Santos",
            "Reyes"
    };
    static String gender[] = {
            "Male",
            "Male",
            "Female",
            "Male",
            "Female",
            "Male",
            "Male",
            "Female",
            "Male",
            "Female",
            "Male",
            "Male",
            "Female",
            "Male",
            "Female",
            "Male",
            "Male",
            "Female",
            "Male",
            "Female"
    };

    static String birthdate[] = {
            "2001-03-01",
            "2001-03-02",
            "2001-03-03",
            "2001-03-04",
            "2001-03-05",
            "2001-03-01",
            "2001-03-02",
            "2001-03-03",
            "2001-03-04",
            "2001-03-05",
            "2001-03-01",
            "2001-03-02",
            "2001-03-03",
            "2001-03-04",
            "2001-03-05",
            "2001-03-01",
            "2001-03-02",
            "2001-03-03",
            "2001-03-04",
            "2001-03-05",
    };

    static String[] course = {
            "BSIT",
            "BSTM",
            "BSBA",
            "BSIS",
            "BMMA",
            "BSIT",
            "BSTM",
            "BSBA",
            "BSIS",
            "BMMA",
            "BSIT",
            "BSTM",
            "BSBA",
            "BSIS",
            "BMMA",
            "BSIT",
            "BSTM",
            "BSBA",
            "BSIS",
            "BMMA"
    };

}
