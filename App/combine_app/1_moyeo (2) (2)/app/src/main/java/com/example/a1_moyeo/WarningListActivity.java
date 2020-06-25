package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class WarningListActivity extends AppCompatActivity {
    String[] wlist={"가을이","나을이","다순이","라며니"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warninglist);

        Toolbar toolbar = findViewById(R.id.wtoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView wlistview = (ListView) findViewById(R.id.wlist);

        ArrayList<String> w_list = new ArrayList<>();
        for(int i=0;i<wlist.length;i++){
            w_list.add(wlist[i]);
        }
        ArrayAdapter<String> w_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,w_list);
        wlistview.setAdapter(w_adapter);
        ///리스트 클릭 시 경고사유 UI로 넘어감
        wlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String w_name = wlist[position];
                Intent intent = new Intent(getApplicationContext(),WhyWarningActivity.class);
                intent.putExtra("warning_name",w_name);
                startActivity(intent);
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
