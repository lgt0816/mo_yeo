package com.example.a1_moyeo;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class ActWriteActivity extends AppCompatActivity {
    private TextView STtext, EDtext;
    private Button STbtn, EDbtn;
    private DatePickerDialog.OnDateSetListener callbackMethod;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actwrite);
        Toolbar toolbar = findViewById(R.id.actwrite_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        STtext = (TextView)findViewById(R.id.sttext);
        EDtext = (TextView)findViewById(R.id.edtext);
        STbtn =(Button)findViewById(R.id.stbtn);
        STbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCalendar = Calendar.getInstance();
                int mYear = mCalendar.get(Calendar.YEAR);
                int mMonth = mCalendar.get(Calendar.MONTH);
                int mDay = mCalendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(ActWriteActivity.this,callbackMethod,mYear,mMonth,mDay);
                callbackMethod = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;
                        STtext.setText(year+"년 "+monthOfYear+"월 "+dayOfMonth+"일 ");
                    }
                };
                dialog.show();
            }
        });
        EDbtn = (Button)findViewById(R.id.edbtn);
        EDbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCalendar = Calendar.getInstance();
                int mYear = mCalendar.get(Calendar.YEAR);
                int mMonth = mCalendar.get(Calendar.MONTH);
                int mDay = mCalendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(ActWriteActivity.this,callbackMethod,mYear,mMonth,mDay);
                callbackMethod = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;
                        EDtext.setText(year+"년 "+monthOfYear+"월 "+dayOfMonth+"일 ");
                    }
                };
                dialog.show();
            }
        });

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
                alarm.setTitle("내용 작성 취소");
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
                //Intent intent = new Intent(getApplicationContext(),FinishFeelActivity.class);
                // startActivity(intent);
                //활동 내용 저장.
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
