package com.example.lab1_ph44245.dao;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lab1_ph44245.database.DBHelper;
import com.example.lab1_ph44245.model.congviec;

import java.util.ArrayList;

public class congviecDAO {
    private final DBHelper dbHelper;
    private SQLiteDatabase data;
    public congviecDAO(Context context){
        dbHelper = new DBHelper(context);
    }
    //selectAll: lấy toàn bộ dữ liệu từ bảng công việc, add dữ liệu vào list
    public ArrayList<congviec> selectAll(){
        ArrayList<congviec> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        database.beginTransaction();
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM congviec",null);
            if (cursor.getCount()>0){
                cursor.moveToFirst();//đưa con trỏ về dòng đầu tiên
                while (!cursor.isAfterLast()){
                    congviec cv= new congviec();//tạo đối tượng
                    cv.setId(cursor.getInt(0));
                    cv.setTitle(cursor.getString(1));
                    cv.setContent(cursor.getString(2));
                    cv.setDate(cursor.getString(3));
                    cv.setType(cursor.getInt(4));
                    cv.setTrangThai(cursor.getInt(5));
                    list.add(cv);//add dữ liệu vào list
                    cursor.moveToNext();//đưa con trỏ dòng tiếp theo
                }
//                do{//tạo đối tượng
//                    list.add(new congviec(cursor.getInt(0),
//                            cursor.getString(1),
//                            cursor.getString(2),
//                            cursor.getString(3),
//                            cursor.getInt(4),
//                            cursor.getInt(5)));
//                    //nhập thông tin cho đối tượng
//                }while (cursor.moveToNext());
//                database.setTransactionSuccessful();
            }
        }catch (Exception e){
            Log.e(TAG,"Lỗi: "+e);
        }finally {
            database.endTransaction();
        }
        return list;
    }

    public long addkhoahoc(congviec khoah) {
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
