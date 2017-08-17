package com.example.student.android_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {
    public static TextView mytxt=null;
    public static EditText myEditbox;
    public static BigPackage worker;
    public static String tmp;

    public static void WriteOnScreen(String text){
        mytxt.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String ip="192.168.8.122";
        mytxt= (TextView) findViewById(R.id.thisid);
        WriteOnScreen("Hello");
        myEditbox = (EditText) findViewById(R.id.inputbox);
        worker=new BigPackage();
        new ListenSendMsg().execute(ip);
        myEditbox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean handled=false;
                String text;
                if(i== EditorInfo.IME_ACTION_DONE){
                    text=textView.getText().toString();
                    SendNRecive(text);
                }
                return handled;
            }
        });
    }

    static public void SendNRecive(Object o){
        worker.sendablePackage=o;
        worker.flag=true;
    }

    static public void Recived(){
        WriteOnScreen((String) worker.getReceivablePackage());
    }

    static public void NotConnectedError(){
        WriteOnScreen("Not Connected");
    }

    static public void OtherError(){
        WriteOnScreen("Something went wrong");
     }

     static public void message(){
         WriteOnScreen(tmp);
     }
}
