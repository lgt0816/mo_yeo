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

public class NotiLookActivity extends AppCompatActivity {
    String title,content;
    TextView txt_notititle,txt_noticontent;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notilook);

        Toolbar toolbar = findViewById(R.id.notilook_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        txt_notititle = (TextView) findViewById(R.id.txt_notititle);
        txt_noticontent = (TextView) findViewById(R.id.txt_noticontent);

        Bundle intent = getIntent().getExtras();
        title = intent.getString("title");
        content = intent.getString("content");
        txt_notititle.setText(title);
        txt_noticontent.setText(content);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.fl_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:{ //뒤로가기 버튼 눌렀을 때
                finish();
                return true;
            }
            case R.id.toolbar_revise_button:{ //수정 버튼 눌렀을 때 > actwrite.xml 으로 이동
                Intent intent = new Intent(getApplicationContext(), NotiModiActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("content",content);
                startActivity(intent);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
