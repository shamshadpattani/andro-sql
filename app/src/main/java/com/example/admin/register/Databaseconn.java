package com.example.admin.register;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databaseconn extends SQLiteOpenHelper{

    public Databaseconn(Context context) {

        super(context, "mobComputer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("Create Table StudInfo(RollNo text primary key,studName text,Mark text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists StudInfo");
    }
    //insert in DB
    public  boolean insert(String RollNo, String StudName, String Mark)
    { 
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("RollNo",RollNo);
        contentValues.put("studName",StudName);
        contentValues.put("Mark",Mark);
        long i=db.insert("StudInfo",null,contentValues);
        if (i==-1) return  false;
        else
            return true;
    }
}

