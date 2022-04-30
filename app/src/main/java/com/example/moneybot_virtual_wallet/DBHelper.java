package com.example.moneybot_virtual_wallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        sqlDB.execSQL("create Table users(username TEXT primary key, password TEXT, email TEXT unique, phone TEXT)");
        sqlDB.execSQL("create Table cards(username TEXT primary key, cardnum TEXT, expiration TEXT, cvv TEXT)");
        sqlDB.execSQL("create Table banks(account TEXT primary key, routing TEXT, bankname TEXT, cardholder TEXT)");
        sqlDB.execSQL("create Table user_bank_accounts(account TEXT primary key ,username TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i1) {
        sqlDB.execSQL("drop Table if exists users");
        sqlDB.execSQL("drop Table if exists cards");
        sqlDB.execSQL("drop Table if exists banks");
        sqlDB.execSQL("drop Table if exists user_bank_accounts");
        onCreate(sqlDB);
    }

    // USER LOGIN DATA METHODS
    public boolean insertData(String username, String password, String email, String phone) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        long result = sqlDB.insert("users", null, contentValues);

        // If insertion succeeds
        return result != -1;
    }

    public void updateUserNotPass(String username, String password, String email, String phone) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("phone", phone);

        sqlDB.update("users", contentValues, "username = ?", new String[] {username});
    }

    public void updateUserAndPassword(String username, String password, String email, String phone) throws NoSuchAlgorithmException {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String pass = username + password;

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(pass.getBytes());
        byte[] arr = md.digest();
        StringBuilder sb = new StringBuilder();
        for(byte b: arr)
            sb.append(Integer.toHexString(b & 0xFF));

        String hashed_pass = sb.toString();

        contentValues.put("username", username);
        contentValues.put("password", hashed_pass);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        sqlDB.update("users", contentValues, "username = ?", new String[] {username});
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

    protected String[] getUserInfo(String username) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        Cursor cursor = sqlDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if(cursor != null)
            cursor.moveToFirst();

        return new String[] {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)};
    }

    // CARDS TABLE METHODS
    public boolean insertCardData(String username, String card, String expiration, String cvv) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("card", card);
        contentValues.put("expiration", expiration);
        contentValues.put("cvv", cvv);
        long result = sqlDB.insert("cards", null, contentValues);

        // If insertion succeeds    -- If it does not then generate new random card number
        return result != -1;
    }

    protected Card getCard(String username) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        Cursor cursor = sqlDB.rawQuery("Select * from cards where username = ?", new String[] {username});
        if(cursor != null)
            cursor.moveToFirst();

        return new Card(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
    }

    // BANKS TABLE METHODS
    public boolean insertBankData(String bankname, String cardholder, String account, String routing, String username) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("account", account);
        contentValues.put("routing", routing);
        contentValues.put("bankname", bankname);
        contentValues.put("cardholder", cardholder);
        long result = sqlDB.insert("banks", null, contentValues);

        if(result != -1) {
            ContentValues cv = new ContentValues();
            cv.put("account", account);
            cv.put("username", username);
            sqlDB.insert("user_bank_accounts", null, cv);
        }

        // If insertion succeeds
        return result != -1;
    }

    public boolean checkBankAccount(String account) {
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        Cursor cursor = sqlDB.rawQuery("Select * from banks where account = ?", new String[] {account});

        // If account already exists in database
        return cursor.getCount() > 0;
    }


}
