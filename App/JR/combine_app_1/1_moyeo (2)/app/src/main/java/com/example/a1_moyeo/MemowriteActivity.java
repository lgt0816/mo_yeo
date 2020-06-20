package com.example.a1_moyeo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MemowriteActivity extends AppCompatActivity {
    TextView memo_wtitle,memo_wcontent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memowrite);

        Toolbar toolbar = findViewById(R.id.mmwtoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        actionBar.setDisplayHomeAsUpEnabled(true);

        memo_wtitle = (TextView) findViewById(R.id.memo_wtitle);
        memo_wcontent = (TextView) findViewById(R.id.memo_wcontent);

        Bundle intent = getIntent().getExtras();
        memo_wtitle.setText(intent.getString("ing_c_title"));
    }
}
