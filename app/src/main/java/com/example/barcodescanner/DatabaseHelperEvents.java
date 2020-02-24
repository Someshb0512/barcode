package com.example.barcodescanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.autofill.FillEventHistory;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelperEvents extends SQLiteOpenHelper
{



    public static final String DATABASE_NAME = "barcode.db";

    public DatabaseHelperEvents(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void createDatabase(DatabaseHelperEvents db) {
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        sqLiteDatabase.execSQL("CREATE TABLE events(admission TEXT PRIMARY KEY AUTOINCREMENT , name TEXT , room TEXT, phone TEXT)");
        Log.d("Table","Table Created.");
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("123","User Created!");
        Log.d("Object","Object Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS events");
    }



    public boolean InsertEvent(String admission, String name , String room, String phone){
        Log.d("Table","Table Insertion Started.");
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ADMISSION NO", admission);
        contentValues.put("Name", name);
        contentValues.put("Room No." , room);
        contentValues.put("Phone No." , phone);
        long result = sqLiteDatabase.insert("events", null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

}