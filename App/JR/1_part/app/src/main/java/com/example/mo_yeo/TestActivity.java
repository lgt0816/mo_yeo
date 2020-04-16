package com.example.mo_yeo;

import android.os.Bundle;
import android.widget.TabHost;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        TabHost tabhost = (TabHost) findViewById(R.id.tabhost);
        tabhost.setup();

        TabHost.TabSpec rcts1 = tabhost.newTabSpec("rc Tab Spec 1");
        rcts1.setContent(R.id.tabstudy);
        rcts1.setIndicator("스터디");
        tabhost.addTab(rcts1);

        TabHost.TabSpec rcts2 = tabhost.newTabSpec("rc Tab Spec 2");
        rcts2.setContent(R.id.tabcontest);
        rcts2.setIndicator("공모전");
        tabhost.addTab(rcts2);

        TabHost.TabSpec rcts3 = tabhost.newTabSpec("rc Tab Spec 3");
        rcts3.setContent(R.id.tabproject);
        rcts3.setIndicator("프로젝트");
        tabhost.addTab(rcts3);

        tabhost.setCurrentTab(0);
    }
}
