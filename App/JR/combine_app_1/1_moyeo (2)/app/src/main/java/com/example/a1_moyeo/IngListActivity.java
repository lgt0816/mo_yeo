package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a1_moyeo.comm_api.CommAPI;

import java.util.ArrayList;
import java.util.HashMap;

public class IngListActivity extends AppCompatActivity {
    String[] s_title = new String[50];
    String[] s_sub  = new String[50];
    String[] c_title  = new String[50];
    String[] c_sub = new String[50];
    String[] p_title = new String[50];
    String[] p_sub  = new String[50];
    String[] g_title  = new String[50];
    String[] g_sub  = new String[50];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inglist);

        //CommAPI comma = new CommAPI();
        //comma.execute("이렇게도가능");




        Toolbar toolbar = findViewById(R.id.ingtoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        actionBar.setDisplayHomeAsUpEnabled(true);



        ListView s_listView = findViewById(R.id.s_list);
        ListView c_listView = findViewById(R.id.c_list);
        ListView p_listView = findViewById(R.id.p_list);
        ListView g_listView = findViewById(R.id.g_list);
        //s_list
        ArrayList<DataPut> s_list = new ArrayList<>();
        for(int i=0;i<s_title.length;i++){
            s_list.add(new DataPut(s_title[i],s_sub[i]));
        }
        ArrayList<HashMap<String,String>> s_maplist = new ArrayList<>();
        for(DataPut d : s_list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            s_maplist.add(map);
        }
        SimpleAdapter s_sa = new SimpleAdapter(this,s_maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        s_listView.setAdapter(s_sa);
        //리스트 클릭 시 진행 활동 상세 UI로 넘어감(>ingactivity_detail.xml)
        s_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ing_s_title = s_title[position];
                String ing_s_sub = s_sub[position];

                Intent intent = new Intent(getApplicationContext(),IngActivityDetail.class);
                intent.putExtra("ing_s_title",ing_s_title);
                intent.putExtra("ing_s_sub",ing_s_sub);
                startActivity(intent);
            }
        });
        //c_list
        ArrayList<DataPut> c_list = new ArrayList<DataPut>();
        for(int i=0;i<c_title.length;i++){
            c_list.add(new DataPut(c_title[i],c_sub[i]));
        }
        ArrayList<HashMap<String,String>> c_maplist = new ArrayList<HashMap<String, String>>();
        for(DataPut d : c_list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            c_maplist.add(map);
        }
        SimpleAdapter c_sa = new SimpleAdapter(this,c_maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        c_listView.setAdapter(c_sa);
        c_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String ing_c_title = c_title[position];

                Intent intent = new Intent(getApplicationContext(),MemoActivity.class);
                intent.putExtra("ing_c_title",ing_c_title);
                startActivity(intent);
            }
        });

        ////p_list
        ArrayList<DataPut> p_list = new ArrayList<DataPut>();
        for(int i=0;i<p_title.length;i++){
            p_list.add(new DataPut(p_title[i],p_sub[i]));
        }
        ArrayList<HashMap<String,String>> p_maplist = new ArrayList<HashMap<String, String>>();
        for(DataPut d : p_list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            p_maplist.add(map);
        }
        SimpleAdapter p_sa = new SimpleAdapter(this,p_maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        p_listView.setAdapter(p_sa);
        p_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ing_c_title = p_title[position];

                Intent intent = new Intent(getApplicationContext(),MemoActivity.class);
                intent.putExtra("ing_c_title",ing_c_title);
                startActivity(intent);
            }
        });

        ////g_list
        ArrayList<DataPut> g_list = new ArrayList<DataPut>();
           // g_list.add(new DataPut("나의 졸업작품","아자아자"));
        for(int i=0;i<g_title.length;i++){
            g_list.add(new DataPut(g_title[i],g_sub[i]));
        }

        ArrayList<HashMap<String,String>> g_maplist = new ArrayList<HashMap<String, String>>();
        for(DataPut d : g_list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            g_maplist.add(map);
        }
        SimpleAdapter g_sa = new SimpleAdapter(this,g_maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        g_listView.setAdapter(g_sa);
        g_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String ing_g_title = p_title[position];
            String ing_g_psub = p_sub[position];

            Intent intent = new Intent(getApplicationContext(),IngActivityDetail.class);
            intent.putExtra("ing_g_title",ing_g_title);
            intent.putExtra("ing_g_sub",ing_g_psub);
            startActivity(intent);
        }
    });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    class DataPut{
        String title;
        String sub;
        public DataPut(String title,String sub){
            this.title = title;
            this.sub = sub;
        }
    }
}
