package com.example.moyeo;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Study_ing_acti extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_ing_acti);

        EditText editText2 = (EditText)findViewById(R.id.acti_c_edit);
        editText2.setHorizontallyScrolling(false);
    }
}
