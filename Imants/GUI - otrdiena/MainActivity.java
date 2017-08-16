package com.example.student.imants_skats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

private static boolean action=true;

    public static boolean getAction(){
        if(action==true) return true;
        else return false;

    }


    public void buttonListeners(){

        ImageButton plus = (ImageButton)findViewById(R.id.imageButton_plus);
        plus.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent open = new Intent(v.getContext(), Ready_for_scan_storage.class);
                        action=true;
                        startActivity(open); }});

        ImageButton minus = (ImageButton)findViewById(R.id.imageButton_minus);
        minus.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent open = new Intent(v.getContext(), Ready_for_scan_storage.class);
                        action=false;
                        startActivity(open);}});
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonListeners();
    }
}
