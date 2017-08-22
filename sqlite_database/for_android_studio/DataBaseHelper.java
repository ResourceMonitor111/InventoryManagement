package com.caurs.peteris.sqliteproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peteris Caurs on 18.08.2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/com.caurs.peteris.sqliteproject/";

    private static String DB_NAME = "scanerist_db.db";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DataBaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException{

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException {

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     *
     * @return ArrayList of all products from the scanerist_db.db
     */
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();

        // Select All Query
        String selectQuery = "SELECT  * FROM [product]";

        Cursor cursor = myDataBase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.set_id(Integer.parseInt(cursor.getString(0)));
                product.setBarcode(cursor.getString(1));
                product.setProduct_name(cursor.getString(2));
                product.setProduct_type(cursor.getString(3));
                product.setAmount(Integer.parseInt(cursor.getString(4)));
                product.setImage(cursor.getBlob(5));
                product.setDatetime(cursor.getString(6));
                product.setPrice(Double.parseDouble(cursor.getString(7)));
                product.setDescription(cursor.getString(8));

                // Adding contact to list
                productList.add(product);
            } while (cursor.moveToNext());
        }

        return productList;
    }

    /**
     * Inserts a new product into the scanerist_db.db
     * @param product
     */
    public void insertProduct(Product product) {
        ContentValues values = new ContentValues();

        values.put("product_name", product.getProduct_name());
        values.put("barcode", product.getBarcode());
        values.put("product_type", product.getProduct_type());
        values.put("amount", product.getAmount());
        values.put("image", product.getImage());
        values.put("price", product.getPrice());
        values.put("description", product.getDescription());

        // Inserting Row
        myDataBase.insert("[product]", null, values);
    }

    /**
     *
     * @param barcode
     * @return product with specified barcode at @param. Returns null if product does not exist in db.
     */
    public Product getProduct(String barcode) {
        Product product = null;

        String selectQuery = "SELECT * FROM [product] where barcode = '" + barcode + "'";
        Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                // Constructing a product from result set
                product = new Product(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        Integer.parseInt(cursor.getString(4)),
                        cursor.getBlob(5),
                        cursor.getString(6),
                        Double.parseDouble(cursor.getString(7)),
                        cursor.getString(8)
                );
            } while (cursor.moveToNext());
        }

        return product;
    }
    
    /**
     * Checks if a product with specified barcode at @param exists in the database
     * @param barcode
     * @return
     */
    public boolean barcodeExists(String barcode) {
        String selectQuery = "SELECT * FROM [product] where barcode = '" + barcode + "'";
        Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Deletes a product from database by specified barcode at @param
     * @param barcode
     */
    public void deleteProduct(String barcode) {
        myDataBase.delete("[product]", "barcode = ?", new String[] {barcode});
    }
    
    /**
     * Updates a product name and type by specified barcode at @param
     * @param barcode
     */
    public void updateProduct(String barcode, String productName, String productType) {
        ContentValues values = new ContentValues();
        values.put("product_name", productName);
        values.put("product_type", productType);
        myDataBase.update("[product]",values, "barcode = ?", new String[] {barcode});
    }
    
    /**
     * Increases amount of a product
     * @param barcode
     * @param amount
     */
    public void increaseProductAmount(String barcode, int amount) {
        Product product = getProduct(barcode);
        int result = product.getAmount() + amount;
        ContentValues values = new ContentValues();
        values.put("amount", result);
        myDataBase.update("[product]",values, "barcode = ?", new String[] {barcode});
    }

    /**
     * Decreases amount of a product
     * @param barcode
     * @param amount
     */
    public void decreaseProductAmount(String barcode, int amount) {
        Product product = getProduct(barcode);
        int result = product.getAmount() - amount;
        ContentValues values = new ContentValues();
        values.put("amount", result);
        myDataBase.update("[product]",values, "barcode = ?", new String[] {barcode});
    }
}
