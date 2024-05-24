package com.example.taskrabbit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(@Nullable Context context) {
        super(context, "TaskRabbit.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "CREATE TABLE users (username TEXT, email TEXT, password TEXT)";
        sqLiteDatabase.execSQL(qry1);
        String qry2 = "CREATE TABLE cart (username TEXT, product TEXT, price REAL, otype TEXT)";
        sqLiteDatabase.execSQL(qry2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS cart");
        onCreate(db);
    }

    public void register(String name, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("username", name);
        cv.put("email", email);
        cv.put("password", password);

        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }

    public int login(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM users WHERE email = ? AND password = ?", new String[]{email, password});
        if (cr.getCount() > 0) {
            cr.close();
            return 1;
        } else {
            cr.close();
            return 0;
        }
    }
}
