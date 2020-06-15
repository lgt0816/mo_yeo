package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a1_moyeo.comm_api.CommAPI;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button btn_signup_ok = (Button) findViewById(R.id.btn_signup_ok);
        final EditText signup_id,signup_pw,signup_rpw,signup_name,signup_number,signup_email; //라디오, 스피너 값 받아오는 방법 고민 필요!

        signup_id = (EditText)findViewById(R.id.signup_id);
        signup_pw = (EditText)findViewById(R.id.signup_pw);
        signup_rpw = (EditText)findViewById(R.id.signup_rpw);
        signup_name = (EditText)findViewById(R.id.signup_name);
        signup_number = (EditText)findViewById(R.id.signup_number);
        signup_email = (EditText)findViewById(R.id.signup_email);
        final TextView textView = (TextView)findViewById(R.id.textview1);

        btn_signup_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ok = "SELECT";
               // String id = signup_id.getText().toString();
               // String pw = signup_pw.getText().toString();
              //  String rpw = signup_rpw.getText().toString();
               // String name = signup_name.getText().toString();
                //String number = signup_number.getText().toString();
               // String email = signup_email.getText().toString();
               CommAPI comma = new CommAPI();
                //comma.execute(ok,id,pw,rpw);
                comma.execute(ok);
                String send = comma.result;
                System.out.println(send);
                textView.setText(send);
               // finish();
                //Intent intent = new Intent(getApplicationContext(),EmailCheckActivity.class);
               // startActivity(intent);
            }
        });

        ArrayList<String> email_arraylist = new ArrayList<>();
        email_arraylist.add("office.sungkyul.ac.kr");
        email_arraylist.add("sungkyul.ac.kr");

        ArrayAdapter<String> email_arrayadapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,email_arraylist);

        Spinner email_spinner = (Spinner) findViewById(R.id.email_spinner);
        email_spinner.setAdapter(email_arrayadapter);
    }
}
