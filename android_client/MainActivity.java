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
        myEditbox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean handled=false;
                String text;
                if(i== EditorInfo.IME_ACTION_DONE){
                    text=textView.getText().toString();
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
        ListenSendMsg tmp=new ListenSendMsg();
        tmp.execute(o);
        Object res=null;
        WriteOnScreen("got in SendNRecive");
        try {
            WriteOnScreen("waiting for response");
            res=tmp.get(5, TimeUnit.SECONDS);
            WriteOnScreen("good");
            if(res==null) WriteOnScreen("not so good");
        } catch (InterruptedException e) {
            WriteOnScreen("bad 1");
            e.printStackTrace();
        } catch (ExecutionException e) {
            WriteOnScreen("bad 2");
            e.printStackTrace();
        } catch (TimeoutException e) {
            WriteOnScreen("got time out");
            e.printStackTrace();
        }
        return res;
    }

}
