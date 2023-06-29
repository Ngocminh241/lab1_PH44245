package com.example.lab1_ph44245.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab1_ph44245.R;
import com.example.lab1_ph44245.model.congviec;

import java.util.ArrayList;

public class congviecadapter extends BaseAdapter {
    final private Context context;
    final private ArrayList<congviec> list;

    public congviecadapter(Context context, ArrayList<congviec> list) {
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
