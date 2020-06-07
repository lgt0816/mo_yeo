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

        final String[] ntlist={"공지1","공지2","공지3","공지4","공지5"};

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
            /*noti_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    String ppt = ntlist[position];
                    Intent intent = new Intent(getApplicationContext(),~.class);
                    intent.putExtra("title",ppt);
                    startActivity(intent);
                }
            });*/
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
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
