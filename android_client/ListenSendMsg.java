package com.example.student.android_client;

import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by student on 17.16.8.
 */

public class ListenSendMsg extends AsyncTask<Object, String, Object> {

    @Override
    protected Object doInBackground(Object...  obj) {
        Object res=null;
        try  {
            AmberClient client = null;
            try {
                client = new AmberClient("192.168.8.122");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Packet.objectpack pack=new Packet.objectpack();
            pack.Mobject=obj[0];
            client.sendObject(pack);
            while(true){
                if(client.clientListener.getNewMsg()){
                    res=client.clientListener.obj;
                    break;
                }
            }
            publishProgress("closing client");
            client.closeConnection();
            publishProgress("closed client");
        } catch (Exception e) {
            res=e.toString();
            e.printStackTrace();
        }
        return res;
     }

    @Override
    protected void onProgressUpdate(String... messages) {
        MainActivity.WriteOnScreen(messages[0]);
    }


}
