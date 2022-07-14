package com.kierasis.projecthope.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "ProjectHopeLogs.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(name TEXT primary key, contact TEXT, dob TEXT)");
        DB.execSQL("create Table feeling(date TEXT primary key, name TEXT)");
        DB.execSQL("create Table test_results(date TEXT primary key, score TEXT, quiz_id TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
        DB.execSQL("drop Table if exists feeling");
        DB.execSQL("drop Table if exists test_results");
    }

    public Boolean insertuserdata(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        long result = DB.insert("Userdetails",null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }

    public  Boolean updateuserdata(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = DB.rawQuery("select * from Userdetails where name = ?", new String[]{name});
        if(cursor.getCount()>0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }

    public  Boolean deleteuserdata(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where name = ?", new String[]{name});
        if(cursor.getCount()>0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }

    public  Cursor getdata () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails", null);
        return cursor;
    }

    public Boolean insertfeeling(String date, String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("name", name);
        long result = DB.insert("feeling",null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Boolean insertTestResult(String date, String score, String quiz_id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("score", score);
        contentValues.put("quiz_id", quiz_id);
        long result = DB.insert("test_results",null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }

    public  Cursor view_feelings () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from feeling order by datetime(date) DESC", null);
        return cursor;
    }

    public  Cursor view_records () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from test_results order by date DESC", null);
        return cursor;
    }

    public  Cursor getProv () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from refprovince order by provDesc ASC", null);
        return cursor;
    }

    public  Cursor getCity (String provCode) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from refcitymun where provCode = ? order by citymunDesc ASC", new String[]{provCode});
        return cursor;
    }

    public  Cursor getBrgy (String citymunCode) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from refbrgy where citymunCode = ? order by brgyDesc ASC", new String[]{citymunCode});
        return cursor;
    }

    public Cursor get_brgy(String id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from refbrgy where id = ?", new String[]{id});
        return cursor;
    }
}
