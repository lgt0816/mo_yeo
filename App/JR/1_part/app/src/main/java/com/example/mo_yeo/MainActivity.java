package com.example.mo_yeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ing_button = findViewById(R.id.ing);
        ing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),IngListActivity.class);
                startActivity(intent);
            }
        });
        Button rc_button = findViewById(R.id.rc);
        rc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RcListActivity.class);
                startActivity(intent);
            }
        });
        Button rq_button = findViewById(R.id.rq);
        rq_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RqListActivity.class);
                startActivity(intent);
            }
        });
        Button f_button = findViewById(R.id.fin);
        f_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FinishListActivity.class);
                startActivity(intent);
            }
        });
        Button pp_button = findViewById(R.id.pp);
        pp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PPListActivity.class);
                startActivity(intent);
            }
        });
        Button gp_button = findViewById(R.id.gp);
        gp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GProjectListActivity.class);
                startActivity(intent);
            }
        });

        Button ggp_button = findViewById(R.id.ggp);
        ggp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GGProjectCheckActivity.class);
                startActivity(intent);
            }
        });

    }
}
