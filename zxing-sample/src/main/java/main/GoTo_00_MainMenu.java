package main;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import model.SQLiteDB;
import me.dm7.barcodescanner.zxing.sample.R;


public class GoTo_00_MainMenu extends AppCompatActivity {

    private static boolean action = true;

    public static boolean getAction() {
        if (action == true) return true;
        else return false;
    }

    public void buttonListeners(){

        Button plus = (Button)findViewById(R.id.btn_add);
        plus.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent open = new Intent(v.getContext(), GoTo_10_AddOrRemove.class);
                        action=true;
                        startActivity(open); }});

        Button minus = (Button)findViewById(R.id.btn_remove);
        minus.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                        Intent open = new Intent(v.getContext(), GoTo_10_AddOrRemove.class);
                        action=false;
                        startActivity(open);}});
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_00_main_menu);

        buttonListeners();
        //instantiate ContentProvider
        //SQLiteDatabase mydatabase = openOrCreateDatabase("scanerist_db",MODE_PRIVATE,null);
        SQLiteDB db = new SQLiteDB(); // FIXME this aint good. USe resource providers!
        db.connect();
    }

}
