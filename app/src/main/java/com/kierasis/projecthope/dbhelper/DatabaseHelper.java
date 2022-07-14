package com.kierasis.projecthope.dbhelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    Context mcontext;
    String dbName;
    String dbPath;
    public DatabaseHelper(Context context, String name, int version) {
        super(context, name, null, version);
        this.dbName = name;
        this.mcontext = context;
        this.dbPath = "/data/data/" + "com.kierasis.projecthope" + "/databases/";
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public  void CheckDb(){
        SQLiteDatabase chekDb = null;
        String filePath = dbPath + dbName;

        try {
            chekDb = SQLiteDatabase.openDatabase(filePath,null,0);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(chekDb != null){
            //Toast.makeText(mcontext,"Database already exists", Toast.LENGTH_SHORT).show();
        }else {
            CopyDatabase();
        }

    }

    private void CopyDatabase() {
        this.getReadableDatabase();

        try {
            InputStream ios = mcontext.getAssets().open(dbName);
            OutputStream os = new FileOutputStream(dbPath + dbName);

            byte[] buffer = new byte[1024];

            int len;
            while ((len = ios.read(buffer)) > 0){
                os.write(buffer, 0, len);
            }
            os.flush();
            ios.close();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("CopyDb","Database Copied");
    }

    public  void  OpenDatabase(){
        String filePath = dbPath + dbName;
        SQLiteDatabase.openDatabase(filePath,null,0);
    }


    public Cursor view_quiz (String quiz_id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from quiz WHERE quiz_id=? ", new String[]{quiz_id});
        return cursor;
    }


    public Cursor view_quotes () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from quotation", null);
        return cursor;
    }
}
