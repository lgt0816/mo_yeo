package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    String[] s_title,s_sub,c_title,c_sub,p_title,p_sub,g_title,g_sub,s_pro_id,c_pro_id,p_pro_id,g_pro_id;
//    String[] s_title = new String[50];
//    String[] s_sub  = new String[50];
//    String[] c_title  = new String[50];
//    String[] c_sub = new String[50];
//    String[] p_title = new String[50];
//    String[] p_sub  = new String[50];
//    String[] g_title  = new String[50];
//    String[] g_sub  = new String[50];

//    String[] s_title = {"토익 스터디","자기계발 스터디","영어 회화 스터디"};
//    String[] s_sub = {"900+을 위해~","자신의 공부하기","hello,world?"};
//    String[] c_title = {"알고리즘 공모전","개발 콘텐츠 공모전"};
//    String[] c_sub = {"시스템 알고리즘 제작","Python 사용"};
//    String[] p_title = {"빅데이터 프로젝트","앱 프로젝트"};
//    String[] p_sub = {"코로나19분석관련","Android Studio 사용"};
//    String[] g_title = {"졸업작품"};
//    String[] g_sub = {"AI활용한 시스템"};
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

        String get_id = ((MainActivity)MainActivity.context_login).long_id;

        //데이터 받기
        int j=0;
        String ok = "SELECT12";
//        String arra[] = new String[200];
        Object rcvDataFromServer = null;
        try {
            rcvDataFromServer = new CommAPI().execute(ok,get_id).get();
//            arra[j] = rcvDataFromServer.toString();
//            j++;
        }catch (Exception e) {
            e.printStackTrace();
        }
        int num_s=0,num_c=0,num_p=0,num_g=0;
        Log.e("데이터 받았다", rcvDataFromServer.toString());
        String rcv = rcvDataFromServer.toString();
        String[] rclistdata = rcv.split("ㅩ");
        s_title = new String[rclistdata.length/4];
        s_sub  = new String[rclistdata.length/4];
        s_pro_id = new String[rclistdata.length/4];
        c_title  = new String[rclistdata.length/4];
        c_sub = new String[rclistdata.length/4];
        c_pro_id = new String[rclistdata.length/4];
        p_title = new String[rclistdata.length/4];
        p_sub  = new String[rclistdata.length/4];
        p_pro_id = new String[rclistdata.length/4];
        g_title  = new String[rclistdata.length/4];
        g_sub  = new String[rclistdata.length/4];
        g_pro_id = new String[rclistdata.length/4];
        for (int i=0;i<rclistdata.length ;i++){
            if(i%4==1) {
                if (rclistdata[i].toString().contains("스터디")) {
                    s_title[num_s] = rclistdata[i - 1];
                    s_sub[num_s] = rclistdata[i + 1];
                    s_pro_id[num_s] = rclistdata[i + 2];
                    num_s++;
                } else if (rclistdata[i].toString().contains("공모전")) {
                    c_title[num_c] = rclistdata[i - 1];
                    c_sub[num_c] = rclistdata[i + 1];
                    c_pro_id[num_c] = rclistdata[i + 2];
                    num_c++;
                } else if (rclistdata[i].toString().contains("프로젝트")) {
                    p_title[num_p] = rclistdata[i - 1];
                    p_sub[num_p] = rclistdata[i + 1];
                    p_pro_id[num_p] = rclistdata[i + 2];
                    num_p++;
                } else if (rclistdata[i].toString().contains("졸업작품")) {
                    g_title[num_g] = rclistdata[i - 1];
                    g_sub[num_g] = rclistdata[i + 1];
                    g_pro_id[num_g] = rclistdata[i + 2];
                    num_g++;
                }
            }
        }


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
                String s_pro_id_select = s_pro_id[position];

                Intent intent = new Intent(getApplicationContext(),IngActivityDetail.class);
                intent.putExtra("ing_s_title",ing_s_title);
                intent.putExtra("ing_s_sub",ing_s_sub);
                intent.putExtra("pro_id",s_pro_id_select);
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
                String ing_c_sub = c_sub[position];
                String c_pro_id_select = c_pro_id[position];

                Intent intent = new Intent(getApplicationContext(),MemoActivity.class);
                intent.putExtra("ing_c_title",ing_c_title);
                intent.putExtra("ing_c_sub",ing_c_sub);
                intent.putExtra("pro_id",c_pro_id_select);
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
                String ing_p_title = p_title[position];
                String ing_p_sub = p_sub[position];
                String p_pro_id_select = p_pro_id[position];

                Intent intent = new Intent(getApplicationContext(),MemoActivity.class);
                intent.putExtra("ing_p_title",ing_p_title);
                intent.putExtra("ing_p_sub",ing_p_sub);
                intent.putExtra("pro_id",p_pro_id_select);
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
            String ing_g_title = g_title[position];
            String ing_g_psub = g_sub[position];
            String g_pro_id_select = g_pro_id[position];

            Intent intent = new Intent(getApplicationContext(),IngActivityDetail.class);
            intent.putExtra("ing_g_title",ing_g_title);
            intent.putExtra("ing_g_sub",ing_g_psub);
            intent.putExtra("pro_id",g_pro_id_select);
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
