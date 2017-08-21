package main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import R.R;

public class GoTo_41_Edit extends AppCompatActivity {
    //holds changed value
    private String code_placeholder;
    private String name_placeholder;
    private String group_placeholder;

    //outpul message
    private String output="";

    //DEFINE USABLE WIDGETS
    private static EditText edit_text_count; //EditText widget that WILL contain count of items for increase or decrease
    private static EditText edit_text_name; // EditText widget that WILL contain name of the item
    private static EditText edit_text_group; // EditText widget that WILL contain the description of the item
    private static TextView edit_text_bar_code;// EditText widget that WILL contain the description of the item

    private static Button button_EDIT_TO_DB; //Button that initiates field validation

    private int countOfItem;//OUR ITEM COUNT//we try to read how much to add or remove
    private long barCode;//OUR BARCODE//FOR NEW RECORD
    private String name;//OUR ITEM NAME
    private String description;//OUR ITEM DESCRIPTION

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_41_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setHeading();
        setValues();
        validatorForEdit(); //CALLS VALIDATOR METHOD.
    }

    public void setHeading(){
        button_EDIT_TO_DB =(Button)findViewById(R.id.button_EDIT_TO_DB);
        button_EDIT_TO_DB.setText(R.string.text_edit);
    }

    public void setValues(){
        edit_text_bar_code =(TextView)findViewById(R.id.editText_BARCODE);
        edit_text_group =(EditText)findViewById(R.id.editText_GROUP);
        edit_text_name =(EditText)findViewById(R.id.editText_NAME);

        edit_text_bar_code.setText(GetResult.getCodeString());
        edit_text_group.setText(""+GoTo_12_AddOrRemovePutCount.getGroup());
        edit_text_name.setText(""+GoTo_12_AddOrRemovePutCount.getName());

        edit_text_name.setSelection(edit_text_name.getText().length());

        code_placeholder=GetResult.getCodeString();
        name_placeholder=GoTo_12_AddOrRemovePutCount.getName();
        group_placeholder=GoTo_12_AddOrRemovePutCount.getGroup();
    }

    public void showMessage(View view){
        if(validatorForEdit()) {

            GoTo_12_AddOrRemovePutCount.setGroup(edit_text_group.getText().toString());  ;// OTHERVISE ASSIGN edit_text_description TEXT TO "description" variable
            GoTo_12_AddOrRemovePutCount.setName(edit_text_name.getText().toString()); // OTHERVISE ASSIGN edit_text_name TEXT TO "name" variable
           // GoTo_12_AddOrRemovePutCount.setBarCode(Long.parseLong(edit_text_bar_code.getText().toString()));

            //update item HERE

//            if(!code_placeholder.equals(Long.parseLong(edit_text_bar_code.getText().toString())))
//            {showErrorMessage("Code changed from ["+code_placeholder+"] to ["+Long.parseLong(edit_text_bar_code.getText().toString())+"]");}

            if(!name_placeholder.equals(GoTo_12_AddOrRemovePutCount.getName())){
               // showErrorMessage("Name changed from ["+name_placeholder+"] to ["+GoTo_12_AddOrRemovePutCount.getName()+"]");
                output=output+"Name changed from ["+name_placeholder+"] to ["+GoTo_12_AddOrRemovePutCount.getName()+"]";
            }


            if(!group_placeholder.equals(GoTo_12_AddOrRemovePutCount.getGroup())){
                //showErrorMessage("Group changed from ["+group_placeholder+"] to ["+GoTo_12_AddOrRemovePutCount.getGroup()+"]");
                output=output+"Group changed from ["+group_placeholder+"] to ["+GoTo_12_AddOrRemovePutCount.getGroup()+"]";
            }

if(name_placeholder.equals("") && group_placeholder.equals("")){showNotificationMessage(view,GoTo_12_AddOrRemovePutCount.getName()+" of"+GoTo_12_AddOrRemovePutCount.getGroup()+"s was added");}
            else if(output.equals("")){showNotificationMessage(view,"No changes made");}
            else {showNotificationMessage(view,output);}

            name_placeholder=GoTo_12_AddOrRemovePutCount.getName();
            group_placeholder=GoTo_12_AddOrRemovePutCount.getGroup();
            output="";

        }
    }

    public void showErrorMessage( String message){//MESSAGE CONSTRUCTOR START
    //View view might be unneeded,String message contains output text for message
        AlertDialog.Builder myAlert =new AlertDialog.Builder(GoTo_41_Edit.this);//CREATE NEW MESSAGE//MESSAGE NAME "myAlert"
        myAlert.setMessage(message) //ADDS WHAT TE]XT MESSAGE DISPLAYS//DISPLAYS RECEIVED PARAM "message"
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() { //ADD BUTTON TO MESSAGE
                    @Override//OVERRIDE WHAT HAPENS WHEN CLICKED ON MESSAGE BUTTON
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();} //ASSIGN WHAT ADDED BUTTON DOES. DISMISS - CLOSES MESSAGE
                }).create(); // CREATES INSTANCE OF DEFINED MESSAGE
        myAlert.setCancelable(false);//can not be backed of, and closed by misclick
        myAlert.show(); //SHOWS CREATED MESSAGE ON SCREEN
    } //MESSAGE CONSTRUCTOR END

    public boolean validatorForEdit(){ //VALIDATOR edit METHOD START
       edit_text_name = (EditText)findViewById(R.id.editText_NAME); //ASSIGN WIDGET TO VARIABLE. editText2 is name of the widget in design view or xml
        edit_text_group = (EditText)findViewById(R.id.editText_GROUP);//ASSIGN  WIDGET TO VARIABLE. editText3 is name of the widget in design view or xml
        edit_text_bar_code = (TextView)findViewById(R.id.editText_BARCODE);////ASSIGN  WIDGET TO VARIABLE. editText4 is name of the widget in design view or xml
        button_EDIT_TO_DB = (Button)findViewById(R.id.button_EDIT_TO_DB);//ASSIGN VALUE FROM WIDGET TO VARIABLE. button is name of the widget in design view or xml

               if (edit_text_name.getText().toString().trim().length() < 3) {  //CHECK IF NAME WITHOUT SPACES IS ATLEAST 3 CHARACTERS
                   showErrorMessage( "[" + edit_text_name.getText() + "] is not a valid name!"); //IF LESS THAN 3, MESSAGE POPUP
               } else {
                   if (edit_text_group.getText().toString().trim().length() < 3) {//CURRENTLY UNKNOWN REQUIREMENTS FOR DESCRIPTION FIELD. PLACEHOLDER FOR FUTURE
                       showErrorMessage( "[" + edit_text_group.getText() + "] is not a valid description!");//IF X, MESSAGE POPUP
                   } else {
//                       try {
//                           if ((edit_text_bar_code.getText().toString().length()) == 13) { //IF BARCODE IS 13 CHARACTERS LONG
//                               long barCode = Long.parseLong(edit_text_bar_code.getText().toString());//TRY TO ASSIGN IT AS LONG TYPE TO "barCode" variable, IF FAILS - CATCH
                                 return true;
//                           } else {
//                               if (edit_text_bar_code.getText().toString().length() > 13) {//ELSE IF LONGER THAN 13
//                                   showErrorMessage( "[" + edit_text_bar_code.getText() + "] is not a valid BarCode! Too long!");//MESSAGE POPUP
//                               }
//                               if (edit_text_bar_code.getText().toString().length() < 13)//ELSE IF SHORTER THAN 13
//                                   showErrorMessage( "[" + edit_text_bar_code.getText() + "] is not a valid BarCode! Too short!");//MESSAGE POPUP
//                           }
//
//                       } catch (NumberFormatException e) {//CATCH PARSING EXCEPTION
//                           showErrorMessage( "[" + edit_text_bar_code.getText() + "] is not a valid BarCode!");//MESSAGE POPUP ABOUT BAD TYPE
//                       }
                   }
              }
        return false;
    } //VALIDATOR edit METHOD END

    public void showNotificationMessage(final View view, String message){//MESSAGE CONSTRUCTOR START
        //View view might be unneeded,String message contains output text for message
        AlertDialog.Builder myAlert =new AlertDialog.Builder(GoTo_41_Edit.this);//CREATE NEW MESSAGE//MESSAGE NAME "myAlert"
        myAlert.setMessage(message) //ADDS WHAT TE]XT MESSAGE DISPLAYS//DISPLAYS RECEIVED PARAM "message"
                .setPositiveButton("Home", new DialogInterface.OnClickListener() { //ADD BUTTON TO MESSAGE
                    @Override//OVERRIDE WHAT HAPENS WHEN CLICKED ON MESSAGE BUTTON
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();//ASSIGN WHAT ADDED BUTTON DOES. DISMISS - CLOSES MESSAGE
                        Intent open = new Intent(view.getContext(), GoTo_00_MainMenu.class);
                        startActivity(open); }})
                .setNegativeButton(button_EDIT_TO_DB.getText()+" more", new DialogInterface.OnClickListener() { //ADD BUTTON TO MESSAGE
                    @Override//OVERRIDE WHAT HAPENS WHEN CLICKED ON MESSAGE BUTTON
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();//ASSIGN WHAT ADDED BUTTON DOES. DISMISS - CLOSES MESSAGE
                        Intent open = new Intent(view.getContext(), GoTo_10_AddOrRemove.class);
                        startActivity(open);}
                }).create(); // CREATES INSTANCE OF DEFINED MESSAGE
        myAlert.setCancelable(false);//can not be backed of, and closed by misclick
        myAlert.show(); //SHOWS CREATED MESSAGE ON SCREEN
    } //MESSAGE CONSTRUCTOR END
}

