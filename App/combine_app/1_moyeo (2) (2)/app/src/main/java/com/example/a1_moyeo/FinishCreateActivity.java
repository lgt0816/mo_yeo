package com.example.a1_moyeo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a1_moyeo.comm_api.CommAPI;

public class FinishCreateActivity extends AppCompatActivity {

    EditText Fc_year,Fc_major,Fc_text,Fc_result;
    Spinner Fc_gradu,Fc_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finishcreate);

        Toolbar toolbar = findViewById(R.id.finishcreate_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
/*
        Fc_year = (EditText)findViewById(R.id.fc_year);
        Fc_gradu = (Spinner)findViewById(R.id.fc_gradu);
        Fc_major = (EditText)findViewById(R.id.fc_major);
        Fc_text = (EditText)findViewById(R.id.fc_text);
        Fc_result = (EditText)findViewById(R.id.fc_result);
        Fc_score = (Spinner)findViewById(R.id.fc_score);

        String[] fc_gradulist ={"1","2","3","4"};
        ArrayAdapter<String> gradu_arrayadapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,fc_gradulist);
        Fc_gradu.setAdapter(gradu_arrayadapter);
        Fc_gradu.setSelection(0);
        String[] fc_scorelist = {"A+","A","B+","B","C+","C","D+","D","F","없음"};
        ArrayAdapter<String> score_arrayadapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,fc_scorelist);
        Fc_score.setAdapter(score_arrayadapter);
        Fc_score.setSelection(0);
*/
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
                alarm.setTitle("생성 취소");
                alarm.setMessage(" 입력을 취소하시겠습니까?\n(입력한 내용은 저장되지 않습니다.)");
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
                /*Intent intent = new Intent(getApplicationContext(),FinishFeelActivity.class);
                 startActivity(intent);
                String ok = "INSERT03";
                String year = Fc_year.getText().toString();
                String gradu = Fc_gradu.getSelectedItem().toString();
                String major = Fc_major.getText().toString();
                String text = Fc_text.getText().toString();
                String result =  Fc_result.getText().toString();
                String score = Fc_score.getSelectedItem().toString();

                Object rcvDataFromServer = null;
                try {
                    rcvDataFromServer = new CommAPI().execute(ok,year,gradu,major,text,result,score).get();
                }catch (Exception e) {
                    e.printStackTrace(); }
                if(rcvDataFromServer.toString()=="OK"){
                    Toast.makeText(getApplicationContext(),"정보 등록 완료",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"정보 등록 실패",Toast.LENGTH_LONG).show();
                }

                finish();
                return true;*/
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
