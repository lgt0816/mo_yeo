package com.example.mo_yeo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RcAdapter extends BaseAdapter {
    private ArrayList<RcListViewItem> rcItemList = new ArrayList<RcListViewItem>();

    public RcAdapter(){}

    @Override
    public int getCount() {
        return rcItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //postion = ListView의 위치      /   첫번째면 position = 0
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_rclistview, parent, false);
        }

        TextView rctitleTextView = (TextView) convertView.findViewById(R.id.rctitle);
        TextView ingdateTextView = (TextView) convertView.findViewById(R.id.ingdate);
        TextView gradeTextView = (TextView) convertView.findViewById(R.id.grade);

        RcListViewItem rcListViewItem = rcItemList.get(position);

        rctitleTextView.setText(rcListViewItem.getRctitle());
        ingdateTextView.setText(rcListViewItem.getIngdate());
        gradeTextView.setText(rcListViewItem.getGrade());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return rcItemList.get(position);
    }
    public void addrcItem(String RcTitle, String IngDate, String Grade){
        RcListViewItem rcitem = new RcListViewItem();

        rcitem.setRctitle(RcTitle);
        rcitem.setIngdate(IngDate);
        rcitem.setGrade(Grade);

        rcItemList.add(rcitem);
    }

}
