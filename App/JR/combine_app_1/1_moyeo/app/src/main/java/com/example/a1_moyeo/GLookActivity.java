package com.example.a1_moyeo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class GLookActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glook);

        Toolbar toolbar =(Toolbar)findViewById(R.id.glook_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        String g_title;
        TextView txt_gtitle = (TextView) findViewById(R.id.txt_gtitle);
        Bundle intent = getIntent().getExtras();
        g_title = intent.getString("gp_title");
        txt_gtitle.setText(g_title);

        //Tab(infor,qna)
        TabHost g_tabhost = (TabHost) findViewById(R.id.glook_tabhost);
        g_tabhost.setup();


        TabHost.TabSpec ginfor_tab = g_tabhost.newTabSpec("Tab Spec g_information");
        ginfor_tab.setContent(R.id.ginfor_tab);
        ginfor_tab.setIndicator("정보");
        g_tabhost.addTab(ginfor_tab);

        TabHost.TabSpec gqna_tab = g_tabhost.newTabSpec("Tab Spec g_Q&A");
        gqna_tab.setContent(R.id.gqna_tab);
        gqna_tab.setIndicator("Q&A");
        g_tabhost.addTab(gqna_tab);
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
