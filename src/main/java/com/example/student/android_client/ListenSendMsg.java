package com.example.student.android_client;

import android.os.AsyncTask;

import java.io.IOException;

import static com.example.student.android_client.MainActivity.worker;

/**
 * Created by student on 17.16.8.
 */

public class ListenSendMsg extends AsyncTask<String, Integer, Void> {

    @Override
    protected Void doInBackground(String...  strings) {
        AmberClient client = null;
        Boolean connected=true;
        try  {
           try {
                client = new AmberClient(strings[0]);
           } catch (IOException e){
               publishProgress(1);
               e.printStackTrace();
               connected=false;
               cancel(true);
           }
           while(worker.proceed){
               if(isCancelled()) break;
               if(worker.flag){
                   if(worker.sendablePackage instanceof Packet.RequestGetProduct){
                       client.sendGetProduct((Packet.RequestGetProduct) worker.sendablePackage);
                   }else if(worker.sendablePackage instanceof Packet.RequestAddAmount){
                       client.sendAddAmount((Packet.RequestAddAmount) worker.sendablePackage);
                   }else if(worker.sendablePackage instanceof Packet.ResponseInsertProduct){
                       client.sendInsertProduct((Packet.ResponseInsertProduct) worker.sendablePackage);
                   }
                   while(true){
                       if(client.clientListener.getNewMsg()){
                           worker.setReceivablePackage(client.clientListener.getObj());
                           break;
                       }
                   }
                   worker.flag=false;
                   publishProgress(0);
               }
           }
        } catch (Exception e) {
            publishProgress(2);
            e.printStackTrace();
        }finally {
            if(connected) client.closeConnection();
        }
        return null;
     }

    @Override
    protected void onProgressUpdate(Integer... ints) {
        switch(ints[0]){
            case(0):MainActivity.Recived();             //no errors
                break;
            case(1):MainActivity.NotConnectedError();   //did not connect to server
                break;
            case(2):MainActivity.OtherError();          //other error
                break;
            case(3):MainActivity.message();             //testing messages
                break;
        }

    }


}
