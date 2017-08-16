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

    public static void WriteOnScreen(String text){
        mytxt.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytxt= (TextView) findViewById(R.id.thisid);
        WriteOnScreen("Hello");
        myEditbox = (EditText) findViewById(R.id.inputbox);
        worker=new BigPackage();
        new ListenSendMsg().execute(worker);
        myEditbox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean handled=false;
                String text;
                WriteOnScreen("try to request");
                if(i== EditorInfo.IME_ACTION_DONE){
                    text=textView.getText().toString();
                    WriteOnScreen("about to request");
                    text=(String) SendNRecive(text);
                    if(text==null||text.equals("")){ }
                    else{ WriteOnScreen(text);}
//                    WriteOnScreen(text);
                }
                return handled;
            }
        });
    }

    static public Object SendNRecive(Object o){
        Object res=null;
        worker.sendablePackage=o;
        WriteOnScreen("sendNrecive");
        worker.flag=true;
        WriteOnScreen("about to wait");
        while(worker.flag){
            WriteOnScreen("waiting answer");
        }
        res=worker.recivablePackage;
        return res;
    }

}
