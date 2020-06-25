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

public class NotiListActivity extends AppCompatActivity {
    String[] ntlist,ntlist_cont;
    String pro_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notilist);

        Toolbar toolbar = findViewById(R.id.notilist_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //final String[] ntlist={"4/13 전체공지","단어 시험 시간 공지","스터디 휴강 공지","목표 달성자 공지"," 5/11 전체공지"};

        Bundle intent = getIntent().getExtras();
        ntlist = intent.getStringArray("ntlist_list");
        ntlist_cont = intent.getStringArray("ntlist_cont");
        pro_id = intent.getString("pro_id");

        ListView noti_list = (ListView) findViewById(R.id.noti_list);

        if(ntlist.length == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(" 게시된 공지가 없습니다.");
            ArrayAdapter<String> e_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
            noti_list.setAdapter(e_adapter);
        }else{
            ArrayList<String> nt_list = new ArrayList<>();
            for(int i=0;i<ntlist.length;i++){
                nt_list.add(ntlist[i]);
            }
            ArrayAdapter<String> noti_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nt_list);
            noti_list.setAdapter(noti_adapter);
            ///리스트 클릭 시 공지 상세 UI로 넘어감( > ~.xml)
            noti_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    String noti = ntlist[position];
                    String noti_cont = ntlist_cont[position];
                    Intent intent = new Intent(getApplicationContext(),NotiLookActivity.class);
                    intent.putExtra("title",noti);
                    intent.putExtra("content",noti_cont);
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
            case R.id.toolbar_create_button:{ //생성 버튼 눌렀을 때 > notiwrite.xml 으로 이동
                Intent intent = new Intent(getApplicationContext(),NotiWriteActivity.class);
                intent.putExtra("pro_id",pro_id);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
