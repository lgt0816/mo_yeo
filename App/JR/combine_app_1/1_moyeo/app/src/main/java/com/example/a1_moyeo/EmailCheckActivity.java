package com.example.a1_moyeo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EmailCheckActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emailcheck);

        Button btn_signup_final = (Button) findViewById(R.id.btn_signup_final);
        Button btn_email_check = (Button) findViewById(R.id.email_check);

        btn_signup_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);*/
                finish();
            }
        });

        btn_email_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"인증 완료",Toast.LENGTH_LONG).show();
            }
        });
    }
}
