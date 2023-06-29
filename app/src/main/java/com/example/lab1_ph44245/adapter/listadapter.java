package com.example.lab1_ph44245.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab1_ph44245.R;
import com.example.lab1_ph44245.model.khoahoc;

import java.util.ArrayList;

public class listadapter extends BaseAdapter {
    final private Context context;
    final private ArrayList<khoahoc> list;

    public listadapter(Context context, ArrayList<khoahoc> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.layout_item, parent, false);

        TextView txttieude = convertView.findViewById(R.id.txttieude);
        TextView txtnoidung = convertView.findViewById(R.id.txtnoidung);
        TextView txtngay = convertView.findViewById(R.id.txtngay);
        TextView txttrangthai = convertView.findViewById(R.id.txttrangthai);

        txttieude.setText(list.get(position).getTitle());
        txtnoidung.setText(list.get(position).getContent());
        txtngay.setText(String.valueOf(list.get(position).getDate()));
        txttrangthai.setText(String.valueOf(list.get(position).getType()));
        return convertView;
    }
}
