package com.example.a1_moyeo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MemowriteActivity extends AppCompatActivity {
    TextView memo_wtitle,memo_wsub,memo_wcontent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memowrite);

        Toolbar toolbar = findViewById(R.id.mmwtoolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        actionBar.setDisplayHomeAsUpEnabled(true);

        memo_wtitle = (TextView) findViewById(R.id.memo_wtitle);
        memo_wcontent = (TextView) findViewById(R.id.memo_wcontent);
        memo_wsub = (TextView) findViewById(R.id.memo_subtitle);

        Bundle intent = getIntent().getExtras();
        memo_wtitle.setText(intent.getString("ing_c_title"));
        memo_wsub.setText(intent.getString("ing_c_sub"));
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
                finish();
                Intent intent = new Intent(getApplicationContext(), MemoActivity.class);
                 startActivity(intent);
                //활동 내용 저장.
                Toast.makeText(getApplicationContext(),"활동이 수정되었습니다.",Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
