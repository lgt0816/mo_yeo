package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
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

public class MyRcListActivity extends AppCompatActivity {
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
        final String[] rcstitle = {"토익 700+ 스터디","토익 800+ 스터디","토익 850+ 스터디"};
        String[] rcsingdate = {"1/2 - 2/3","2/4 - 4/6","3/4 - 4/15"};
        String[] rcsgrade={"대상 학년 | 제한 없음","대상 학년 | 1, 2","대상 학년 | 1, 2"};

        String[] rcctitle = {"Server 개발자 공모전","글쓰기 공모전"};
        String[] rccingdate = {"11/2 - 12/3","5/4 - 7/26"};
        String[] rccgrade={"대상 학년 | 3, 4","대상 학년 | 1, 2, 3"};

        String[] rcptitle = {"환경 관련 앱 프로젝트","코로나 확진자 동선 확인 앱 제작","빅데이터 프로젝트"};
        String[] rcpingdate = {"10/22 - 11/4","9/11 - 9/25","12/1 - 1/11"};
        String[] rcpgrade={"대상 학년 | 3, 4","대상 학년 | 2, 3, 4","대상 학년 | 제한 없음"};

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
                Intent intent = new Intent(getApplicationContext(),RcLookActivity.class);
                intent.putExtra("rc_s_title",rc_s_title);
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
        menuInflater.inflate(R.menu.del_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:{ //뒤로가기 버튼 눌렀을 때
                finish();
                return true;
            }
            case R.id.toolbar_delete_button:{ //삭제 버튼 눌렀을 때 > 삭제체크리스트.java 으로 이동
                Intent intent = new Intent(getApplicationContext(),MyRcDeleteActivity.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
