package com.example.a1_moyeo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class db_testActivity extends AppCompatActivity {
    EditText edt_put1,edt_put2,edt_put3;
    Button btn_insert,btn_select;
    TextView txt_print;
    String server_check;
    //ConnectTask asyncTask = new ConnectTask();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_test);


        edt_put1 = (EditText) findViewById(R.id.edt_put1);
        edt_put2 = (EditText) findViewById(R.id.edt_put2);
        edt_put3 = (EditText) findViewById(R.id.edt_put3);
        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_select = (Button) findViewById(R.id.btn_select);
        txt_print = (TextView) findViewById(R.id.txt_print);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_data1,get_data2,get_data3,insert_check;
                get_data1 = edt_put1.getText().toString();
                get_data2 = edt_put2.getText().toString();
                get_data3 = edt_put3.getText().toString();
                server_check = "INSERT";
                //new ConnectTask().execute(server_check,get_data1,get_data2);
              //  asyncTask.execute(server_check,get_data1,get_data2);
               // asyncTask.isCancelled();
                try{
                    insert_check = new ConnectTask().execute(server_check,get_data1,get_data2,get_data3).get();
                    txt_print.setText(insert_check);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server_check = "SELECT";
                String select_check;
                //  asyncTask.execute(server_check,get_data1,get_data2);
                // asyncTask.isCancelled();
                try{
                    select_check = new ConnectTask().execute(server_check).get();
                    txt_print.setText(select_check);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });


    }
}
