package com.example.student.android_client;

import android.os.AsyncTask;

import java.io.IOException;

import static com.example.student.android_client.MainActivity.worker;

/**
 * Created by student on 17.16.8.
 */

public class ListenSendMsg extends AsyncTask<BigPackage, String, Void> {

    @Override
    protected Void doInBackground(BigPackage...  params) {
        try  {
            AmberClient client = null;
            try {
                client = new AmberClient("192.168.8.122");
                publishProgress("Connected");
            } catch (IOException e) {
                publishProgress("not Connected");
                e.printStackTrace();
            }
            Packet.objectpack pack=new Packet.objectpack();
            Boolean myflag=true;
            while(worker.proceed){
                if(worker.flag){
                    publishProgress("looped in");
                    pack.Mobject=worker.sendablePackage;
                    client.sendObject(pack);
                    myflag=true;
                    while(myflag){
                        if(client.clientListener.getNewMsg()){
                            worker.recivablePackage=client.clientListener.obj;
                            myflag=false;
                        }
                    }
                    worker.flag=false;
                }

            }
            client.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }

    @Override
    protected void onProgressUpdate(String... messages) {
        MainActivity.WriteOnScreen(messages[0]);
    }


}
