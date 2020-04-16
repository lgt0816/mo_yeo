package com.example.moyeo;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Study_write extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EditText editText7 = (EditText)findViewById(R.id.SWedit7);
        EditText editText8 = (EditText)findViewById(R.id.SWedit8);
        editText7.setHorizontallyScrolling(false);
        editText8.setHorizontallyScrolling(false);
    }
}
