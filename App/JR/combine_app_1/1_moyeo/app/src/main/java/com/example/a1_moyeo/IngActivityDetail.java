package com.example.a1_moyeo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class IngActivityDetail extends AppCompatActivity {
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
        String ing_title, ing_sub;
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
        ingactivity_title.setText(ing_title);
        ingactivity_sub.setText(ing_sub);

        btn_noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NotiListActivity.class);
                startActivity(intent);
            }
        });

        btn_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActListActivity.class);
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
