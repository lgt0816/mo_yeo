package com.example.a1_moyeo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a1_moyeo.comm_api.CommAPI;

import java.util.ArrayList;

public class IngActivityDetail extends AppCompatActivity {
    ListView noti_listview,act_listview;
    String [] noti_infor,act_infor,ntlist_list,atlist_list,ntlist_cont,atlist_cont;
    String ok,pro_id;
    String ing_title, ing_sub;

    //    String[] ntlist_list={"4/13 전체공지","단어 시험 시간 공지","스터디 휴강 공지","목표 달성자 공지"," 5/11 전체공지"};
//    String[] atlist_list={"스터디 1일차 - RC/LC 1강씩","스터디 2일차 - RC/LC 2강씩","스터디 3일차 - RC/LC 3강씩","스터디 4일차 - RC/LC 4강씩","스터디 5일차 - RC/LC 5강씩","스터디 6일차 - RC/LC 6강씩"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingactivity_detail);
        Toolbar toolbar =(Toolbar)findViewById(R.id.activity_ing_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView ingactivity_title, ingactivity_sub;

        Button btn_noti,btn_act,btn_warning,btn_out,btn_break,btn_done;

        ingactivity_title = (TextView) findViewById(R.id.ingactivity_title);
        ingactivity_sub = (TextView) findViewById(R.id.ingactivity_sub);
        btn_noti = (Button) findViewById(R.id.btn_noti);
        btn_act = (Button) findViewById(R.id.btn_act);
        btn_warning = (Button) findViewById(R.id.btn_warning);
        btn_out = (Button) findViewById(R.id.btn_out);
        btn_break = (Button) findViewById(R.id.btn_break);
        btn_done = (Button) findViewById(R.id.btn_done);


        Bundle intent = getIntent().getExtras();
        ing_title = intent.getString("ing_s_title");
        ing_sub = intent.getString("ing_s_sub");
        pro_id = intent.getString("pro_id");

        ingactivity_title.setText(ing_title);
        ingactivity_sub.setText(ing_sub);

        noti_listview = (ListView) findViewById(R.id.noti_listview);
        act_listview  = (ListView) findViewById(R.id.act_listview);

        ok = "SELECT13"; //공지 제목/내용 get
        Object rcvDataFromServer = null;
        try {
            rcvDataFromServer = new CommAPI().execute(ok).get();

        }catch (Exception e) {
            e.printStackTrace();
        }
        int a=0,c=0;
        noti_infor = rcvDataFromServer.toString().split("ㅩ");
        ntlist_list = new String[noti_infor.length/2];
        ntlist_cont = new String[noti_infor.length/2];
        for(int i=0;i<noti_infor.length;i++){ // 0 2 4 5
            if(i%2==0){
                ntlist_list[a] = noti_infor[i];
                a++;
            }else{
                ntlist_cont[c]=noti_infor[i];
                c++;
            }
        }

        ok = "SELECT14"; //활동 제목/내용 get
        Object rcvDataFromServer1 = null;
        try {
            rcvDataFromServer1 = new CommAPI().execute(ok).get();

        }catch (Exception e) {
            e.printStackTrace();
        }
        int b=0,d=0;
        act_infor = rcvDataFromServer1.toString().split("ㅩ");
        atlist_list  = new String[act_infor.length/2];
        atlist_cont =  new String[act_infor.length/2];
        for(int i=0;i<act_infor.length;i++){ // 0 2 4 5
            if(i%2==0){
                atlist_list[b] = act_infor[i];
                b++;
            }else{
                atlist_cont[d] = act_infor[i];
                d++;
            }
        }

        ArrayList<String> nt_list = new ArrayList<>();
        if(ntlist_list[0]==null){
            nt_list.add("생성된 공지가 없습니다.");
        }else{
            for(int i=0;i<ntlist_list.length;i++){
                nt_list.add(ntlist_list[i]);
            }
        }
        ArrayAdapter<String> nt_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nt_list);
        noti_listview.setAdapter(nt_adapter);

        ArrayList<String> at_list = new ArrayList<>();
        if(atlist_list[0]==null){
            at_list.add("생성된 활동이 없습니다.");
        }else{
            for(int j=0;j<atlist_list.length;j++){
                at_list.add(atlist_list[j]);
            }
        }
        ArrayAdapter<String> act_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,at_list);
        act_listview.setAdapter(act_adapter);


        btn_noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NotiListActivity.class);
                intent.putExtra("ntlist_list",ntlist_list);
                intent.putExtra("ntlist_cont",ntlist_cont);
                intent.putExtra("pro_id",pro_id);
                startActivity(intent);
            }
        });

        btn_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActListActivity.class);
                intent.putExtra("atlist_list",atlist_list);
                intent.putExtra("atlist_cont",atlist_cont);
                intent.putExtra("act_title",ing_title);
                startActivity(intent);
            }
        });

        btn_warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WarningListActivity.class);
                startActivity(intent);
            }
        });

        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OutListActivity.class);
                startActivity(intent);
            }
        });
        btn_break.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alarm = new AlertDialog.Builder(IngActivityDetail.this);
                alarm.setTitle("활동 해체");
                alarm.setMessage(" 정말 활동을 중단하시겠습니까?");
                alarm.setCancelable(false);
                alarm.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                alarm.setNegativeButton("해체", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog alarm_dialog = alarm.create();
                alarm_dialog.show();
            }
        });
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alarm = new AlertDialog.Builder(IngActivityDetail.this);
                alarm.setTitle("활동 완료");
                alarm.setMessage(" 활동을 완료시키겠습니까?");
                alarm.setCancelable(false);
                alarm.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                alarm.setNegativeButton("활동 완료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Intent intent = new Intent(getApplicationContext(),MtEndActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alarm_dialog = alarm.create();
                alarm_dialog.show();
            }
        });

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
