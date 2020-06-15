package com.example.a1_moyeo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Toolbar toolbar =(Toolbar)findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button btn_g,btn_gg;
        LinearLayout home_ing, home_rc, rq_click,myrc_click,ing_click,finish_click,pp_click,myrv_click,logout_click;
        home_ing = (LinearLayout) findViewById(R.id.home_ing);
        home_rc = (LinearLayout) findViewById(R.id.home_rc);
        btn_g = (Button) findViewById(R.id.btn_g);
        btn_gg = (Button) findViewById(R.id.btn_gg);

        //my_tab
        rq_click = (LinearLayout) findViewById(R.id.rq_click);
        myrc_click = (LinearLayout) findViewById(R.id.myrc_click);
        ing_click = (LinearLayout) findViewById(R.id.ing_click);
        finish_click = (LinearLayout) findViewById(R.id.finish_click);
        pp_click = (LinearLayout) findViewById(R.id.pp_click);
        myrv_click = (LinearLayout) findViewById(R.id.myrv_click);
        logout_click = (LinearLayout) findViewById(R.id.logout_click);

        rq_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RqListActivity.class);
                startActivity(intent);
            }
        });

        myrc_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyRcListActivity.class);
                startActivity(intent);
            }
        });

        ing_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IngListActivity.class);
                startActivity(intent);
            }
        });

        finish_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FinishListActivity.class);
                startActivity(intent);
            }
        });

        pp_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PPListActivity.class);
                startActivity(intent);
            }
        });

        myrv_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyReviseActivity.class);
                startActivity(intent);
            }
        });

        logout_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alarm = new AlertDialog.Builder(HomeActivity.this);
                alarm.setTitle("로그아웃");
                alarm.setMessage(" 로그아웃 하시겠습니까?");
                alarm.setCancelable(false);
                alarm.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                alarm.setNegativeButton("로그아웃", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog alarm_dialog = alarm.create();
                alarm_dialog.show();
            }
        });

        //home_tab
        home_ing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),IngListActivity.class);
                startActivity(intent);
            }
        });

        home_rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RcListActivity.class);
                startActivity(intent);
            }
        });

        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GProjectListActivity.class);
                startActivity(intent);
            }
        });

        btn_gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GGProjectCheckActivity.class);
                startActivity(intent);
            }
        });

        //portfolio_tab

/*<LinearLayout
                    android:id="@+id/portfolio_tab"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:orientation="vertical">
                    <ScrollView
                        android:layout_width="match_parent"
                        android:layout_height="match_parent">
                        <LinearLayout
                            android:layout_width="match_parent"
                            android:layout_height="match_parent"
                            android:orientation="vertical">
                            <TextView
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:layout_gravity="center"
                                android:textSize="50dp"
                                android:text="ok!"/>
                        </LinearLayout>
                    </ScrollView>
                </LinearLayout>*/

        //Tab(my,home)
        TabHost h_tabhost = (TabHost) findViewById(R.id.home_tabhost);
        h_tabhost.setup();


        TabHost.TabSpec my_tab = h_tabhost.newTabSpec("Tab Spec my");
        my_tab.setContent(R.id.my_tab);
        my_tab.setIndicator("MY");
        h_tabhost.addTab(my_tab);

        TabHost.TabSpec home_tab = h_tabhost.newTabSpec("Tab Spec home");
        home_tab.setContent(R.id.home_tab);
        home_tab.setIndicator("HOME");
        h_tabhost.addTab(home_tab);

        /*TabHost.TabSpec pp_tab = h_tabhost.newTabSpec("Tab Spec portfolio");
        pp_tab.setContent(R.id.portfolio_tab);
        pp_tab.setIndicator("Portfolio");
        h_tabhost.addTab(pp_tab);*/

        h_tabhost.setCurrentTab(1);
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
