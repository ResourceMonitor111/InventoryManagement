package com.example.student.imants_skats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class Ready_for_scan_storage extends AppCompatActivity {
    private static TextView text_view;

    public void setHeading(){
        text_view =(TextView)findViewById(R.id.textView);
        if(MainActivity.getAction()==true) text_view.setText("Receive");
        else text_view.setText("Sell");

    }


    public void buttonListeners(){

        Button scan = (Button) findViewById(R.id.button_scan);
        scan.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent open = new Intent(v.getContext(), MainActivity.class);
                        startActivity(open); }});


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_for_scan_storage);
        setHeading();
        buttonListeners();
    }
}
