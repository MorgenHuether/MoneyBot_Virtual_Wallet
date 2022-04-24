package com.example.moneybot_virtual_wallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        sqlDB.execSQL("create Table users(username TEXT primary key, password TEXT, email TEXT unique, phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i1) {
        sqlDB.execSQL("drop Table if exists users");
    }

    public boolean insertData(String username, String password, String email, String phone) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        long result = sqlDB.insert("users", null, contentValues);

        // If insertion fails
        return result != -1;
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        Cursor cursor = sqlDB.rawQuery("Select * from users where username = ?", new String[] {username});

        // If user exists in database
        return cursor.getCount() > 0;
    }

    public boolean checkUsernamePass(String username, String password) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        Cursor cursor = sqlDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});

        return cursor.getCount() > 0;

    }

    public boolean checkEmail(String email) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        Cursor cursor = sqlDB.rawQuery("Select * from users where email = ?", new String[] {email});

        return cursor.getCount() > 0;
    }
}
