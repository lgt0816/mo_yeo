package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ActListActivity extends AppCompatActivity {
    String[] atlist,atlist_cont;
    String atlist_title;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actlist);

        Toolbar toolbar = findViewById(R.id.actlist_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

       // final String[] atlist={"스터디 1일차 - RC/LC 1강씩","스터디 2일차 - RC/LC 2강씩","스터디 3일차 - RC/LC 3강씩","스터디 4일차 - RC/LC 4강씩","스터디 5일차 - RC/LC 5강씩","스터디 6일차 - RC/LC 6강씩"};
        Bundle intent = getIntent().getExtras();
        atlist_title = intent.getString("act_title");
        atlist = intent.getStringArray("atlist_list");
        atlist_cont = intent.getStringArray("atlist_cont");



        ListView act_list = (ListView) findViewById(R.id.act_list);

        if(atlist.length == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(" 게시된 공지가 없습니다.");
            ArrayAdapter<String> e_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
            act_list.setAdapter(e_adapter);
        }else{
            ArrayList<String> at_list = new ArrayList<>();
            for(int i=0;i<atlist.length;i++){
                at_list.add(atlist[i]);
            }
            ArrayAdapter<String> act_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,at_list);
            act_list.setAdapter(act_adapter);
            ///리스트 클릭 시 활동 상세 UI로 넘어감( > actlook.xml)
            act_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    String act_title = atlist[position];
                    String act_content = atlist_cont[position];

                    Intent intent = new Intent(getApplicationContext(),ActLookActivity.class);
                    intent.putExtra("title",act_title);
                    intent.putExtra("content",act_content);
                    startActivity(intent);
                }
            });
        }
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
            case R.id.toolbar_create_button:{ //생성 버튼 눌렀을 때 > actwrite.xml 으로 이동
                Intent intent = new Intent(getApplicationContext(),ActWriteActivity.class);
                intent.putExtra("act_title",atlist_title);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
