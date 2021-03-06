package com.example.a1_moyeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1_moyeo.comm_api.CommAPI;

public class MainActivity extends AppCompatActivity {
    EditText Loging_id,Login_pw;
    public static Context context_login;
    public String long_id,long_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_signup = (Button)findViewById(R.id.btn_signup);
        Button btn_login = (Button)findViewById(R.id.btn_login);
        //Button btn_searchpw = (Button)findViewById(R.id.btn_searchpw);
        Loging_id = (EditText)findViewById(R.id.login_id);
        Login_pw = (EditText)findViewById(R.id.login_pw);

        context_login = this;

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = Loging_id.getText().toString();
                String pw = Login_pw.getText().toString();
                long_id = id;
                long_pw = pw;

                int i=0;
               // String arra = new String();
                String arra[] = new String[200];
                String ok = "SELECT01";
                Object rcvDataFromServer = null;
                try {
                    rcvDataFromServer = new CommAPI().execute(ok,id,pw).get();
                    Log.i("rcvDataFromServer is", rcvDataFromServer.toString());

                    //옮김
                    if(rcvDataFromServer.toString().startsWith("FALSE")){
                        Toast.makeText(getApplicationContext(),"아이디 혹은 비밀번호가 맞지 않습니다",Toast.LENGTH_LONG).show();
                    }else{
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_LONG).show();
                        //intent.putExtra("getdata",rcv1);
                        intent.putExtra("getdata",rcvDataFromServer.toString());
                        startActivity(intent);
                        Loging_id.setText("");
                        Login_pw.setText("");
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

      /*  btn_searchpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PwActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
