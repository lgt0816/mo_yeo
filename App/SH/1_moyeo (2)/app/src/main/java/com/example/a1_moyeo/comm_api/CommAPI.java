package com.example.a1_moyeo.comm_api;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.a1_moyeo.MyReviseActivity;
import com.example.a1_moyeo.SignUpActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CommAPI extends AsyncTask{

    public String result=null;
    private Socket mSocket;
    public CommAPI() {

    }



    /* 통신 하는 중 사용되는 소스*/
    @Override
    protected Object doInBackground(Object[] objects) {

       // String signup_name = objects[4].toString();
        //String signup_number = objects[5].toString();
       // String signup_email = objects[6].toString();

        try {

            String str;
            String rcvMsg="";
            String sndMsg="";
            mSocket = new Socket("172.30.1.1", 25000);

            //데이터 저장
           // PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream())), true);

           // String sql_insert="INSERT INTO testserver(id,sex,name) VALUES("+signup_id+",'"+signup_pw+"','"+signup_rpw+"')";
            //out.println(sql_insert);
            //out.flush();
           String ok = objects[0].toString();
           //  String signup_id = objects[1].toString();
           // String signup_pw = objects[2].toString();
          //  String signup_rpw =  objects[3].toString();

          /*  if (ok=="INSERT"){
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(),"EUC-KR")), true);
                String sql_insert=ok+","+signup_id+","+signup_pw+","+signup_rpw;
                out.print(sql_insert);
                out.flush();
            }*/

            if(ok=="SELECT"){
                BufferedReader br = new BufferedReader(new InputStreamReader(mSocket.getInputStream(),"EUC-KR"));
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                String getok = st.nextToken();
                //String[] array = s.split(",");
                //String getok = array[0];
               /* StringTokenizer st = new StringTokenizer(s);
               String getok = st.nextToken();
                String getok = st.nextToken();
                String getid = st.nextToken();
                String getpw = st.nextToken();
                String getrpw = st.nextToken();
                String getname = st.nextToken();
                String getnumber = st.nextToken();
                String getemail = st.nextToken();
                String[] array = s.split(" ");
                String sql_select = getok+getid+getpw+getrpw;*/
                /*BufferedReader input = new BufferedReader(new InputStreamReader(mSocket.getInputStream(),"EUC-KR"));
                StringBuffer buffer = new StringBuffer();
                while ((str=input.readLine())!=null){
                 buffer.append(str);
                }
                rcvMsg = buffer.toString();
                while ((str=input.readLine())!=null){
                    rcvMsg += str;
                }*/
                result=getok;
            }

            //데이터 읽어오기
           // BufferedReader br = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

           /* String string;
            while ((string = br.readLine())!=null){
                sb.append(string+"\n");
            }
            String sql_select = "SELECT * FROM new_table";*/

           // String s = br.readLine();

           /* StringTokenizer st = new StringTokenizer(s);
            String getid = st.nextToken();
            String getpw = st.nextToken();
            String getrpw = st.nextToken();
            String getname = st.nextToken();
            String getnumber = st.nextToken();
            String getemail = st.nextToken();
            String[] array = s.split(" ");*/

          //  Log.e("Received Data", br.readLine());


        } catch (IOException e) {
            Log.e("Comm Error", e.getMessage());
        } finally {
            doSocketClose();
        }
        return result.toString();
        //return sb.toString().trim();
    }

    private void doSocketClose() {
        try {
            mSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*doInBackground에서 publishProgress() 호출될 때마다 들어가는 소스 ( 다운로드 퍼센트 개발에 용이 ) */
    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        //System.out.println(sb.toString().trim());
    }

    /* doInBackground가 종료되면 호출되는 소스 */
    @Override
    protected void onPostExecute(Object o) {

        //super.onPostExecute(o);
        doSocketClose();
    }
}


