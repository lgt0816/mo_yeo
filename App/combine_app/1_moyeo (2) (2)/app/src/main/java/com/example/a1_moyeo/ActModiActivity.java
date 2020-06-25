package com.example.a1_moyeo;

import android.content.DialogInterface;
import android.content.Intent;
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

public class ActModiActivity extends AppCompatActivity {
    EditText edit_acttitle,edit_actcontent;
    String ok,get_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actwrite);

        Toolbar toolbar = findViewById(R.id.actwrite_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);

        edit_acttitle = (EditText) findViewById(R.id.edit_acttitle);
        edit_actcontent = (EditText) findViewById(R.id.edit_actcontent);

        get_id = ((MainActivity)MainActivity.context_login).long_id;

        String a_title,a_content;
        Bundle intent = getIntent().getExtras();
        a_title = intent.getString("title");
        a_content = intent.getString("content");
        edit_acttitle.setText(a_title);
        edit_actcontent.setText(a_content);



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
                alarm.setTitle("내용 수정 취소");
                alarm.setMessage(" 수정을 취소하시겠습니까?\n(입력한 내용은 저장되지 않습니다.)");
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
                ok = "UPDATE03";
                Object rcvDataFromServer = null;
                try {
                    new CommAPI().execute(ok,edit_acttitle.getText().toString(),edit_actcontent.getText().toString()).get();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),"활동이 수정되었습니다.",Toast.LENGTH_LONG).show();
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
