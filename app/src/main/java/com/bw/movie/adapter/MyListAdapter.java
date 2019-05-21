package com.bw.movie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bw.movie.R;

import java.util.List;

public class MyListAdapter extends BaseAdapter {
    Context context;
    List<String> list;

    public MyListAdapter(Context context, List<String> list) {
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
        convertView = View.inflate(context, R.layout.layout_listitem, null);
        TextView text_peo=convertView.findViewById(R.id.text_peo);
        text_peo.setText(list.get(position));
        return convertView;
    }
}
