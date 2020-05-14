package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button btn_signup_ok = (Button) findViewById(R.id.btn_signup_ok);

        btn_signup_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EmailCheckActivity.class);
                startActivity(intent);
                finish();
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
