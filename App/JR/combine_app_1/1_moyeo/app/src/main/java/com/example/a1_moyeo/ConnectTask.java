package com.example.a1_moyeo;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import android.os.Handler;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ConnectTask extends AsyncTask<String,Void,String> {
    public String result="";
    private Socket socket;
    //ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //pDialog = new ProgressDialog(mContext);
    }

    @Override
    protected String doInBackground(String ... params) {
        String ip = "172.30.1.1"; //"172.16.104.219"//"218.155.247.192" //"192.168.29.87"
        int port = 25000;
        String sndMsg = "";
        String rcvMsg = "";
        int len = params.length;
        //Handler mHandler = new Handler();
        //서버에 전달되어지는 데이터 형태
        for(int i=0;i<len;i++){
            sndMsg =sndMsg+params[i]+",";
        }
        Log.d("sndMsg ",sndMsg);
        //sndMsg =sndMsg+params[len];
       // Log.d("len-sndMsg ",sndMsg);
        try{
            String str;
            InetAddress serverAddr = InetAddress.getByName(ip);
            socket = new Socket(serverAddr,port);
            //socket = new Socket("172.30.1.1",25000);
            //서버에게 데이터 보내기
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"EUC-KR")),true);
            out.print(sndMsg);
            out.flush();
            result="OK";

            if(params[0]=="SELECT"){
            //    Log.d("select params ","params[0]=select");
                //서버에게 데이터 받기
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(),"EUC-KR"));
                Log.d("check :",input.readLine());
//                if(input.readLine()==null){
//                    Log.e("input is null","아무것도 안들어감");
//                }
                StringBuffer buffer = new StringBuffer();
                while ((str=input.readLine())!= null){
                    buffer.append(str);
                }
                rcvMsg = buffer.toString();

//                //result="hi";
                result = rcvMsg;
               // String read = input.readLine();
                //  mHandler.post(new msgUpdate(read));
               // Log.d("~~~~~~~~", read);
            }
            //socket.close();
        }catch (Exception e){
            Log.e("ConnectTask Error",e.getMessage());
            e.printStackTrace();
        }finally {
           doSocketClose();
        }
        return result;
    }

    private void doSocketClose() {
        try{
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    /*class msgUpdate implements Runnable{
        private String msg;
        public msgUpdate(String str){
            this.msg = str;
        }*/

}
