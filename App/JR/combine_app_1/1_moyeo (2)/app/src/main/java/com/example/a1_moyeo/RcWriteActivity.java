package com.example.a1_moyeo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a1_moyeo.comm_api.CommAPI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RcWriteActivity extends AppCompatActivity {
    EditText Rcwrite_number,Rcwrite_gradu,Rcwrite_context,Rcwrite_rule,Rcwrite_title,Rcwrite_subtitle;
    Spinner Rcwrite_type;
    String get_id = ((MainActivity)MainActivity.context_login).long_id;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rcwrite);



        Toolbar toolbar = findViewById(R.id.rcwrite_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Rcwrite_type = (Spinner)findViewById(R.id.rcwrite_type);
        Rcwrite_title = (EditText)findViewById(R.id.rcwrite_title);
        Rcwrite_subtitle = (EditText)findViewById(R.id.rcwrite_subtitle);
       // Rcwrite_number = (EditText)findViewById(R.id.rcwrite_number);
       // Rcwrite_gradu = (EditText)findViewById(R.id.rcwrite_gradu);
        Rcwrite_context = (EditText)findViewById(R.id.rcwrite_context);
        Rcwrite_rule = (EditText)findViewById(R.id.rcwrite_rule);

        String[] RC_writelist ={"스터디","공모전","프로젝트"};
        ArrayAdapter<String> gradu_arrayadapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,RC_writelist);
        Rcwrite_type.setAdapter(gradu_arrayadapter);
        Rcwrite_type.setSelection(0);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.ff_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //뒤로가기 버튼 눌렀을 때
                //finish();
                // return true;
                //알림 한 번 띄우기(취소 하시겠습니까?)
                AlertDialog.Builder alarm = new AlertDialog.Builder(this);
                alarm.setTitle("취소");
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
            case R.id.toolbar_finish_button:{ //완료 버튼 눌렀을 때

                String ok = "INSERT02";
                String type = Rcwrite_type.getSelectedItem().toString();
                String title = Rcwrite_title.getText().toString();
                String subtitle = Rcwrite_subtitle.getText().toString();
             //   String number = Rcwrite_number.getText().toString();
              //  String gradu = Rcwrite_gradu.getText().toString();
                String context = Rcwrite_context.getText().toString();
                String rule = Rcwrite_rule.getText().toString();
                Date day = Calendar.getInstance().getTime();
               // DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(day);

                Object rcvDataFromServer = null;
                try {
                    rcvDataFromServer = new CommAPI().execute(ok,title,subtitle,context,rule,date,get_id,type).get();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                if(rcvDataFromServer.toString()=="OK"){
                    Toast.makeText(getApplicationContext(),"생성 성공",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"생성 실패",Toast.LENGTH_LONG).show();
                }
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
