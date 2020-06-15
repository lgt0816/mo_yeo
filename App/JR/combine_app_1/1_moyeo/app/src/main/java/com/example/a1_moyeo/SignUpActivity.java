package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    EditText signup_id,signup_pw,signup_rpw,signup_name,signup_number,signup_email; //라디오, 스피너 값 받아오는 방법 고민 필요!
    Spinner email_spinner;
    RadioGroup signup_bg;
    //ConnectTask asyncTask;
    //ArrayList<MemberDTO> member = new ArrayList<MemberDTO>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button btn_signup_ok = (Button) findViewById(R.id.btn_signup_ok);

        //asyncTask = new ConnectTask();

        signup_id = (EditText) findViewById(R.id.signup_id);
        signup_pw = (EditText) findViewById(R.id.signup_pw);
        signup_rpw = (EditText) findViewById(R.id.signup_rpw);
        signup_name = (EditText) findViewById(R.id.signup_name);
        signup_number = (EditText) findViewById(R.id.signup_number);
        signup_email = (EditText) findViewById(R.id.signup_email);

        email_spinner = (Spinner)findViewById(R.id.email_spinner);//String text = email_spinner.getSelectedItem().toString();

        signup_bg = (RadioGroup) findViewById(R.id.signup_bg);


        btn_signup_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String server_check = "INSERT";
                new ConnectTask().execute(server_check,signup_id.getText().toString(),signup_pw.getText().toString());

                RadioButton rd = (RadioButton) findViewById(signup_bg.getCheckedRadioButtonId());
                String pp=server_check+signup_id.getText().toString()+signup_pw.getText().toString();
               // String pp = signup_id.getText().toString()+signup_email.getText().toString()+"@"+email_spinner.getSelectedItem().toString()+rd.getText().toString();
               // member.add();
                Toast.makeText(getApplicationContext(),pp,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),EmailCheckActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        ArrayList<String> email_arraylist = new ArrayList<>();
//        email_arraylist.add("office.sungkyul.ac.kr");
//        email_arraylist.add("sungkyul.ac.kr");
        String[] email_arraylist = {"office.sungkyul.ac.kr","sungkyul.ac.kr"};

        ArrayAdapter<String> email_arrayadapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,email_arraylist);
        //Spinner email_spinner = (Spinner) findViewById(R.id.email_spinner);
        email_spinner.setAdapter(email_arrayadapter);
        email_spinner.setSelection(0);
    }

    /*public MemberDTO getSignUpData(){
        MemberDTO mdto = new MemberDTO();
        Integer id = signup_id.getText().toString();
    }*/
}
