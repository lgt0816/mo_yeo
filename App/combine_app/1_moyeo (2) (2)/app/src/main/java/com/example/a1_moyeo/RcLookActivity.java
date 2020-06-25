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

import com.example.a1_moyeo.comm_api.CommAPI;

public class RcLookActivity extends AppCompatActivity {
    TextView txt_rctitle,txt_rcsubtitle,txt_rcname,txt_rcid,txt_rccontext,txt_rcrule;
    String ok,act_id;
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

        String rc_title,rc_sub_title;
        txt_rctitle = (TextView) findViewById(R.id.txt_rctitle);
        txt_rcsubtitle = (TextView)findViewById(R.id.txt_rcsubtitle);

        Bundle intent = getIntent().getExtras();
        rc_title = intent.getString("rc_title");
        rc_sub_title =intent.getString("rc_subtitle");
        txt_rctitle.setText(rc_title);
        txt_rcsubtitle.setText(rc_sub_title);

       // txt_rcname = (TextView) findViewById(R.id.txt_rcname);
        txt_rcid = (TextView) findViewById(R.id.txt_rcid);
        txt_rccontext = (TextView) findViewById(R.id.txt_rccontext);
        txt_rcrule = (TextView) findViewById(R.id.txt_rcrule);

        //title1,subtitle2,content3,rule4,id5,type6
         ok = "SELECT04";
        Object rcvDataFromServer = null;
        try {
            rcvDataFromServer = new CommAPI().execute(ok, rc_title).get();
            String[] array_rc = rcvDataFromServer.toString().split("ㅩ");
           // txt_rcname.setText(array_rc[1]);
            txt_rcid.setText(array_rc[5]);//id
            txt_rccontext.setText(array_rc[3]);//content
            txt_rcrule.setText(array_rc[4]);//rule
            act_id = array_rc[7];
        }catch (Exception e) {
            e.printStackTrace(); }

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
                ok = "INSERT05";
                Object rcvDataFromServer = null;
                try {
                    rcvDataFromServer = new CommAPI().execute(ok, act_id).get();
                }catch (Exception e) {
                    e.printStackTrace(); }
                if(rcvDataFromServer.toString()=="OK"){
                    Toast.makeText(getApplicationContext(),"모집 완료",Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"모집 실패",Toast.LENGTH_LONG).show();
                }

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
