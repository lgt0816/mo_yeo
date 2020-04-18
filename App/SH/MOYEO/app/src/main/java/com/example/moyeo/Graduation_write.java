package com.example.moyeo;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Graduation_write extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graduation_write);

        EditText editText5 = (EditText)findViewById(R.id.GWedit5);
        EditText editText6 = (EditText)findViewById(R.id.GWedit6);
        editText5.setHorizontallyScrolling(false);
        editText6.setHorizontallyScrolling(false);

    }
}
