package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
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

        final String[] gp_title = {"GIL","스마트 윈도우","졸업작품 3","졸업작품 4"};
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

        //리스트 클릭 시 glook.xml로 넘어감
        gplist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String gptitle = gp_title[position];
                Intent intent = new Intent(getApplicationContext(),GLookActivity.class);
                intent.putExtra("gp_title",gptitle);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.pp_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:{ //뒤로가기 버튼 눌렀을 때
                finish();
                return true;
            }
            case R.id.toolbar_create_button:{ //생성 버튼 눌렀을 때 > gwrite.java 으로 이동
                Intent intent = new Intent(getApplicationContext(),GWriteActivity.class);
                startActivity(intent);
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
