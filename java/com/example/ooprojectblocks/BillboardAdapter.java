package com.example.ooprojectblocks;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class BillboardAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Map<String, Object>> data;

    public BillboardAdapter(Context context, List<Map<String, Object>> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return 11;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.billboard_list, null);
        TextView rank = (TextView) view.findViewById(R.id.rank);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView score = (TextView) view.findViewById(R.id.score);
        rank.setText((String) data.get(position).get("rank"));
        id.setText((String) data.get(position).get("id"));
        score.setText((String) data.get(position).get("score"));
        return view;
    }
}
