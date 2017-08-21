package main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import R.R;
import sql.SQLiteDB;


public class GoTo_12_AddOrRemovePutCount extends AppCompatActivity {

    private static TextView text_view;
    private static TextView editText_name;
    private static TextView editText_barCode;
    private static EditText editText_count;

    private static long barCode;

    public static long getBarCode(){return barCode;}
    public static void setBarCode(long code){barCode=code;}

    private static int count;
    public static int getCount(){
        return count;}
    public static void setCount(int code){
        count=code;}

    private static String name = "NAME";
    public static String getName(){
        return name;}
    public static void setName(String text){
        name=text;}

    private static String group = "GROUP";
    public static String getGroup(){
        return group;}
    public static void setGroup(String text){
        group = text;}

    @Override
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_12_add_or_remove_put_count);

        SQLiteDB db = new SQLiteDB(); // FIXME this aint good. USe resource providers!
        db.connect();
        setHeading();
        setValues();
    }


    public void setHeading(){
        // ADD or REMOVE
        text_view =(TextView)findViewById(R.id.button_ADD_TO_DB);
        if(GoTo_00_MainMenu.getAction() == "Add") {
            text_view.setText(R.string.text_add);
        }  else text_view.setText(R.string.text_remove);
    }

    public void setValues(){
        editText_name =(TextView)findViewById(R.id.editText_NAME);
        editText_barCode =(TextView)findViewById(R.id.editText_BARCODE);
        editText_count =(EditText)findViewById(R.id.editText_COUNT);

        editText_name.setText(""+getName());
        editText_barCode.setText(GetResult.getCodeString());
        setCount(1);
        editText_count.setText(""+getCount());
        editText_count.setSelection(editText_count.getText().length());


        DataBaseHelper a = new DataBaseHelper(this);
        a.openDataBase();
////        List<Product> productList = a.getAllProducts();
////        for (Product p: productList) {
////            System.out.println(p.toString());
////        }
//
////        a.openDataBase();
////        Product c = new Product();
////        Product b = new Product(0, "5000112618877", "Nestea", "Dzēriens", 0, null, null, 12.2, "description");
////        c =a.getProduct(b.barcode);
////
////        if (c.getProduct_name()==null) {
////            a.insertProduct(b);
////            c =a.getProduct(b.barcode);
////        }
////
////        editText_count.setText(""+c.getProduct_name());
//
        a.close();
    }


    public void showMessage(View view){
        if(validatorForCount()==true) {
            showNotificationMessage(view, editText_count.getText() + " of " + editText_name.getText() + " was " + text_view.getText());
        }
    }

    public boolean validatorForCount(){ //VALIDATOR for Count METHOD START
        editText_count = (EditText)findViewById(R.id.editText_COUNT); //ASSIGN  WIDGET TO VARIABLE. editText is name of the widget in design view or xml

                try {
                    if (Integer.parseInt(editText_count.getText().toString()) > 0) {//CHECK IF COUNT IS POSITIVE
                        setCount(Integer.parseInt(editText_count.getText().toString()));//TRY TO PARSE TO INT, IF FAIL -CATCH
                        return true;
                    } else {
                        showErrorMessage("[" + editText_count.getText() + "] is not a valid count! -or+ is automaticly added depending on [ADD] or [SELL]");
                        return false;}
                }catch(NumberFormatException e){//CATCH PARSING EXCEPTION
                    showErrorMessage("["+editText_count.getText()+"] is not a valid count!");//MESSAGE POPUP ABOUT BAD TYPE
                    return false;
                }
    } //VALIDATOR for Count METHOD END


    public void showErrorMessage(String message){//MESSAGE CONSTRUCTOR START
    //View view might be unneeded,String message contains output text for message
        AlertDialog.Builder myAlert =new AlertDialog.Builder(GoTo_12_AddOrRemovePutCount.this);//CREATE NEW MESSAGE//MESSAGE NAME "myAlert"
        myAlert.setMessage(message) //ADDS WHAT TE]XT MESSAGE DISPLAYS//DISPLAYS RECEIVED PARAM "message"
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() { //ADD BUTTON TO MESSAGE
                    @Override//OVERRIDE WHAT HAPENS WHEN CLICKED ON MESSAGE BUTTON
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();} //ASSIGN WHAT ADDED BUTTON DOES. DISMISS - CLOSES MESSAGE
                }).create(); // CREATES INSTANCE OF DEFINED MESSAGE
        myAlert.setCancelable(false);//can not be backed of, and closed by misclick
        myAlert.show(); //SHOWS CREATED MESSAGE ON SCREEN
    } //MESSAGE CONSTRUCTOR END
//
    public void showNotificationMessage(final View view, String message){//MESSAGE CONSTRUCTOR START
    //View view might be unneeded,String message contains output text for message
        AlertDialog.Builder myAlert =new AlertDialog.Builder(GoTo_12_AddOrRemovePutCount.this);//CREATE NEW MESSAGE//MESSAGE NAME "myAlert"
        myAlert.setMessage(message) //ADDS WHAT TE]XT MESSAGE DISPLAYS//DISPLAYS RECEIVED PARAM "message"
                .setPositiveButton("Home", new DialogInterface.OnClickListener() { //ADD BUTTON TO MESSAGE
                    @Override//OVERRIDE WHAT HAPENS WHEN CLICKED ON MESSAGE BUTTON
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();//ASSIGN WHAT ADDED BUTTON DOES. DISMISS - CLOSES MESSAGE
                        Intent open = new Intent(view.getContext(), GoTo_00_MainMenu.class);
                        startActivity(open); }})
                .setNegativeButton(text_view.getText()+" more", new DialogInterface.OnClickListener() { //ADD BUTTON TO MESSAGE
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
