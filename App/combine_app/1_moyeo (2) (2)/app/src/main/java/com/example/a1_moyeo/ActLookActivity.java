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

public class ActLookActivity extends AppCompatActivity {
    String title,content;
    TextView txt_acttitle,txt_actcontent;
    String ok,get_id;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actlook);

        Toolbar toolbar = findViewById(R.id.actlook_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        txt_acttitle = (TextView) findViewById(R.id.txt_acttitle);
        txt_actcontent = (TextView) findViewById(R.id.txt_actcontent);

        Bundle intent = getIntent().getExtras();
        title = intent.getString("title");
        content = intent.getString("content");
        txt_acttitle.setText(title);
        txt_actcontent.setText(content);

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
            case R.id.toolbar_revise_button:{ //수정 버튼 눌렀을 때
                Intent intent = new Intent(getApplicationContext(), ActModiActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("content",content);
                startActivity(intent);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
