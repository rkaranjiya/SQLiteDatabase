package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "SQLiteDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Employee(id INTEGER primary key autoincrement, sid TEXT, name TEXT, salary DECIMAL(10,2))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Details");
        onCreate(db);

    }

    public boolean addData(String id, String name, Double salary)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("sid",id);
        contentValues.put("name",name);
        contentValues.put("salary",salary);

        long result = db.insert("Employee", null, contentValues);

        if( result == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public Boolean updateData(String id, String name, Double salary){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("sid",id);
        contentValues.put("name",name);
        contentValues.put("salary",salary);

        Cursor cursor = db.rawQuery("SELECT * FROM Employee WHERE sid = ?", new String[]{id});

        if (cursor.getCount() > 0) {
            long result = db.update("Employee", contentValues, "sid=?", new String[]{id});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else{
            return true;
        }

    }

    public Cursor getData() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Employee WHERE salary > 20000",null);
        return cursor;
    }

    public boolean deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete("Employee","sid=?", new String[]{id})>0;
    }

}
