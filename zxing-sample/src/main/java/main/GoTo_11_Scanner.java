package main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import android.content.SharedPreferences;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

import dialog.CameraSelectorDialog;
import dialog.FormatSelectorDialog;
import dialog.MessageDialog;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import R.R;
import scanner.ZXingScanner;

public class GoTo_11_Scanner extends ZXingScanner.ScannerActivity implements
        MessageDialog.MessageDialogListener,
        ZXingScannerView.ResultHandler,
        FormatSelectorDialog.FormatSelectorDialogListener,
        CameraSelectorDialog.CameraSelectorDialogListener {
    private static final String FLASH_STATE = "FLASH_STATE";
    private static final String AUTO_FOCUS_STATE = "AUTO_FOCUS_STATE";
    private static final String SELECTED_FORMATS = "SELECTED_FORMATS";
    private static final String CAMERA_ID = "CAMERA_ID";
    private ZXingScannerView mScannerView;
    private boolean mFlash;
    private boolean mAutoFocus;
    private ArrayList<Integer> mSelectedIndices;
    private int mCameraId = -1;
    private SharedPreferences settings;
    private String sharedPrefFile = "scanner";

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        settings = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        mFlash = settings.getBoolean(FLASH_STATE, false);
        mAutoFocus = settings.getBoolean(AUTO_FOCUS_STATE, true);
        mSelectedIndices = null;
        mCameraId = settings.getInt(CAMERA_ID, -1);

        setToolbarTitle(GoTo_00_MainMenu.getAction());
        setContentView(R.layout.activity_11_scanner);
        setupToolbar();

        ViewGroup contentFrame = (ViewGroup) findViewById(R.id.content_frame);
        mScannerView = new ZXingScannerView(this);
        setupFormats();
        contentFrame.addView(mScannerView);
    }

    public void setToolbarTitle(String action) {
        if (action.equals("Add")) {
            setTitle(R.string.text_add);
        } else if (action.equals("Remove")) {
            setTitle(R.string.text_remove);
        } else if (action.equals("List")) {
            setTitle(R.string.text_list);
        } else if (action.equals("Edit")) {
            setTitle(R.string.text_edit);
        } else if (action.equals("Invent")) {
            setTitle(R.string.text_invent);
        } else if (action.equals("Settings")) {
            setTitle(R.string.text_settings);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera(mCameraId);
        mScannerView.setFlash(mFlash);
        mScannerView.setAutoFocus(mAutoFocus);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(SELECTED_FORMATS, mSelectedIndices);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem;

        if(mFlash) {
            menuItem = menu.add(Menu.NONE, R.id.menu_flash, 0, R.string.flash_on);
        } else {
            menuItem = menu.add(Menu.NONE, R.id.menu_flash, 0, R.string.flash_off);
        }
        MenuItemCompat.setShowAsAction(menuItem, MenuItem.SHOW_AS_ACTION_NEVER);

        if(mAutoFocus) {
            menuItem = menu.add(Menu.NONE, R.id.menu_auto_focus, 0, R.string.auto_focus_on);
        } else {
            menuItem = menu.add(Menu.NONE, R.id.menu_auto_focus, 0, R.string.auto_focus_off);
        }
        MenuItemCompat.setShowAsAction(menuItem, MenuItem.SHOW_AS_ACTION_NEVER);

        menuItem = menu.add(Menu.NONE, R.id.menu_formats, 0, R.string.formats);
        MenuItemCompat.setShowAsAction(menuItem, MenuItem.SHOW_AS_ACTION_NEVER);

        menuItem = menu.add(Menu.NONE, R.id.menu_camera_selector, 0, R.string.select_camera);
        MenuItemCompat.setShowAsAction(menuItem, MenuItem.SHOW_AS_ACTION_NEVER);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.menu_flash:
                mFlash = !mFlash;
                if(mFlash) {
                    item.setTitle(R.string.flash_on);
                } else {
                    item.setTitle(R.string.flash_off);
                }
                mScannerView.setFlash(mFlash);
                return true;
            case R.id.menu_auto_focus:
                mAutoFocus = !mAutoFocus;
                if(mAutoFocus) {
                    item.setTitle(R.string.auto_focus_on);
                } else {
                    item.setTitle(R.string.auto_focus_off);
                }
                mScannerView.setAutoFocus(mAutoFocus);
                return true;
            case R.id.menu_formats:
                DialogFragment fragment = FormatSelectorDialog.newInstance(this, mSelectedIndices);
                fragment.show(getSupportFragmentManager(), "format_selector");
                return true;
            case R.id.menu_camera_selector:
                mScannerView.stopCamera();
                DialogFragment cFragment = CameraSelectorDialog.newInstance(this, mCameraId);
                cFragment.show(getSupportFragmentManager(), "camera_selector");
                return true;
            default:
                return true;
        }
    }

    //WHEN YOU CATCH FUCKING BARCODE = RESULT
    @Override
    public void handleResult(Result rawResult) {
        GetResult.setResult(rawResult);
        if(GoTo_00_MainMenu.getAction().equals("Edit")){
            launchAnswer(GoTo_41_Edit.class);
        } else {
            launchAnswer(GoTo_12_AddOrRemovePutCount.class);
        }
    }

    //LAUNCH activity_test
    public void launchAnswer(Class<?> clss) {
        Intent intent = new Intent(this, clss);
        startActivity(intent);
    }

    public void showMessageDialog(String message) {
        DialogFragment fragment = MessageDialog.newInstance("Scan Results", message, this);
        fragment.show(getSupportFragmentManager(), "scan_results");
    }

    public void closeMessageDialog() {
        closeDialog("scan_results");
    }

    public void closeFormatsDialog() {
        closeDialog("format_selector");
    }

    public void closeDialog(String dialogName) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment) fragmentManager.findFragmentByTag(dialogName);
        if(fragment != null) {
            fragment.dismiss();
        }
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        // Resume the camera
        mScannerView.setFlash(false);
        mScannerView.stopCamera();
    }

    @Override
    public void onFormatsSaved(ArrayList<Integer> selectedIndices) {
        mSelectedIndices = selectedIndices;
        setupFormats();
    }

    @Override
    public void onCameraSelected(int cameraId) {
        mCameraId = cameraId;
        mScannerView.startCamera(mCameraId);
        mScannerView.setFlash(mFlash);
        mScannerView.setAutoFocus(mAutoFocus);
    }

    public void setupFormats() {
        List<BarcodeFormat> formats = new ArrayList<BarcodeFormat>();
        if(mSelectedIndices == null || mSelectedIndices.isEmpty()) {
            mSelectedIndices = new ArrayList<Integer>();
            for(int i = 0; i < ZXingScannerView.ALL_FORMATS.size(); i++) {
                mSelectedIndices.add(i);
            }
        }

        for(int index : mSelectedIndices) {
            formats.add(ZXingScannerView.ALL_FORMATS.get(index));
        }
        if(mScannerView != null) {
            mScannerView.setFormats(formats);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences settings = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(FLASH_STATE, mFlash);
        editor.putBoolean(AUTO_FOCUS_STATE, mAutoFocus);
        editor.putInt(CAMERA_ID, mCameraId);
        editor.apply();

        mScannerView.stopCamera();
        closeMessageDialog();
        closeFormatsDialog();
    }
}
