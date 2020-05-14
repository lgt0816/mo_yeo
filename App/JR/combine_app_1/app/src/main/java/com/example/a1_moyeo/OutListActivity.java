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

public class OutListActivity extends AppCompatActivity {
    String[] olist={"가을이","나을이","다순이","라며니"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outlist);

        Toolbar toolbar = findViewById(R.id.otoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView olistview = (ListView) findViewById(R.id.olist);

        ArrayList<String> o_list = new ArrayList<>();
        for(int i=0;i<olist.length;i++){
            o_list.add(olist[i]);
        }
        ArrayAdapter<String> o_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,o_list);
        olistview.setAdapter(o_adapter);
        ///리스트 클릭 시 퇴출사유 UI로 넘어감
        olistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String o_name = olist[position];
                Intent intent = new Intent(getApplicationContext(),WhyOutActivity.class);
                intent.putExtra("out_name",o_name);
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
