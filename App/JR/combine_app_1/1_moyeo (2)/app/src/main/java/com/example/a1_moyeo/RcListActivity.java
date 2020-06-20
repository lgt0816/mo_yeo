package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a1_moyeo.comm_api.CommAPI;

public class RcListActivity extends AppCompatActivity {
    String[] rcstitle = new String[50];
    String[] rcsgrade= new String[50];

    String[] rcctitle = new String[50];
    String[] rccgrade= new String[50];

    String[] rcptitle= new String[50];
    String[] rcpgrade= new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rclist);

        Toolbar toolbar = findViewById(R.id.rctoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView rcslistview, rcclistview, rcplistview;
        RcAdapter sadapter, cadapter, padapter;


        //데이터 받기
        CommAPI comma = new CommAPI();
        int j=0;
        String ok = "SELECT03";
        String arra[] = new String[200];
        Object rcvDataFromServer = null;
        try {
            rcvDataFromServer = new CommAPI().execute(ok).get();
            arra[j] = rcvDataFromServer.toString();
            j++;
        }catch (Exception e) {
            e.printStackTrace();
        }
        int num_s=0,num_c=0,num_p=0;
        Log.e("데이터 받았다", rcvDataFromServer.toString());
        String rcv = rcvDataFromServer.toString();
        String[] rclistdata = rcv.split("ㅩ");
        for (int i=0;i<rclistdata.length ;i++){
            if(i%3==2){
                if(rclistdata[i].toString().contains("스터디")){
                    rcstitle[num_s]=rclistdata[i-1];
                    rcsgrade[num_s]=rclistdata[i+1];
                    num_s++;
                } else if(rclistdata[i].toString().contains("공모전")){
                    rcctitle[num_c]=rclistdata[i-1];
                    rccgrade[num_c]=rclistdata[i+1];
                    num_c++;
                }else if(rclistdata[i].toString().contains("프로젝트")){
                    rcptitle[num_p]=rclistdata[i-1];
                    rcpgrade[num_p]=rclistdata[i+1];
                    num_p++;
                }
            }
        }

        TabHost rctabhost = (TabHost) findViewById(R.id.rctabhost);
        rctabhost.setup();

        sadapter = new RcAdapter();
        rcslistview = (ListView) findViewById(R.id.rcslist);
        rcslistview.setAdapter(sadapter);
        for(int i=0;i<rcstitle.length;i++){
            sadapter.addrcItem(rcstitle[i],rcsgrade[i]);
        }

        //리스트 클릭 시 rclook.xml로 넘어감
         rcslistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String rc_s_title = rcstitle[position];
                String rc_s_subtitle = rcsgrade[position];
                Intent intent = new Intent(getApplicationContext(),RcLookActivity.class);
                intent.putExtra("rc_s_title",rc_s_title);
                intent.putExtra("rc_s_subtitle",rc_s_subtitle);
                startActivity(intent);
            }
        });

        cadapter = new RcAdapter();
        rcclistview = (ListView) findViewById(R.id.rcclist);
        rcclistview.setAdapter(cadapter);
        for(int i=0;i<rcctitle.length;i++){
            cadapter.addrcItem(rcctitle[i],rccgrade[i]);
        }

        padapter = new RcAdapter();
        rcplistview = (ListView) findViewById(R.id.rcplist);
        rcplistview.setAdapter(padapter);
        for(int i=0;i<rcptitle.length;i++){
            padapter.addrcItem(rcptitle[i],rcpgrade[i]);
        }

        TabHost.TabSpec rcts1 = rctabhost.newTabSpec("rc Tab Spec 1");
        rcts1.setContent(R.id.tabstudy);
        rcts1.setIndicator("스터디");
        rctabhost.addTab(rcts1);

        TabHost.TabSpec rcts2 = rctabhost.newTabSpec("rc Tab Spec 2");
        rcts2.setContent(R.id.tabcontest);
        rcts2.setIndicator("공모전");
        rctabhost.addTab(rcts2);

        TabHost.TabSpec rcts3 = rctabhost.newTabSpec("rc Tab Spec 3");
        rcts3.setContent(R.id.tabproject);
        rcts3.setIndicator("프로젝트");
        rctabhost.addTab(rcts3);

        rctabhost.setCurrentTab(0);

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
            case R.id.toolbar_create_button:{ //생성 버튼 눌렀을 때 > rcwrite.java 으로 이동
                Intent intent = new Intent(getApplicationContext(),RcWriteActivity.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
