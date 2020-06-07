package com.example.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Data> list;
    public CustomAdapter(){
        list=new ArrayList<Data>();
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
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int local_position=position;
        final Context context = parent.getContext();

        TextView tv_local = null;
        Button btn = null;
        ViewHolder holder = null;
        if (convertView==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_custom,parent,false);
            tv_local=(TextView)convertView.findViewById(R.id.textview);
            btn = (Button)convertView.findViewById(R.id.button);

            holder = new ViewHolder();
            holder.textView=tv_local;
            holder.button=btn;
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
            tv_local=holder.textView;
            btn=holder.button;
        }
        tv_local.setText(list.get(position).data);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,list.get(local_position).data,Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    public void add(Data data){
        list.add(data);
    }

    private class ViewHolder{
        TextView textView;
        Button button;
    }
}
