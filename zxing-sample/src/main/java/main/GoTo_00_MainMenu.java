package main;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.List;

import R.R;


public class GoTo_00_MainMenu extends AppCompatActivity {

    private static String action = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_00_main_menu);

        System.out.println("-----------------> DATABASE STUFF STARTS HERE");
        DataBaseHelper a = new DataBaseHelper(this);
        try {
            a.createDataBase();
            a.openDataBase();
            a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }








        buttonListeners();
    }

    public static String getAction() {
        return action;
    }

    public void buttonListeners(){

        Button plus = (Button)findViewById(R.id.button_ADD);
        plus.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent open = new Intent(v.getContext(), GoTo_10_AddOrRemove.class);
                        action="Add";
                        startActivity(open); }});

        Button minus = (Button)findViewById(R.id.button_REMOVE);
        minus.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent open = new Intent(v.getContext(), GoTo_10_AddOrRemove.class);
                        action="Remove";
                        startActivity(open);}});

        Button list = (Button)findViewById(R.id.button_LIST);
        list.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //Intent open = new Intent(v.getContext(), GoTo_10_AddOrRemove.class);
                        action="List";
                        //startActivity(open);
                    }});

        Button edit = (Button)findViewById(R.id.button_EDIT);
        edit.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent open = new Intent(v.getContext(), GoTo_10_AddOrRemove.class);
                        action="Edit";
                        startActivity(open);}});

        Button invent = (Button)findViewById(R.id.button_INVENT);
        invent.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //Intent open = new Intent(v.getContext(), GoTo_10_AddOrRemove.class);
                        action="Invent";
                        //startActivity(open);
                    }});

        Button settings = (Button)findViewById(R.id.button_SETTINGS);
        settings.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //Intent open = new Intent(v.getContext(), GoTo_10_AddOrRemove.class);
                        action="Settings";
                        //startActivity(open);
                    }});
    }
}
