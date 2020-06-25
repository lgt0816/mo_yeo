package com.example.a1_moyeo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a1_moyeo.comm_api.CommAPI;

public class NotiWriteActivity extends AppCompatActivity {
    EditText edit_notititle,edit_noticontent;
    String ok,pro_id, get_id;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notiwrite);

        Toolbar toolbar = findViewById(R.id.notiwrite_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

       get_id = ((MainActivity)MainActivity.context_login).long_id;

        edit_notititle = (EditText) findViewById(R.id.edit_notititle);
        edit_noticontent = (EditText) findViewById(R.id.edit_noticontent);

        Bundle intent = getIntent().getExtras();
        pro_id = intent.getString("pro_id");

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
                //공지 내용 저장.
                ok = "INSERT07";
                Object rcvDataFromServer1 = null;
                try {
                    rcvDataFromServer1 = new CommAPI().execute(ok,edit_notititle.getText(),edit_noticontent.getText(),pro_id).get();

                }catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(),"공지가 생성되었습니다.",Toast.LENGTH_LONG).show();
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
