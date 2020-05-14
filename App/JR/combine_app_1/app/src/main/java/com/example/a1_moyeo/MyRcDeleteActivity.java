package com.example.a1_moyeo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MyRcDeleteActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter_rcs, adapter_rcc, adapter_rcp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myrcdelete);

        Toolbar toolbar = findViewById(R.id.rcdeletetoolbar);
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
        adapter_rcs = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,rcstitle);
        rcslistview.setAdapter(adapter_rcs);

        cadapter = new RcAdapter();
        rcclistview = (ListView) findViewById(R.id.rcclist);
        rcclistview.setAdapter(cadapter);
        for(int i=0;i<rcctitle.length;i++){
            cadapter.addrcItem(rcctitle[i],rccingdate[i],rccgrade[i]);
        }
        adapter_rcc = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,rcctitle);
        rcclistview.setAdapter(adapter_rcc);

        padapter = new RcAdapter();
        rcplistview = (ListView) findViewById(R.id.rcplist);
        rcplistview.setAdapter(padapter);
        for(int i=0;i<rcptitle.length;i++){
            padapter.addrcItem(rcptitle[i],rcpingdate[i],rcpgrade[i]);
        }
        adapter_rcp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,rcptitle);
        rcplistview.setAdapter(adapter_rcp);

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
        menuInflater.inflate(R.menu.ff_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //뒤로가기 버튼 눌렀을 때
                //finish();
                // return true;
                //알림 한 번 띄우기(취소 하시겠습니까?)
                AlertDialog.Builder alarm = new AlertDialog.Builder(this);
                alarm.setTitle("삭제 취소");
                alarm.setMessage(" 취소하시겠습니까?");
                alarm.setCancelable(false);
                alarm.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                alarm.setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog alarm_dialog = alarm.create();
                alarm_dialog.show();
                break;
            }
            case R.id.toolbar_finish_button:{ //완료 버튼 눌렀을 때
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
