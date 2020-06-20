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

public class GGProjectCheckActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ggprojectcheck);


        Toolbar toolbar = findViewById(R.id.ggptoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        final String[] ggp_title = {"생존서바이벌게임","Mission Subway","졸업생 졸업작품 3","졸업생 졸업작품 4"};
        String[] ggp_team = {"게개","Twenty-four","3졸업팀","4졸업팀"};

        ListView ggplist = (ListView) findViewById(R.id.ggplist);

        ArrayList<DataPut> ggp_list = new ArrayList<>();
        for(int i=0;i<ggp_title.length;i++){
            ggp_list.add(new DataPut(ggp_title[i],"팀명 | "+ggp_team[i]));
        }
        ArrayList<HashMap<String,String>> ggp_maplist = new ArrayList<>();
        for(DataPut d : ggp_list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("team",d.team);
            ggp_maplist.add(map);
        }
        SimpleAdapter ggp_sa = new SimpleAdapter(this,ggp_maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","team"},new int[]{android.R.id.text1,android.R.id.text2});
        ggplist.setAdapter(ggp_sa);

        //리스트 클릭 시 gglook.xml로 넘어감
        ggplist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String ggptitle = ggp_title[position];
                Intent intent = new Intent(getApplicationContext(),GGLookActivity.class);
                intent.putExtra("ggp_title",ggptitle);
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
        String team;
        public DataPut(String title,String team){
            this.title = title;
            this.team = team;
        }
    }
}
