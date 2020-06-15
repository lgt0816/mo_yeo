package com.example.a1_moyeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

   /* private Handler mHandler;
    Socket socket;
    private String ip = "218.155.247.192"; //"172.16.104.219"
    private int port = 25000;
    EditText login_id;

    @Override
    protected void onStop() {
        super.onStop();
        try{
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_signup = (Button)findViewById(R.id.btn_signup);
        Button btn_login = (Button)findViewById(R.id.btn_login);
        Button btn_searchpw = (Button)findViewById(R.id.btn_searchpw);
        //login_id = (EditText) findViewById(R.id.login_id);

        /*try{
            InetAddress serverAddr = InetAddress.getByName(ip);
            socket = new Socket(serverAddr,port);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        //ConnectThread th = new ConnectThread();
       // th.start();


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
               /* if(login_id.getText().toString() != null || !login_id.getText().toString().equals("")){
                    ConnectThread th = new ConnectThread();
                    th.start();
                }*/
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });

        btn_searchpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PwActivity.class);
                startActivity(intent);
            }
        });
    }

    /*class ConnectThread extends Thread{
        public void run(){
            try{
                String sndMsg = login_id.getText().toString();
                Log.d("===========", sndMsg);

                PrintWriter out = new PrintWriter(new BufferedWriter(new
                        OutputStreamWriter(socket.getOutputStream(),"EUC-KR")),true);

                out.println(sndMsg);

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(),"EUC-KR"));
                String read = input.readLine();

                mHandler.post(new msgUpdate(read));
                Log.d("===========", read);
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    class msgUpdate implements Runnable{
        private String msg;
        public msgUpdate(String str){
            this.msg = str;
        }

        @Override
        public void run() {
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
        }
    };*/
}
