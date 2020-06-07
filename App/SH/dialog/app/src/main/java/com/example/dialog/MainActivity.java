package com.example.dialog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView textView_Date,TextView_Date_end;
    private DatePickerDialog.OnDateSetListener callbackMethod;
    private Button button,button1;
    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView_Date_end = (TextView)findViewById(R.id.textView_date_end);
        adapter=new CustomAdapter();
        listView=(ListView)findViewById(R.id.listview1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        adapter.add(new Data("이세희"));
        adapter.add(new Data("고정륜"));
        adapter.add(new Data("이세희"));
        adapter.add(new Data("고정륜"));

        Button button1 = (Button)findViewById(R.id.endbutton);


        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCalendar = Calendar.getInstance();
                int mYear = mCalendar.get(Calendar.YEAR);
                int mMonth = mCalendar.get(Calendar.MONTH);
                int mDay = mCalendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,callbackMethod,mYear,mMonth,mDay);
                callbackMethod = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;
                        TextView_Date_end.setText(year+"년 "+monthOfYear+"월 "+dayOfMonth+"일 ");
                        listView.setVisibility(View.VISIBLE);
                    }
                };
                dialog.show();
            }

        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        switch (parent.getId()){
            case R.id.listview1:
                Toast.makeText(getApplicationContext(),parent.getAdapter().getItem(position).toString(),Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
