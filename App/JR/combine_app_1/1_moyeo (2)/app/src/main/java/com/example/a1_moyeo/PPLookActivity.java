package com.example.a1_moyeo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a1_moyeo.comm_api.CommAPI;

import java.util.ArrayList;
import java.util.HashMap;

public class PPLookActivity extends AppCompatActivity {
    CommAPI commapi = new CommAPI();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pplook);

        Toolbar toolbar = findViewById(R.id.ppltoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        String[] pp_title = new String[50];
        String[] pp_sub = new String[50];

        TextView pptitle = (TextView) findViewById(R.id.pptitle);
        ListView ppllist = (ListView) findViewById(R.id.ppllist);

        Bundle intent = getIntent().getExtras();
        String ppt = intent.getString("title");
        pptitle.setText(ppt);

        String ok = "SELECT06";
        String select06;
        String get_id = ((MainActivity)MainActivity.context_login).long_id;
        Object rcvDataFromServer = null;
        Object rcvDataFromServer1 = null;
        Object rcvDataFromServer2 = null;
        try {
          rcvDataFromServer = new CommAPI().execute(ok,ppt).get();

        }catch (Exception e) {
            e.printStackTrace();
        }
        select06 = rcvDataFromServer.toString();//포트폴리오 id
        ok = "SELECT09";
        try {
             rcvDataFromServer1 = new CommAPI().execute(ok,select06).get();
//            rcvDataFromServer1 = commapi.execute(ok,select06).get();
//            try{
//                if (commapi.getStatus()== AsyncTask.Status.RUNNING){
//                    commapi.cancel(true);
//                }else {}
//            }catch (Exception e){
//                e.printStackTrace();
//            }
        }catch (Exception e) {
            e.printStackTrace();
        }
      String [] select09 = rcvDataFromServer1.toString().split("ㅩ");//활동 id들 get

        ok="SELECT10";
       // String[] select10 = new String[50];
        int a=0,b=0;
        for(int j=0;j<select09.length;j++){
        try {
            rcvDataFromServer2 = new CommAPI().execute(ok,rcvDataFromServer1.toString()).get();
        }catch (Exception e) {
            e.printStackTrace();
            }
            String[] test = rcvDataFromServer2.toString().split("ㅩ");//활동 제목들,부제들 get
            for(int k = 0;k<test.length;k++){
                if(k%2==0){
                        pp_title[a] = test[k];//test[k].substring(4)
                        a++;}
                else{
                        pp_sub[b] = test[k];//.substring(4);
                        b++;}
                //주제 부제 들어감
            }
        }
        ArrayList<DataPut> pp_list = new ArrayList<>();
        for(int i=0;i<pp_title.length;i++){
            pp_list.add(new DataPut(pp_title[i],pp_sub[i]));
        }
        ArrayList<HashMap<String,String>> pp_maplist = new ArrayList<>();
        for(DataPut d : pp_list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            pp_maplist.add(map);
        }
        SimpleAdapter pp_sa = new SimpleAdapter(this,pp_maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        ppllist.setAdapter(pp_sa);
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
                Intent intent = new Intent(getApplicationContext(),PPCreateActivity.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
    class DataPut{
        String title;
        String sub;
        public DataPut(String title,String sub){
            this.title = title;
            this.sub = sub;
        }
    }
}
