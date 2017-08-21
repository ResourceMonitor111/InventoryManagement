package com.example.student.android_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static TextView mytxt=null;
    public static EditText myEditbox;
    public static Worker worker;
    public static String tmp;

    public static void WriteOnScreen(String text){
        mytxt.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);


        //  important!!!
        String ip="192.168.8.107";
        worker=new Worker();
        new ListenSendMsg().execute(ip);
        //  important!!!


        //use next line to disconnect from server
        //worker.proceed=false;


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
                    getProduct(text);
                }
                return handled;
            }
        });
    }


    static public void getProduct(String barCode){
        Packet.RequestGetProduct sendable=new Packet.RequestGetProduct();
        sendable.barCode=barCode;
        worker.sendablePackage=sendable;
        worker.flag=true;
    }

    static public void insertProduct(Product product){
        Packet.ResponseGetProduct sendable=new Packet.ResponseGetProduct();
        sendable.product=product;
        worker.sendablePackage=sendable;
        worker.flag=true;
    }

    static public void AddAmount(String barCode, int amount){
        Packet.RequestAddAmount sendable=new Packet.RequestAddAmount();
        sendable.barCode=barCode;
        sendable.amount=amount;
        worker.sendablePackage=sendable;
        worker.flag=true;
    }

    static public void SubtractAmount(String barCode, int amount){
        Packet.RequestSubtractAmount sendable=new Packet.RequestSubtractAmount();
        sendable.barCode=barCode;
        sendable.amount=amount;
        worker.sendablePackage=sendable;
        worker.flag=true;
    }


    static public void Recived(){
        if(worker.getReceivablePackage() instanceof Packet.ResponseGetProduct){
            Product product=((Packet.ResponseGetProduct) worker.getReceivablePackage()).product;    //requested product
            if(product!=null) WriteOnScreen(((Packet.ResponseGetProduct) worker.getReceivablePackage()).product.getProductName());
            else WriteOnScreen("got null :(");
        }else if(worker.getReceivablePackage() instanceof Packet.ResponseInsertProduct) {
            Boolean res=((Packet.ResponseInsertProduct) worker.getReceivablePackage()).bool;         //result after inserting new product
        }else if(worker.getReceivablePackage() instanceof Packet.ResponseAddAmount) {
            Boolean res= ((Packet.ResponseAddAmount) worker.getReceivablePackage()).bool;          //result after adding amount to product
        } else if (worker.getReceivablePackage() instanceof Packet.ResponseSubtractAmount) {
            Boolean res=((Packet.ResponseSubtractAmount) worker.getReceivablePackage()).bool;           //result after subtracting amount from product
        } else {
            WriteOnScreen("not a ResponseGetProduct");
        }
    }

    static public void NotConnectedError(){
        WriteOnScreen("Not Connected");
    }           //if we do not have connection

    static public void OtherError(){
        WriteOnScreen("Something went wrong");
     }      //if other error happend

     static public void message(){
         WriteOnScreen(tmp);
     }// testing messages
}
