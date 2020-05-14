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

import java.util.ArrayList;
import java.util.HashMap;

public class IngListActivity extends AppCompatActivity {
    String[] s_title = {"A 스터디","B 스터디"};
    String[] s_sub = {"A입니다~","B랍니다~"};
    String[] c_title = {"A 공모전","B 공모전"};
    String[] c_sub = {"A이다~","B란다~"};
    String[] p_title = {"A 프로젝트","B 프로젝트"};
    String[] p_sub = {"A화이팅~","B이야~"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inglist);

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
        //
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
        //
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


        ArrayList<DataPut> g_list = new ArrayList<DataPut>();
            g_list.add(new DataPut("나의 졸업작품","아자아자"));

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
