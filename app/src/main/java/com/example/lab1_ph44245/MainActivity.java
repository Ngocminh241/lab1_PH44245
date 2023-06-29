package com.example.lab1_ph44245;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lab1_ph44245.adapter.listadapter;
import com.example.lab1_ph44245.database.congviecDAO;
import com.example.lab1_ph44245.model.khoahoc;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edttile, edtcontent, edtdate, edttype;
    Button btnadd, btnupdate, btndelete;
    ListView lstview;
    ArrayList<String> list = new ArrayList<>();
    ArrayList<khoahoc> listkh = new ArrayList<>();
    congviecDAO cvDAO;
    Context context = this;

listadapter adapter;

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
        cvDAO = new congviecDAO(context);
        list.clear();
        listkh.clear();
        listkh=cvDAO.getListCV();
        for (khoahoc kh: listkh){
            list.add(kh.getTitle()+" - "+kh.getContent()+" - "+kh.getDate()+" - "+kh.getType());
        }
        adapter = new listadapter(this,listkh);
        lstview.setAdapter(adapter);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                khoahoc khoah = new khoahoc();
                khoah.setTitle(edttile.getText().toString());
                khoah.setContent(edtcontent.getText().toString());
                khoah.setDate(edtdate.getText().toString());
                khoah.setType(Integer.parseInt(edttype.getText().toString()));
                cvDAO.addkhoahoc(khoah);
                list.clear();
                listkh.clear();
                listkh=cvDAO.getListCV();
                for (khoahoc kh: listkh){
                    list.add(kh.getTitle()+" - "+kh.getContent()+" - "+kh.getDate()+" - "+kh.getType());
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