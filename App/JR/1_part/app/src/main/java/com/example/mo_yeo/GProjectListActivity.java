package com.example.mo_yeo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;

public class GProjectListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gprojectlist);

        Toolbar toolbar = findViewById(R.id.gptoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        String[] gp_title = {"GIL","스마트 윈도우","졸업작품 3","졸업작품 4"};
        String[] gp_team = {"파워레인조","A+","3팀","4팀"};

        ListView gplist = (ListView) findViewById(R.id.gplist);

        ArrayList<DataPut> gp_list = new ArrayList<>();
        for(int i=0;i<gp_title.length;i++){
            gp_list.add(new DataPut(gp_title[i],"팀명 | "+gp_team[i]));
        }
        ArrayList<HashMap<String,String>> gp_maplist = new ArrayList<>();
        for(DataPut d : gp_list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("team",d.team);
            gp_maplist.add(map);
        }
        SimpleAdapter gp_sa = new SimpleAdapter(this,gp_maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","team"},new int[]{android.R.id.text1,android.R.id.text2});
        gplist.setAdapter(gp_sa);
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
