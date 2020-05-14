package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;

public class FinishListActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finishlist);

        Toolbar toolbar = findViewById(R.id.finishtoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView s1listview,c1listview,p1listview,sp1listview,s2listview,c2listview,p2listview,sp2listview,
                s3listview,c3listview,p3listview,sp3listview,s4listview,c4listview,p4listview,g4listview,sp4listview;

        final String[] s_1title = {"1-A 스터디","1-B 스터디"};
        final String[] s_1sub = {"A입니다~","B랍니다~"};
        final String[] c_1title = {"1-A 공모전","1-B 공모전"};
        final String[] c_1sub = {"A이다~","B란다~"};
        final String[] p_1title = {"1-A 프로젝트","1-B 프로젝트"};
        final String[] p_1sub = {"A화이팅~","B이야~"};

        String[] s_2title = {"2-A 스터디","2-B 스터디"};
        String[] s_2sub = {"A입니다~","B랍니다~"};
        String[] c_2title = {"2-A 공모전","2-B 공모전"};
        String[] c_2sub = {"A이다~","B란다~"};
        String[] p_2title = {"2-A 프로젝트","2-B 프로젝트"};
        String[] p_2sub = {"A화이팅~","B이야~"};

        String[] s_3title = {"3-A 스터디","3-B 스터디"};
        String[] s_3sub = {"A입니다~","B랍니다~"};
        String[] c_3title = {"3-A 공모전","3-B 공모전"};
        String[] c_3sub = {"A이다~","B란다~"};
        String[] p_3title = {"3-A 프로젝트","3-B 프로젝트"};
        String[] p_3sub = {"A화이팅~","B이야~"};

        String[] s_4title = {"4-A 스터디","4-B 스터디"};
        String[] s_4sub = {"A입니다~","B랍니다~"};
        String[] c_4title = {"4-A 공모전","4-B 공모전"};
        String[] c_4sub = {"A이다~","B란다~"};
        String[] p_4title = {"4-A 프로젝트","4-B 프로젝트"};
        String[] p_4sub = {"A화이팅~","B이야~"};

        s1listview = (ListView) findViewById(R.id.s_1list);
        c1listview = (ListView) findViewById(R.id.c_1list);
        p1listview = (ListView) findViewById(R.id.p_1list);
        sp1listview = (ListView) findViewById(R.id.sp_1list);

        s2listview = (ListView) findViewById(R.id.s_2list);
        c2listview = (ListView) findViewById(R.id.c_2list);
        p2listview = (ListView) findViewById(R.id.p_2list);
        sp2listview = (ListView) findViewById(R.id.sp_2list);

        s3listview = (ListView) findViewById(R.id.s_3list);
        c3listview = (ListView) findViewById(R.id.c_3list);
        p3listview = (ListView) findViewById(R.id.p_3list);
        sp3listview = (ListView) findViewById(R.id.sp_3list);

        s4listview = (ListView) findViewById(R.id.s_4list);
        c4listview = (ListView) findViewById(R.id.c_4list);
        p4listview = (ListView) findViewById(R.id.p_4list);
        g4listview = (ListView) findViewById(R.id.g_4list);
        sp4listview = (ListView) findViewById(R.id.sp_4list);

        //s1listview
        ArrayList<DataPut> s_1list = new ArrayList<>();
        for(int i=0;i<s_1title.length;i++){
            s_1list.add(new DataPut(s_1title[i],s_1sub[i]));
        }
        final ArrayList<HashMap<String,String>> s_1maplist = new ArrayList<>();
        for(DataPut d : s_1list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            s_1maplist.add(map);
        }
        SimpleAdapter s_1sa = new SimpleAdapter(this,s_1maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        s1listview.setAdapter(s_1sa);
        ///리스트 클릭 시 세부사항 ui로 넘어감( > finishlook.xml)
        s1listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String s_1t = s_1title[position];
                String s_1s = s_1sub[position];
                Intent intent = new Intent(getApplicationContext(),FinishLookActivity.class);
                intent.putExtra("title",s_1t);
                intent.putExtra("Sub",s_1s);
                startActivity(intent);
            }
        });
        //c1listview
        ArrayList<DataPut> c_1list = new ArrayList<>();
        for(int i=0;i<c_1title.length;i++){
            c_1list.add(new DataPut(c_1title[i],c_1sub[i]));
        }
        ArrayList<HashMap<String,String>> c_1maplist = new ArrayList<>();
        for(DataPut d : c_1list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            c_1maplist.add(map);
        }
        SimpleAdapter c_1sa = new SimpleAdapter(this,c_1maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        c1listview.setAdapter(c_1sa);
        ///리스트 클릭 시 세부사항 ui로 넘어감( > finishlook.xml)
        c1listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String c_1t = c_1title[position];
                String c_1s = c_1sub[position];
                Intent intent = new Intent(getApplicationContext(),FinishLookActivity.class);
                intent.putExtra("title",c_1t);
                intent.putExtra("Sub",c_1s);
                startActivity(intent);
            }
        });
        //p1listview
        ArrayList<DataPut> p_1list = new ArrayList<>();
        for(int i=0;i<p_1title.length;i++){
            p_1list.add(new DataPut(p_1title[i],p_1sub[i]));
        }
        ArrayList<HashMap<String,String>> p_1maplist = new ArrayList<>();
        for(DataPut d : p_1list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            p_1maplist.add(map);
        }
        SimpleAdapter p_1sa = new SimpleAdapter(this,p_1maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        p1listview.setAdapter(p_1sa);
        ///리스트 클릭 시 세부사항 ui로 넘어감( > finishlook.xml)
        p1listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String p_1t = p_1title[position];
                String p_1s = p_1sub[position];
                Intent intent = new Intent(getApplicationContext(),FinishLookActivity.class);
                intent.putExtra("title",p_1t);
                intent.putExtra("Sub",p_1s);
                startActivity(intent);
            }
        });

        //s2listview
        ArrayList<DataPut> s_2list = new ArrayList<>();
        for(int i=0;i<s_2title.length;i++){
            s_2list.add(new DataPut(s_2title[i],s_2sub[i]));
        }
        ArrayList<HashMap<String,String>> s_2maplist = new ArrayList<>();
        for(DataPut d : s_2list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            s_2maplist.add(map);
        }
        SimpleAdapter s_2sa = new SimpleAdapter(this,s_2maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        s2listview.setAdapter(s_2sa);
        //c2listview
        ArrayList<DataPut> c_2list = new ArrayList<>();
        for(int i=0;i<c_2title.length;i++){
            c_2list.add(new DataPut(c_2title[i],c_2sub[i]));
        }
        ArrayList<HashMap<String,String>> c_2maplist = new ArrayList<>();
        for(DataPut d : c_2list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            c_2maplist.add(map);
        }
        SimpleAdapter c_2sa = new SimpleAdapter(this,c_2maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        c2listview.setAdapter(c_2sa);
        //p2listview
        ArrayList<DataPut> p_2list = new ArrayList<>();
        for(int i=0;i<p_2title.length;i++){
            p_2list.add(new DataPut(p_2title[i],p_2sub[i]));
        }
        ArrayList<HashMap<String,String>> p_2maplist = new ArrayList<>();
        for(DataPut d : p_2list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            p_2maplist.add(map);
        }
        SimpleAdapter p_2sa = new SimpleAdapter(this,p_2maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        p2listview.setAdapter(p_2sa);

        //s3listview
        ArrayList<DataPut> s_3list = new ArrayList<>();
        for(int i=0;i<s_3title.length;i++){
            s_3list.add(new DataPut(s_3title[i],s_3sub[i]));
        }
        ArrayList<HashMap<String,String>> s_3maplist = new ArrayList<>();
        for(DataPut d : s_3list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            s_3maplist.add(map);
        }
        SimpleAdapter s_3sa = new SimpleAdapter(this,s_3maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        s3listview.setAdapter(s_3sa);
        //c3listview
        ArrayList<DataPut> c_3list = new ArrayList<>();
        for(int i=0;i<c_3title.length;i++){
            c_3list.add(new DataPut(c_3title[i],c_3sub[i]));
        }
        ArrayList<HashMap<String,String>> c_3maplist = new ArrayList<>();
        for(DataPut d : c_3list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            c_3maplist.add(map);
        }
        SimpleAdapter c_3sa = new SimpleAdapter(this,c_3maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        c3listview.setAdapter(c_3sa);
        //p3listview
        ArrayList<DataPut> p_3list = new ArrayList<>();
        for(int i=0;i<p_3title.length;i++){
            p_3list.add(new DataPut(p_3title[i],p_3sub[i]));
        }
        ArrayList<HashMap<String,String>> p_3maplist = new ArrayList<>();
        for(DataPut d : p_3list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            p_3maplist.add(map);
        }
        SimpleAdapter p_3sa = new SimpleAdapter(this,p_3maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        p3listview.setAdapter(p_3sa);

        //s4listview
        ArrayList<DataPut> s_4list = new ArrayList<>();
        for(int i=0;i<s_4title.length;i++){
            s_4list.add(new DataPut(s_4title[i],s_4sub[i]));
        }
        ArrayList<HashMap<String,String>> s_4maplist = new ArrayList<>();
        for(DataPut d : s_4list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            s_4maplist.add(map);
        }
        SimpleAdapter s_4sa = new SimpleAdapter(this,s_4maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        s4listview.setAdapter(s_4sa);
        //c4listview
        ArrayList<DataPut> c_4list = new ArrayList<>();
        for(int i=0;i<c_4title.length;i++){
            c_4list.add(new DataPut(c_4title[i],c_4sub[i]));
        }
        ArrayList<HashMap<String,String>> c_4maplist = new ArrayList<>();
        for(DataPut d : c_4list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            c_4maplist.add(map);
        }
        SimpleAdapter c_4sa = new SimpleAdapter(this,c_4maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        c4listview.setAdapter(c_4sa);
        //p4listview
        ArrayList<DataPut> p_4list = new ArrayList<>();
        for(int i=0;i<p_4title.length;i++){
            p_4list.add(new DataPut(p_4title[i],p_4sub[i]));
        }
        ArrayList<HashMap<String,String>> p_4maplist = new ArrayList<>();
        for(DataPut d : p_4list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            p_4maplist.add(map);
        }
        SimpleAdapter p_4sa = new SimpleAdapter(this,p_4maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        p4listview.setAdapter(p_4sa);
        //g4listview
        ArrayList<DataPut> g_4list = new ArrayList<DataPut>();
        g_4list.add(new DataPut("4-나의 졸업작품","아자아자---"));

        ArrayList<HashMap<String,String>> g_4maplist = new ArrayList<HashMap<String, String>>();
        for(DataPut d : g_4list){
            HashMap map = new HashMap();
            map.put("title",d.title);
            map.put("sub",d.sub);
            g_4maplist.add(map);
        }
        SimpleAdapter g_4sa = new SimpleAdapter(this,g_4maplist,android.R.layout.simple_list_item_2,
                new String[]{"title","sub"},new int[]{android.R.id.text1,android.R.id.text2});
        g4listview.setAdapter(g_4sa);

        //Tab(1~4학년)
        TabHost ftabhost = (TabHost) findViewById(R.id.ftabhost);
        ftabhost.setup();


        TabHost.TabSpec fts1 = ftabhost.newTabSpec("f Tab Spec 1");
        fts1.setContent(R.id.tabfirst);
        fts1.setIndicator("1학년");
        ftabhost.addTab(fts1);

        TabHost.TabSpec fts2 = ftabhost.newTabSpec("f Tab Spec 2");
        fts2.setContent(R.id.tabsecond);
        fts2.setIndicator("2학년");
        ftabhost.addTab(fts2);

        TabHost.TabSpec fts3 = ftabhost.newTabSpec("f Tab Spec 3");
        fts3.setContent(R.id.tabthird);
        fts3.setIndicator("3학년");
        ftabhost.addTab(fts3);

        TabHost.TabSpec fts4 = ftabhost.newTabSpec("f Tab Spec 4");
        fts4.setContent(R.id.tabfour);
        fts4.setIndicator("4학년");
        ftabhost.addTab(fts4);

        ftabhost.setCurrentTab(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.pp_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:{ //뒤로가기 버튼 눌렀을 때
                finish();
                return true;
            }
            case R.id.toolbar_create_button:{ //생성 버튼 눌렀을 때 > 완료활동생성.java 으로 이동
               Intent intent = new Intent(getApplicationContext(),FinishCreateActivity.class);
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
