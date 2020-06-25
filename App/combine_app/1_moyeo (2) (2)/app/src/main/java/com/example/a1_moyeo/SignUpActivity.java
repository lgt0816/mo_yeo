package com.example.a1_moyeo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a1_moyeo.comm_api.CommAPI;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SignUpActivity extends AppCompatActivity {
    EditText signup_id,signup_pw,signup_rpw,signup_name,signup_number,signup_email;
    RadioGroup signup_bg;
    Spinner email_spinner,uni_spinner,major_spinner,grade_spinner,state_spinner;
    CommAPI commAPI= new CommAPI();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button btn_signup_ok = (Button) findViewById(R.id.btn_signup_ok);

        signup_id = (EditText)findViewById(R.id.signup_id);
        signup_pw = (EditText)findViewById(R.id.signup_pw);
        signup_rpw = (EditText)findViewById(R.id.signup_rpw);
        signup_name = (EditText)findViewById(R.id.signup_name);
        signup_number = (EditText)findViewById(R.id.signup_number);
        signup_email = (EditText)findViewById(R.id.signup_email);

        signup_bg = (RadioGroup) findViewById(R.id.signup_bg);
        email_spinner = (Spinner) findViewById(R.id.email_spinner);
        uni_spinner = (Spinner) findViewById(R.id.uni_spinner);
        major_spinner = (Spinner) findViewById(R.id.major_spinner);
        grade_spinner = (Spinner) findViewById(R.id.grade_spinner);
        state_spinner = (Spinner) findViewById(R.id.state_spinner);

        String[] email_arraylist ={"office.sungkyul.ac.kr","sungkyul.ac.kr"};
        ArrayAdapter<String> email_arrayadapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,email_arraylist);
        email_spinner.setAdapter(email_arrayadapter);
        email_spinner.setSelection(0);
        email_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] uni_arraylist = {"신학대학","인문대학","사회과학대학","글로벌경영기술대학","사범대학","IT공과대학","예술대학","융합대학"};
        final ArrayAdapter<String> uni_arrayadapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,uni_arraylist);
        uni_spinner.setAdapter(uni_arrayadapter);
        uni_spinner.setSelection(0);
        uni_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.BLACK);

                if(uni_arrayadapter.getItem(i).equals("신학대학")){
                    String[] maj1_al={"신학부"};
                    ArrayAdapter<String> maj1_aa = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,maj1_al);
                    major_spinner.setAdapter(maj1_aa);
                    major_spinner.setSelection(0);
                }else if(uni_arrayadapter.getItem(i).equals("인문대학")){
                    String[] maj2_al={"국어국문학과", "영어영문학과", "중어중문학과", "일어일문학과"};
                    ArrayAdapter<String> maj2_aa = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,maj2_al);
                    major_spinner.setAdapter(maj2_aa);
                    major_spinner.setSelection(0);
                }else if(uni_arrayadapter.getItem(i).equals("사회과학대학")){
                    String[] maj3_al={"행정학과", "사회복지학과", "국제개발협력학과"};
                    ArrayAdapter<String> maj3_aa = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,maj3_al);
                    major_spinner.setAdapter(maj3_aa);
                    major_spinner.setSelection(0);
                }else if(uni_arrayadapter.getItem(i).equals("글로벌경영기술대학")){
                    String[] maj4_al={"관광개발학과", "경영학과", "동아시아물류학부", "산업경영공학과"};
                    ArrayAdapter<String> maj4_aa = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,maj4_al);
                    major_spinner.setAdapter(maj4_aa);
                    major_spinner.setSelection(0);
                }else if(uni_arrayadapter.getItem(i).equals("사범대학")){
                    String[] maj5_al={"유아교육과", "체육교육과", "교직부"};
                    ArrayAdapter<String> maj5_aa = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,maj5_al);
                    major_spinner.setAdapter(maj5_aa);
                    major_spinner.setSelection(0);
                }else if(uni_arrayadapter.getItem(i).equals("IT공과대학")){
                    String[] maj6_al= {"컴퓨터공학과", "정보통신학과", "미디어소프트웨어학과", "도시디자인정보공학과"};
                    ArrayAdapter<String> maj6_aa = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,maj6_al);
                    major_spinner.setAdapter(maj6_aa);
                    major_spinner.setSelection(0);
                }else if(uni_arrayadapter.getItem(i).equals("예술대학")){
                    String[] maj7_al= {"음악학부", "뷰티디자인학과", "연극영화학부"};
                    ArrayAdapter<String> maj7_aa = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,maj7_al);
                    major_spinner.setAdapter(maj7_aa);
                    major_spinner.setSelection(0);
                }else if(uni_arrayadapter.getItem(i).equals("융합대학")){
                    String[] maj8_al= {"융합학부"};
                    ArrayAdapter<String> maj8_aa = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,maj8_al);
                    major_spinner.setAdapter(maj8_aa);
                    major_spinner.setSelection(0);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }});

        major_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] grade_al={"1","2","3","4"};
        ArrayAdapter<String> grade_aa = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,grade_al);
        grade_spinner.setAdapter(grade_aa);
        grade_spinner.setSelection(0);
        grade_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] state_al={"재학","휴학","졸업"};
        ArrayAdapter<String> state_aa = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,state_al);
        state_spinner.setAdapter(state_aa);
        state_spinner.setSelection(0);
        state_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_signup_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ok = "INSERT01";
                String id = signup_id.getText().toString();
                String pw = signup_pw.getText().toString();
                String rpw = signup_rpw.getText().toString();
                String name = signup_name.getText().toString();
                String number = signup_number.getText().toString();
                String email = signup_email.getText().toString()+"@"+email_spinner.getSelectedItem().toString();
                String uni = uni_spinner.getSelectedItem().toString();
                String major = major_spinner.getSelectedItem().toString();
                String grade = grade_spinner.getSelectedItem().toString();
                String state = state_spinner.getSelectedItem().toString();

                RadioButton rdb = (RadioButton) findViewById(signup_bg.getCheckedRadioButtonId());
                String sex = rdb.getText().toString();

                Object rcvDataFromServer = null;
                try {
               /// commAPI.execute(ok, id, pw, name, sex,number,email,uni,major,grade,state);//comma.execute(ok, id, pw, rpw).get();
                ///    rcvDataFromServer = commAPI.result;
                    rcvDataFromServer =new CommAPI().execute(ok, id, pw, name, sex,number,email,uni,major,grade,state).get();
                }catch (Exception e) {
                    e.printStackTrace(); }
                if(rcvDataFromServer.toString()=="OK"){
                    Toast.makeText(getApplicationContext(),"회원가입 완료",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"회원가입 실패",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}