package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a1_moyeo.comm_api.CommAPI;

public class FinishLookActivity extends AppCompatActivity {
   String fl_title,fl_sub,ok;
    String[] result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finishlook);

        Toolbar toolbar = findViewById(R.id.fltoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView title, sub, fl_result,fl_feel;

        title = (TextView) findViewById(R.id.fl_title);
        sub = (TextView) findViewById(R.id.fl_sub);
        fl_result = (TextView) findViewById(R.id.fl_result);
        fl_feel = (TextView) findViewById(R.id.fl_feel);

        Bundle intent = getIntent().getExtras();
        fl_title = intent.getString("title");
        fl_sub = intent.getString("Sub");
        title.setText(fl_title);
        sub.setText(fl_sub);

        String get_id = ((MainActivity)MainActivity.context_login).long_id;

        ok = "SELECT16";
        Object rcvDataFromServer = null;
        try {
            rcvDataFromServer = new CommAPI().execute(ok,fl_title).get();
        }catch (Exception e) {
            e.printStackTrace();
        }
        rcvDataFromServer = rcvDataFromServer.toString().replace("ㅩ","");

        ok = "SELECT15";
        Object rcvDataFromServer1 = null;
        try {
            rcvDataFromServer1 = new CommAPI().execute(ok,get_id,rcvDataFromServer).get();
        }catch (Exception e) {
            e.printStackTrace();
        }
        result = rcvDataFromServer1.toString().split("ㅩ"); //결과,소감 get
        fl_result.setText(result[0]);
        fl_feel.setText(result[1]);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.fl_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //뒤로가기 버튼 눌렀을 때
                finish();
                return true;
            }
            case R.id.toolbar_revise_button:{ //수정 버튼 눌렀을 때
                Intent intent = new Intent(getApplicationContext(),FinishFeelActivity.class);
                intent.putExtra("title",fl_title);
                intent.putExtra("Sub",fl_sub);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
