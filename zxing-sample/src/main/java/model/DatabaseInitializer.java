package model;

/**
 * Created by kirillsuvorov on 18/08/2017.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;

public class DatabaseInitializer extends SQLiteOpenHelper{

    //private static String DB_PATH = "/data/data/com.bfil.ormliterepo/databases/";
    ///Users/kirillsuvorov/Desktop/DzintarsApp/zxing-sample/src/main/java/model/ScaneristDB_v3.db
    private static String DB_NAME = "ScaneristDB_v3.db";
    //This creates the db file in e.g. /mnt/sdcard/Android/data/com.your.app/files/myData.sqlite
    private static String DB_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + DB_NAME;
    private SQLiteDatabase database;
    private final Context context;

    public DatabaseInitializer(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
    }

    public void createDatabase() throws IOException{

        boolean dbExist = checkDatabase();

        if(!dbExist){
            this.getReadableDatabase();
            try {
                copyDatabase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }

    }
    private boolean checkDatabase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){
        }

        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }
    private void copyDatabase() throws IOException{

        InputStream myInput = context.getAssets().open(DB_NAME);

        String outFileName = DB_PATH + DB_NAME;

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    @Override
    public synchronized void close() {
        if(database != null)
            database.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}

