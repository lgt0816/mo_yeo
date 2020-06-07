package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class RcLookActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rclook);

        Toolbar toolbar =(Toolbar)findViewById(R.id.rclook_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        String rc_title;
        TextView txt_rctitle = (TextView) findViewById(R.id.txt_rctitle);
        Bundle intent = getIntent().getExtras();
        rc_title = intent.getString("rc_s_title");
        txt_rctitle.setText(rc_title);

        Button btn_revise, btn_application;
        btn_revise = (Button) findViewById(R.id.btn_revise);
        btn_application = (Button) findViewById(R.id.btn_application);

        btn_revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RcWriteActivity.class);
                startActivity(intent);
            }
        });

        btn_application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"신청 완료",Toast.LENGTH_LONG).show();
            }
        });

        //Tab(infor,qna)
        TabHost rc_tabhost = (TabHost) findViewById(R.id.rclook_tabhost);
        rc_tabhost.setup();


        TabHost.TabSpec rcinfor_tab = rc_tabhost.newTabSpec("Tab Spec rc_information");
        rcinfor_tab.setContent(R.id.rcinfor_tab);
        rcinfor_tab.setIndicator("정보");
        rc_tabhost.addTab(rcinfor_tab);

        TabHost.TabSpec rcqna_tab = rc_tabhost.newTabSpec("Tab Spec rc_Q&A");
        rcqna_tab.setContent(R.id.rcqna_tab);
        rcqna_tab.setIndicator("Q&A");
        rc_tabhost.addTab(rcqna_tab);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
