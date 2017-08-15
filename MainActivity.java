package com.example.student.android_validation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //DEFINE USABLE WIDGETS
    private static EditText edit_text_count; //EditText widget that WILL contain count of items for increase or decrease
    private static EditText edit_text_name; // EditText widget that WILL contain name of the item
    private static EditText edit_text_description; // EditText widget that WILL contain the description of the item
    private static EditText edit_text_bar_code;// EditText widget that WILL contain the description of the item

    private static Button button; //Button that initiates field validation

    private static TextView text_view; //Test placeholder

    private int countOfItem;//OUR ITEM COUNT//we try to read how much to add or remove
    private long barCode;//OUR BARCODE//FOR NEW RECORD
    private String name;//OUR ITEM NAME
    private String description;//OUR ITEM DESCRIPTION


public void showErrorMessage(View view, String message){//MESSAGE CONSTRUCTOR START
//View view might be unneeded,String message contains output text for message
    AlertDialog.Builder myAlert =new AlertDialog.Builder(MainActivity.this);//CREATE NEW MESSAGE//MESSAGE NAME "myAlert"
    myAlert.setMessage(message) //ADDS WHAT TE]XT MESSAGE DISPLAYS//DISPLAYS RECEIVED PARAM "message"
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() { //ADD BUTTON TO MESSAGE
                @Override//OVERRIDE WHAT HAPENS WHEN CLICKED ON MESSAGE BUTTON
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();} //ASSIGN WHAT ADDED BUTTON DOES. DISMISS - CLOSES MESSAGE
            }).create(); // CREATES INSTANCE OF DEFINED MESSAGE
    myAlert.show(); //SHOWS CREATED MESSAGE ON SCREEN
} //MESSAGE CONSTRUCTOR END



    public void validatorForAll(){ //VALIDATOR ALL METHOD START
        edit_text_count = (EditText)findViewById(R.id.editText); //ASSIGN  WIDGET TO VARIABLE. editText is name of the widget in design view or xml
        edit_text_name = (EditText)findViewById(R.id.editText2); //ASSIGN WIDGET TO VARIABLE. editText2 is name of the widget in design view or xml
        edit_text_description = (EditText)findViewById(R.id.editText3);//ASSIGN  WIDGET TO VARIABLE. editText3 is name of the widget in design view or xml
        edit_text_bar_code = (EditText)findViewById(R.id.editText4);////ASSIGN  WIDGET TO VARIABLE. editText4 is name of the widget in design view or xml

        button = (Button)findViewById(R.id.button);//ASSIGN VALUE FROM WIDGET TO VARIABLE. button is name of the widget in design view or xml

        text_view =(TextView)findViewById(R.id.textView);//ASSIGN WIDGET TO VARIABLE. textView is name of the widget in design view or xml
        //text_view is test placeholder

       button.setOnClickListener(new View.OnClickListener(){ //ADD LISTENER TO BUTTON CLICK, THAT DOES SOMETHING WITH VIEW
           @Override //OVERRIDE WHAT HAPPENS
           public void onClick(View v) { //OVERRIDE WHAT HAPPENS ON CLICK
               if (edit_text_name.getText().toString().trim().length() < 3) {  //CHECK IF NAME WITHOUT SPACES IS ATLEAST 3 CHARACTERS
                   showErrorMessage(v, "[" + edit_text_name.getText() + "] is not a valid name!"); //IF LESS THAN 3, MESSAGE POPUP
               } else {
                   name = edit_text_name.getText().toString(); // OTHERVISE ASSIGN edit_text_name TEXT TO "name" variable
               }


               if (false) {//CURRENTLY UNKNOWN REQUIREMENTS FOR DESCRIPTION FIELD. PLACEHOLDER FOR FUTURE
                   showErrorMessage(v, "[" + edit_text_description.getText() + "] is not a valid description!");//IF X, MESSAGE POPUP
               } else {
                   description = edit_text_description.getText().toString();// OTHERVISE ASSIGN edit_text_description TEXT TO "description" variable
               }


               try {
                   if ((edit_text_bar_code.getText().toString().length()) == 13) { //IF BARCODE IS 13 CHARACTERS LONG
                       barCode = Long.parseLong(edit_text_bar_code.getText().toString());//TRY TO ASSIGN IT AS LONG TYPE TO "barCode" variable, IF FAILS - CATCH
                   } else {
                       if (edit_text_bar_code.getText().toString().length() > 13) {//ELSE IF LONGER THAN 13
                           showErrorMessage(v, "[" + edit_text_bar_code.getText() + "] is not a valid BarCode! Too long!");//MESSAGE POPUP
                       }
                       if (edit_text_bar_code.getText().toString().length() < 13)//ELSE IF SHORTER THAN 13
                           showErrorMessage(v, "[" + edit_text_bar_code.getText() + "] is not a valid BarCode! Too short!");//MESSAGE POPUP
                   }
                   text_view.setText(edit_text_bar_code.getText());//PLACEHOLDER FIELD
               } catch (NumberFormatException e) {//CATCH PARSING EXCEPTION
                   showErrorMessage(v, "[" + edit_text_bar_code.getText() + "] is not a valid BarCode!");//MESSAGE POPUP ABOUT BAD TYPE
               }


               try {
                   if (Integer.parseInt(edit_text_count.getText().toString()) > 0) {//CHECK IF COUNT IS POSITIVE
                       countOfItem = Integer.parseInt(edit_text_count.getText().toString());//TRY TO PARSE TO INT, IF FAIL -CATCH
                   } else {
                       showErrorMessage(v, "[" + edit_text_count.getText() + "] is not a valid count! -or+ is automaticly added depending on [ADD] or [SELL]");
                   }
                }catch(NumberFormatException e){//CATCH PARSING EXCEPTION
                        showErrorMessage(v,"["+edit_text_count.getText()+"] is not a valid count!");//MESSAGE POPUP ABOUT BAD TYPE
                    }
           }
       });

    } //VALIDATOR ALL METHOD END



    public void validatorForCount(){ //VALIDATOR for Count METHOD START
        edit_text_count = (EditText)findViewById(R.id.editText); //ASSIGN  WIDGET TO VARIABLE. editText is name of the widget in design view or xml
        edit_text_name = (EditText)findViewById(R.id.editText2); //ASSIGN WIDGET TO VARIABLE. editText2 is name of the widget in design view or xml
        edit_text_description = (EditText)findViewById(R.id.editText3);//ASSIGN  WIDGET TO VARIABLE. editText3 is name of the widget in design view or xml
        edit_text_bar_code = (EditText)findViewById(R.id.editText4);////ASSIGN  WIDGET TO VARIABLE. editText4 is name of the widget in design view or xml

        button = (Button)findViewById(R.id.button);//ASSIGN VALUE FROM WIDGET TO VARIABLE. button is name of the widget in design view or xml

        text_view =(TextView)findViewById(R.id.textView);//ASSIGN WIDGET TO VARIABLE. textView is name of the widget in design view or xml
        //text_view is test placeholder

        button.setOnClickListener(new View.OnClickListener(){ //ADD LISTENER TO BUTTON CLICK, THAT DOES SOMETHING WITH VIEW
            @Override //OVERRIDE WHAT HAPPENS
            public void onClick(View v) { //OVERRIDE WHAT HAPPENS ON CLICK
                try {
                    if (Integer.parseInt(edit_text_count.getText().toString()) > 0) {//CHECK IF COUNT IS POSITIVE
                        countOfItem = Integer.parseInt(edit_text_count.getText().toString());//TRY TO PARSE TO INT, IF FAIL -CATCH
                    } else {
                        showErrorMessage(v, "[" + edit_text_count.getText() + "] is not a valid count! -or+ is automaticly added depending on [ADD] or [SELL]");
                    }
                }catch(NumberFormatException e){//CATCH PARSING EXCEPTION
                    showErrorMessage(v,"["+edit_text_count.getText()+"] is not a valid count!");//MESSAGE POPUP ABOUT BAD TYPE
                }
            }
        });

    } //VALIDATOR for Count METHOD END



















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        validatorForAll(); //CALLS VALIDATOR METHOD.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
