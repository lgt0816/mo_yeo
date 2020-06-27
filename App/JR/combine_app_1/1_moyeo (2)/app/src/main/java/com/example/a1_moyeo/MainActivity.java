package com.example.a1_moyeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1_moyeo.comm_api.CommAPI;

public class MainActivity extends AppCompatActivity {
    EditText Loging_id,Login_pw;
    public static Context context_login;
    public String long_id,long_pw;

    CommAPI comma = new CommAPI();
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
                String arra[] = new String[3];
                String ok = "SELECT01";
                Object rcvDataFromServer = null;
                try {
                   ///////// comma.execute(ok,id,pw);
                  //  if(comma.get().toString().contains("OK")){
                     ////////////   rcvDataFromServer = comma.get().toString();
                  //  }
                    rcvDataFromServer = comma.execute(ok,id,pw).get();
                    //comma.execute(ok,id,pw);
                  //  rcvDataFromServer = comma.result;
                    arra[0] = rcvDataFromServer.toString();
                    //arra= rcvDataFromServer.toString();
                  //i++;
                    while(!rcvDataFromServer.toString().contains(null)){
                        comma.execute(ok,id,pw);
                        //  if(comma.get().toString().contains("OK")){
                        rcvDataFromServer = comma.get().toString();
                      // comma.execute(ok,id,pw);
                        arra[0] = rcvDataFromServer.toString();
                       // i++;
                       // arra = rcvDataFromServer.toString();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }

                if(rcvDataFromServer.toString().startsWith("FALSE")){
                    Toast.makeText(getApplicationContext(),"아이디 혹은 비밀번호가 맞지 않습니다",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_LONG).show();
                    //intent.putExtra("getdata",rcv1);
                    intent.putExtra("getdata",arra[0]);
                    startActivity(intent);
                    Loging_id.setText("");
                    Login_pw.setText("");
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
