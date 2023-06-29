package com.example.lab1_ph44245;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lab1_ph44245.adapter.congviecadapter;
import com.example.lab1_ph44245.dao.congviecDAO;
import com.example.lab1_ph44245.model.congviec;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edttile, edtcontent, edtdate, edttype;
    Button btnadd, btnupdate, btndelete;
    ListView lstview;
    private ArrayList<congviec> list = new ArrayList<congviec>();
    congviecDAO cvDAO;
    Context context;
    congviec cv;
    congviecadapter adapter;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        edttile = findViewById(R.id.edttile);
        edtcontent = findViewById(R.id.edtcontent);
        edtdate = findViewById(R.id.edtdate);
        edttype = findViewById(R.id.edttype);
        //
        btnadd = findViewById(R.id.btnadd);
        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);
        //
        lstview = findViewById(R.id.lstview);
        //
        cvDAO = new congviecDAO(this);
//        list.clear();
        list.clear();
        list=cvDAO.selectAll();
        for (congviec kh: list){
//            list.add(kh.getId()+" - "+ kh.getTitle()+" - "+kh.getContent()+" - "+kh.getDate()+" - "+kh.getType()+" - "+kh.getTrangThai());
        }
        adapter = new congviecadapter(this,list);
        lstview.setAdapter(adapter);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cv = list.get(i);//truy vấn đến đối tượng được chọn
                edttile.setText(cv.getTitle());
                edtcontent.setText(cv.getContent());
                edtdate.setText(cv.getDate());
                edttype.setText(String.valueOf(cv.getType()));
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                congviec khoah = new congviec();
                khoah.setTitle(edttile.getText().toString());
                khoah.setContent(edtcontent.getText().toString());
                khoah.setDate(edtdate.getText().toString());
                khoah.setType(Integer.parseInt(edttype.getText().toString()));
                cvDAO.addkhoahoc(khoah);
//                list.clear();
                list.clear();
                list=cvDAO.selectAll();
                for (congviec kh: list){
//                    list.add(kh.getId()+" - "+ kh.getTitle()+" - "+kh.getContent()+" - "+kh.getDate()+" - "+kh.getType()+" - "+kh.getTrangThai());
                }
                adapter.notifyDataSetChanged();
            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}