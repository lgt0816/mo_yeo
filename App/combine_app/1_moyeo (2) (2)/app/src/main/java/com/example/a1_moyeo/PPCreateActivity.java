package com.example.a1_moyeo;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTabHost;

import com.example.a1_moyeo.comm_api.CommAPI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class PPCreateActivity extends AppCompatActivity {
    String ok="";
    String ok1="";
    String act1_id1;
    String[] pptitle;
    String[] data05;
    String [] sb;
    String [] sb_num;
    ListView ppcreate_list;
//    List<String> selectedacts = new ArrayList<>();
//    EditText titletext ;

    String popol_id;
    Object rcvDataFromServer0 = null;
    Object rcvDataFromServer = null;
    Object rcvDataFromServer1 = null;
    Object rcvDataFromServer2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppcreate);

        Toolbar toolbar = findViewById(R.id.ppctoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ok = "SELECT05";
        String select05;
        String get_id = ((MainActivity)MainActivity.context_login).long_id;
        Object rcvDataFromServer = null;
        try {
            rcvDataFromServer = new CommAPI().execute(ok,get_id).get();

        }catch (Exception e) {
            e.printStackTrace();
        }
        int num=0;
        select05 = rcvDataFromServer.toString();
        data05 = select05.split("ㅩ");//1학년,2제목,3활동타입,4진행시작,5진행끝

        pptitle = new String[data05.length/5];

        for(int i=0;i<data05.length;i++) {
            if (i % 5 == 2) {
                pptitle[num] = data05[i];//활동제목
                num++;
            }
        }

        ppcreate_list = (ListView) findViewById(R.id.ppcreate_list);
////
        ArrayList<String> pplist = new ArrayList<>();
        if(pptitle.length == 0){
            pplist.add(" 게시된 공지가 없습니다.");
        }else {
            for (int i = 0; i < pptitle.length; i++) {
                pplist.add(pptitle[i]);
            }
        }
        ArrayAdapter<String> pp_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, pplist);
        ppcreate_list.setAdapter(pp_adapter);

    }//////에러 뜨는 곳

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.ff_toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                //알림 한 번 띄우기(취소 하시겠습니까?)
                AlertDialog.Builder alarm = new AlertDialog.Builder(this);
                alarm.setTitle("포트폴리오 취소");
                alarm.setMessage(" 취소하시겠습니까?\n(본 내용은 저장되지 않습니다.)");
                alarm.setCancelable(false);
                alarm.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alarm.setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog alarm_dialog = alarm.create();
                alarm_dialog.show();
                break;
            }
            case R.id.toolbar_finish_button: {//완료 버튼
                SparseBooleanArray checkedItemPositions = ppcreate_list.getCheckedItemPositions();
                //StringBuilder sb = new StringBuilder();
                sb = new String[pptitle.length];
                sb_num = new String[pptitle.length];
                for(int j=0;j<pptitle.length;j++){
                    if (checkedItemPositions.get(j)){
                        sb[j] = pptitle[j];
                       // sb.append(pptitle[j]);
                    }//sb 배열 : 해당 포트폴리오의 활동제목 모임
                }

                //활동 제목 AlertDialog
                AlertDialog.Builder alarm = new AlertDialog.Builder(this);
                alarm.setTitle("포트폴리오 생성");
                alarm.setMessage("포트폴리오 제목을 설정하세요");
                final EditText titletext = new EditText(PPCreateActivity.this);
                alarm.setView(titletext) ;
                alarm.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alarm.setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // String pptitle = titletext.getText().toString();
                       // finish();
                        //포폴정보>

                        String pptitle = titletext.getText().toString();
                        Date day = Calendar.getInstance().getTime();
                        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(day);//
                        String pp_id = ((MainActivity) MainActivity.context_login).long_id;//
                        int aa=0;

                        try {
                            ok = "INSERT03";
                            new CommAPI().execute(ok, pptitle, date, pp_id);//사용자 학번, 생성날짜,포트폴리오 타이틀
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            ;//포폴제목>포폴id
                            ok = "SELECT06";
                            rcvDataFromServer = new CommAPI().execute(ok, pptitle).get();//포폴id get
                            popol_id = rcvDataFromServer.toString();//포폴id get
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            ok = "SELECT07";//*(활동id/제목받음)>활동id추출해야함 /////문제부분///// <---여기에서
//                            for (int i = 0; i < sb.length; i++) {
//                                rcvDataFromServer1 = new CommAPI().execute(ok, sb[i]).get();//,act_id,act_title get
//                                act1_id[aa] = rcvDataFromServer1.toString();
//                                aa++;
//                            }

                            rcvDataFromServer1 = new CommAPI().execute(ok).get();
                            String act1_id[] = rcvDataFromServer1.toString().split("ㅩ");//활동 id, 활동 title
                            int num=0;
                            for(int i=1;i<act1_id.length;i++){ //<--여기요ㅠㅠ
                                if(i%2==0){
                                    for(int j=1;j<sb.length;j++){
                                        if(sb[j] !=null && act1_id[i].contains(sb[j])){
                                            sb_num[num] = act1_id[i-1]; //해당 활동id담기
                                            num++; //여기서
                                        }
                                    }
                                }
                            }

                        } catch (Exception e) {
                            Log.e("error",e.toString());
                        }///넘어가지마

                            try { //여기로 가버려요ㅠ
                                ok1 = "INSERT04"; //포폴id,활동id로 insert
                                for(int t=0;t<sb_num.length;t++){
                                    if(sb_num[t] != null){
                                        try {
                                            rcvDataFromServer2 = new CommAPI().execute(ok1, popol_id, sb_num[t]).get();
                                        }catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }

                                }
                                ////rcvDataFromServer2 = new CommAPI().execute(ok, popol_id, act1_id1).get();
                            }catch (Exception e) {
                                e.printStackTrace();
                            }



                        if (rcvDataFromServer2.toString() == "OK") {
                            Toast.makeText(getApplicationContext(), "포트폴리오 생성 완료", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "포트폴리오 생성 실패", Toast.LENGTH_LONG).show();
                        }//
                        finish();
                    }
                });
                AlertDialog alarm_dialog = alarm.create();
                alarm_dialog.show();

                    }

            }

        return super.onOptionsItemSelected(item);
    }

}


