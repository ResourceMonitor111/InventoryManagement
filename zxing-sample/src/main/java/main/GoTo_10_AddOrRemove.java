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

//HOLDER
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import main.Adapters.ExpandableListAdapter;
import R.R;

public class GoTo_10_AddOrRemove extends AppCompatActivity {

    //HOLDER START
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> laptopCollection;
    ExpandableListView expListView;

    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("HP");
        groupList.add("Dell");
        groupList.add("Lenovo");
        groupList.add("Sony");
        groupList.add("HCL");
        groupList.add("Samsung");
    }

    private void createCollection() {
        // preparing laptops collection(child)
        String[] hpModels = { "HP Pavilion G6-2014TX", "ProBook HP 4540",
                "HP Envy 4-1025TX" };
        String[] hclModels = { "HCL S2101", "HCL L2102", "HCL V2002" };
        String[] lenovoModels = { "IdeaPad Z Series", "Essential G Series",
                "ThinkPad X Series", "Ideapad Z Series" };
        String[] sonyModels = { "VAIO E Series", "VAIO Z Series",
                "VAIO S Series", "VAIO YB Series" };
        String[] dellModels = { "Inspiron", "Vostro", "XPS" };
        String[] samsungModels = { "NP Series", "Series 5", "SF Series" };

        laptopCollection = new LinkedHashMap<String, List<String>>();

        for (String laptop : groupList) {
            if (laptop.equals("HP")) {
                loadChild(hpModels);
            } else if (laptop.equals("Dell"))
                loadChild(dellModels);
            else if (laptop.equals("Sony"))
                loadChild(sonyModels);
            else if (laptop.equals("HCL"))
                loadChild(hclModels);
            else if (laptop.equals("Samsung"))
                loadChild(samsungModels);
            else
                loadChild(lenovoModels);

            laptopCollection.put(laptop, childList);
        }
    }

    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }

    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
    //HOLDER END

    private static TextView text_view;
    private static final int ZXING_CAMERA_PERMISSION = 1;
    private Class<?> mClss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10_add_or_remove);
        setHeading();
        //HOLDER
        createGroupList();
        createCollection();

        expListView = (ExpandableListView) findViewById(R.id.laptop_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, laptopCollection);
        expListView.setAdapter(expListAdapter);

        expListView.setOnChildClickListener(new OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                final String selectedItem = (String) expListAdapter.getChild(
                        groupPosition, childPosition);

                final String selectedGroup = (String) expListAdapter.getGroup(
                        groupPosition);

                GoTo_12_AddOrRemovePutCount.setName(selectedItem);
                GoTo_12_AddOrRemovePutCount.setGroup(selectedGroup);

                if(GoTo_00_MainMenu.getAction().equals("Edit")){
                    Intent open = new Intent(v.getContext(), GoTo_41_Edit.class);
                    startActivity(open);}
                else {
                    Intent open = new Intent(v.getContext(), GoTo_12_AddOrRemovePutCount.class);
                    startActivity(open);}

                Toast.makeText(getBaseContext(), selectedGroup, Toast.LENGTH_LONG)
                        .show();
                Toast.makeText(getBaseContext(), selectedItem, Toast.LENGTH_LONG)
                        .show();

                return true;
            }
        });
        //HOLDER

    }

    public void setHeading() {
        text_view = (TextView) findViewById(R.id.button_ADD_TO_DB);

        if (GoTo_00_MainMenu.getAction().equals("Add")) {
            text_view.setText(R.string.text_add);
        } else if (GoTo_00_MainMenu.getAction().equals("Remove")) {
            text_view.setText(R.string.text_remove);
        } else if (GoTo_00_MainMenu.getAction().equals("List")) {
            text_view.setText(R.string.text_list);
        } else if (GoTo_00_MainMenu.getAction().equals("Edit")) {
            text_view.setText(R.string.text_edit);
        } else if (GoTo_00_MainMenu.getAction().equals("Invent")) {
            text_view.setText(R.string.text_invent);
        } else if (GoTo_00_MainMenu.getAction().equals("Settings")) {
            text_view.setText(R.string.text_settings);
        }
    }

    //LAUNCH activity_11_scanner
    public void launchScanner(View v) {
        launchScanner(GoTo_11_Scanner.class);
    }
    public void launchScanner(Class<?> clss) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            mClss = clss;
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, ZXING_CAMERA_PERMISSION);
        } else {
            Intent intent = new Intent(this, clss);
            startActivity(intent);
        }
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
                    Toast.makeText(this, R.string.text_camera_permission, Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

}
