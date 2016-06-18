package com.example.shimanhsu4590.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by shimanhsu4590 on 6/18/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Chitkara.db";
    private static final String TABLE_NAME = "student_attendance_sheet";
    private static String COLUMN_ID = "id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_EMAIL = "email_id";
    private static final String COLUMN_STUDENT_NAME = "student_name";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ATTENDANCE = "ATTENDANCE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         final String query =  "CREATE TABLE "+ TABLE_NAME + " ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "+
                COLUMN_USER_NAME + " TEXT NOT NULL, " +
                COLUMN_EMAIL + " TEXT NOT NULL, " +
                COLUMN_STUDENT_NAME + " TEXT NOT NULL, " +
                COLUMN_PASSWORD + " TEXT NOT NULL, " +
                COLUMN_ATTENDANCE + " INTEGER ); ";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertStudentInfo(Chitkara c) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, c.getUname());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_STUDENT_NAME, c.getName());
        values.put(COLUMN_PASSWORD, c.getPass());
        values.put(COLUMN_ATTENDANCE,0);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public boolean matchPassword(String userName,String password) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from " + TABLE_NAME + " where "+COLUMN_USER_NAME +" = '" + userName + "';";
        Cursor cursor = db.rawQuery(query, null);
        boolean passwordMatched = false;
        String passwordInDataBase = null;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Log.e("password123", cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
            passwordInDataBase =  cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
            if(passwordInDataBase.equals(password)){
                passwordMatched = true;
                break;
            }
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return passwordMatched;
    }


}
