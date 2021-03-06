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

import com.example.a1_moyeo.comm_api.CommAPI;

import java.util.ArrayList;

public class PPListActivity extends AppCompatActivity {
    String[] pplist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pplist);

        String get_id = ((MainActivity)MainActivity.context_login).long_id;

        Toolbar toolbar = findViewById(R.id.pptoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        String ok = "SELECT08";
        String select08;
        Object rcvDataFromServer = null;
        try {
            rcvDataFromServer = new CommAPI().execute(ok,get_id).get();


        }catch (Exception e) {
            e.printStackTrace();
        }
        select08 = rcvDataFromServer.toString();
        pplist = select08.split("ㅩ");//

        ListView pplistview = (ListView) findViewById(R.id.pplist);

        if(pplist.length == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(" 신청 중인 활동이 없습니다.");
            ArrayAdapter<String> e_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
            pplistview.setAdapter(e_adapter);
        }else{
            ArrayList<String> pp_list = new ArrayList<>();
            for(int i=0;i<pplist.length;i++){
                pp_list.add(pplist[i]);
            }
            ArrayAdapter<String> pp_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pp_list);
            pplistview.setAdapter(pp_adapter);
            ///리스트 클릭 시 포트폴리오 상세 UI로 넘어감( > pplook.xml)
            pplistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    String ppt = pplist[position];
                    Intent intent = new Intent(getApplicationContext(),PPLookActivity.class);
                    intent.putExtra("title",ppt);
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
            case R.id.toolbar_create_button:{ //생성 버튼 눌렀을 때 > PPCreateActivity.java 으로 이동
                Intent intent = new Intent(getApplicationContext(),PPCreateActivity.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
