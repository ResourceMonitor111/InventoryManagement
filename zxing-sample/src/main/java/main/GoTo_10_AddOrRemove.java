package main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import me.dm7.barcodescanner.zxing.sample.R;

public class GoTo_10_AddOrRemove extends AppCompatActivity {

    private static TextView text_view;
    private static final int ZXING_CAMERA_PERMISSION = 1;
    private Class<?> mClss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10_add_or_remove);
        setHeading();
    }

    public void setHeading(){
        text_view = (TextView) findViewById(R.id.scantxt);
        if (GoTo_00_MainMenu.getAction() == true) {
            text_view.setText("Receive");
        }
        else text_view.setText("Sell");
    }

    //LAUNCH activity_11_scanner
    public void launchScanner(View v) {
        launchScanner(GoTo_11_Scanner.class);
    }


    //LAUNCH activity_11_scanner IF CAMERA_PERMISSION = TRUE
    public void launchScanner(Class<?> clss) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            mClss = clss;
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, ZXING_CAMERA_PERMISSION);
        } else {
            Intent intent = new Intent(this, clss);
            startActivity(intent); // STARTS activity_11_scanner
        }
    }

    public void launchMain(View v) {
        launchMain(GoTo_00_MainMenu.class);
    }

    public void launchMain(Class<?> clss) {
        Intent intent = new Intent(this, clss);
        startActivity(intent);
    }

    //CAMERA_PERMISSION
    @Override
    public void onRequestPermissionsResult(int requestCode,  String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ZXING_CAMERA_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(mClss != null) {
                        Intent intent = new Intent(this, mClss);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(this, "Please grant camera permission to use the QR GoTo_11_Scanner", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

}
