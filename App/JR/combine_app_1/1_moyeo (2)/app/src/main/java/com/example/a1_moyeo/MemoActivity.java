package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MemoActivity extends AppCompatActivity {
    TextView memo_title,memo_content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo);

        Toolbar toolbar = findViewById(R.id.mmtoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        actionBar.setDisplayHomeAsUpEnabled(true);

        memo_title = (TextView) findViewById(R.id.memo_title);
        memo_content = (TextView) findViewById(R.id.memo_content);

        Bundle intent = getIntent().getExtras();
        memo_title.setText(intent.getString("ing_c_title"));
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
              //  Intent intent = new Intent(getApplicationContext(),PPCreateActivity.class);
              //  startActivity(intent);
                String ing_c_title = memo_title.toString();

                Intent intent = new Intent(getApplicationContext(),MemowriteActivity.class);
                intent.putExtra("ing_c_title",ing_c_title);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
