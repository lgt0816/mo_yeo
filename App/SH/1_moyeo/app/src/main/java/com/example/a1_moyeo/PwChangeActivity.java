package com.example.a1_moyeo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PwChangeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pwchange);
        Button btn_pwcheck = (Button) findViewById(R.id.btn_pwcheck);

        btn_pwcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);*/
               finish();
            }
        });
    }
}
