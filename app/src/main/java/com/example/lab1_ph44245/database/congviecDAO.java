package com.example.lab1_ph44245.database;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lab1_ph44245.model.khoahoc;

import java.util.ArrayList;

public class congviecDAO {
    private final DBHelper dbHelper;
    private SQLiteDatabase data;
    public congviecDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public ArrayList<khoahoc> getListCV(){
        ArrayList<khoahoc> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        database.beginTransaction();
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM congviec",null);
            if (cursor.getCount()>0){
                cursor.moveToFirst();
                do{
                    list.add(new khoahoc(cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getInt(4)));
                }while (cursor.moveToNext());
                database.setTransactionSuccessful();
            }
        }catch (Exception e){
            Log.e(TAG,"getListCV: "+e);
        }finally {
            database.endTransaction();
        }
        return list;
    }

    public long addkhoahoc(khoahoc khoah) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        database.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("title",khoah.getTitle());
        values.put("content",khoah.getContent());
        values.put("date",khoah.getDate());
        values.put("type",khoah.getType());
        long check = data.insert("congviec",null,values);
        return check;

    }
}
