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
        final String[] rcstitle = {"내 모집 스터디1","내 모집 스터디2","내 모집 스터디3"};
        String[] rcsingdate = {"1/2 - 2/3","2/4 - 4/6","3/4 - 4/15"};
        String[] rcsgrade={"제한 없음","1학년","1,2학년"};

        String[] rcctitle = {"내 모집 공모전1","내 모집 공모전2"};
        String[] rccingdate = {"11/2 - 12/3","5/4 - 7/26"};
        String[] rccgrade={"3학년","2,3학년"};

        String[] rcptitle = {"내 모집 프로젝트1","내 모집 프로젝트2","내 모집 프로젝트3"};
        String[] rcpingdate = {"10/22 - 11/4","9/11 - 9/25","12/1 - 1/11"};
        String[] rcpgrade={"2,3학년","1학년","1,2학년"};

        TabHost rctabhost = (TabHost) findViewById(R.id.rctabhost);
        rctabhost.setup();

        sadapter = new RcAdapter();
        rcslistview = (ListView) findViewById(R.id.rcslist);
        rcslistview.setAdapter(sadapter);
        for(int i=0;i<rcstitle.length;i++){
            sadapter.addrcItem(rcstitle[i],rcsingdate[i],rcsgrade[i]);
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
            cadapter.addrcItem(rcctitle[i],rccingdate[i],rccgrade[i]);
        }

        padapter = new RcAdapter();
        rcplistview = (ListView) findViewById(R.id.rcplist);
        rcplistview.setAdapter(padapter);
        for(int i=0;i<rcptitle.length;i++){
            padapter.addrcItem(rcptitle[i],rcpingdate[i],rcpgrade[i]);
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
