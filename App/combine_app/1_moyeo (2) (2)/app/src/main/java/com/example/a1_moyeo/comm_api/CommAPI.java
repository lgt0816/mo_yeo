package com.example.a1_moyeo.comm_api;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class CommAPI extends AsyncTask {

    public String result;
    private Socket mSocket;

    public CommAPI() {    }

    /* 통신 하는 중 사용되는 소스*/
    @Override
    protected Object doInBackground(Object[] objects) {

        try {
            mSocket = new Socket("1.11.236.38", 25000);//192.168.29.87//172.30.1.25//
            String ok = objects[0].toString();
            String sendData = "";
            if (ok.contains("INSERT")) {
                for (int i = 0; i < objects.length; i++) {
                    sendData = sendData + objects[i] + "ㅩ";
                }
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(), "EUC-KR")), true);
                out.println(sendData);
                out.flush();
                while (mSocket.getInputStream().read() == 0) {}
                BufferedReader br = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "EUC-KR"));
                br.readLine();
                out.close();
                result = "OK";
            }//ok=="SELECT01"
            if (ok.contains("SELECT")) {
                for (int i = 0; i < objects.length; i++) {
                    sendData = sendData + objects[i] + "ㅩ";
                }
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(), "EUC-KR")), true);
                out.println(sendData);
                out.flush();
                while (mSocket.getInputStream().read() == 0) {}
                BufferedReader br = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "EUC-KR"));
                StringBuffer stb = new StringBuffer();
                br.readLine();
                stb.append(br.readLine());
                out.close();
                result = stb.toString();
            }
            if (ok.contains("UPDATE")) {
                for (int i = 0; i < objects.length; i++) {
                    sendData = sendData + objects[i] + "ㅩ";
                }
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(), "EUC-KR")), true);
                out.println(sendData);
                out.flush();
                while (mSocket.getInputStream().read() == 0) {}
                BufferedReader br = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "EUC-KR"));
                br.readLine();
                out.close();
                result = "OK";
            }//ok=="SELECT01"

        } catch (IOException e) {
            Log.e("Comm Error", e.getMessage());
        } finally {
            try {
                mSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;

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
        super.onPostExecute(o);
//        doSocketClose();
       // delegate.processFinish(o.toString());
//        if(o!=null && delegate != null){
//            delegate.processFinish(o.toString());
//        }else {
//            Log.i("MyAccess","You have not assigned IApiAccessResponse delegate");
//        }

    }

    private void doSocketClose() {
        try {
            mSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
