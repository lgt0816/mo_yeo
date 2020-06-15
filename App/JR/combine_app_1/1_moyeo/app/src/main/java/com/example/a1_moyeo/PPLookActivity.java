package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;

public class PPLookActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pplook);

        Toolbar toolbar = findViewById(R.id.ppltoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        String[] pp_title = {"A 스터디","B 스터디","A 공모전","B 공모전"};
        String[] pp_sub = {"A입니다~","B랍니다~","A이다~","B란다~"};

        TextView pptitle = (TextView) findViewById(R.id.pptitle);
        ListView ppllist = (ListView) findViewById(R.id.ppllist);

        Bundle intent = getIntent().getExtras();
        String ppt = intent.getString("title");
        pptitle.setText(ppt);

        ArrayList<DataPut> pp_list = new ArrayList<>();
        for(int i=0;i<pp_title.length;i++){
            pp_list.add(new DataPut(pp_title[i],pp_sub[i]));
        }
        ArrayList<HashMap<String,String>> pp_maplist = new ArrayList<>();
        for(DataPut d : pp_list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            pp_maplist.add(map);
        }
        SimpleAdapter pp_sa = new SimpleAdapter(this,pp_maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        ppllist.setAdapter(pp_sa);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.fl_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //뒤로가기 버튼 눌렀을 때
                finish();
                return true;
            }
            case R.id.toolbar_revise_button:{ //수정 버튼 눌렀을 때
                Intent intent = new Intent(getApplicationContext(),PPCreateActivity.class);
                startActivity(intent);
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
