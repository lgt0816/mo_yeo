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

//public void getDataInBackground(String params){
//    new CommAPI(params).execute();
//        }


public class CommAPI extends AsyncTask {
//    public AsyncResponse delegate = null;
   // String params;


    public String result;
    private Socket mSocket;

    public CommAPI() {  //public CommAPI(String params) //public CommAPI(AsyncResponse asyncResponse)
       // this.params = params;
      //  delegate = asyncResponse;
    }

    /* 통신 하는 중 사용되는 소스*/
    @Override
    protected Object doInBackground(Object[] objects) {

        try {
            mSocket = new Socket("192.168.0.14", 25000);//192.168.29.87//172.30.1.25

            String ok = objects[0].toString();
            String sendData = "";
            if (ok.contains("INSERT")) {
                for (int i = 0; i < objects.length; i++) {
                    sendData = sendData + objects[i] + "ㅩ";
                }
                //sendData += "\r";
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(), "EUC-KR")), true);
                //out.print(sendData);
                out.println(sendData);
                out.flush();
                while (mSocket.getInputStream().read() == 0) {
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "EUC-KR"));
                br.readLine();
                result = "OK";
            }//ok=="SELECT01"
            if (ok.contains("SELECT")) {
                for (int i = 0; i < objects.length; i++) {
                    sendData = sendData + objects[i] + "ㅩ";
                }
                //sendData += "\r";
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(), "EUC-KR")), true);
                out.println(sendData);
                out.flush();
                while (mSocket.getInputStream().read() == 0) {}
                BufferedReader br = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "EUC-KR"));
                StringBuffer stb = new StringBuffer();
                br.readLine();
                stb.append(br.readLine()).toString();
                result = stb.toString();
            }

        } catch (IOException e) {
            Log.e("Comm Error", e.getMessage());
        }
//        finally {
//            doSocketClose();
//        }
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
        doSocketClose();
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
