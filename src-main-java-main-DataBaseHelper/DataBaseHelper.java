package main;

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


public class DataBaseHelper extends SQLiteOpenHelper {

    //The Android's default system path of your application database.
    private static String DB_PATH = "data/data/me.dm7.barcodescanner.zxing.sample/";

//    private static String DB_PATH = Context.getFilesDir().getPath();
    private static String DB_NAME = "ScanerisDB_v4.db";
    private final Context myContext;
    private SQLiteDatabase myDataBase;

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
     * @return ArrayList of all products from the ScanerisDB_v4.db
     */
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();

        // Select All Query
        String selectQuery = "SELECT  * FROM Product";

        Cursor cursor = myDataBase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setProduct_id(Integer.parseInt(cursor.getString(0)));
                product.setBarcode(cursor.getString(1));
                product.setName(cursor.getString(2));
                product.setProductType(cursor.getString(3));
                product.setAmount(Integer.parseInt(cursor.getString(4)));
                product.setDatetimeModified(cursor.getString(6));
                product.setPrice(Double.parseDouble(cursor.getString(7)));
                product.setDescription(cursor.getString(8));

                // Adding contact to list
                productList.add(product);
            } while (cursor.moveToNext());
        }

        return productList;
    }

    /**
     * Inserts a new product into the ScanerisDB_v4.db
     * @param product
     */
    public void insertProduct(Product product) {
        ContentValues values = new ContentValues();

        values.put("name", product.getName());
        values.put("barcode", product.getBarcode());
        values.put("productType", product.getProductType());
        values.put("amount", product.getAmount());
        values.put("price", product.getPrice());
        values.put("description", product.getDescription());

        // Inserting Row
        myDataBase.insert("Product", null, values);
    }

    /**
     *
     * @param barcode
     * @return product with specified barcode at @param. Returns null if product does not exist in db.
     */
    public Product getProduct(String barcode) {
        Product product = null;

        String selectQuery = "SELECT * FROM Product where barcode = '" + barcode + "'";
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
                        cursor.getString(5),
                        Double.parseDouble(cursor.getString(6)),
                        cursor.getString(7)
                );
            } while (cursor.moveToNext());
        }

        return product;
    }

    /**
     *
     * @return ArrayList of all BillOfMaterials from the ScanerisDB_v4.db
     */

    public List<BillOfMaterials> getAllBillOfMaterials() {
        List<BillOfMaterials> billOfMaterialsList = new ArrayList<BillOfMaterials>();

        // Select All Query
        String selectQuery = "SELECT  * FROM BillOfMaterials";

        Cursor cursor = myDataBase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                BillOfMaterials billOfMaterials = new BillOfMaterials();
                billOfMaterials.set_id(Integer.parseInt(cursor.getString(0)));
                billOfMaterials.setAmountArrived(Integer.parseInt(cursor.getString(1)));
                billOfMaterials.setDatetimeAdded(cursor.getString(2));
                billOfMaterials.setDeliveredBy(cursor.getString(3));
                billOfMaterials.setContactNumber(Integer.parseInt(cursor.getString(4)));
                billOfMaterials.setProductId(Integer.parseInt(cursor.getString(5)));



                // Adding contact to list
                billOfMaterialsList.add(billOfMaterials);
            } while (cursor.moveToNext());
        }

        return billOfMaterialsList;
    }

    /**
     * Inserts a new bill into the ScanerisDB_v4.db
     */
    public void insertBillOfMaterials(BillOfMaterials billOfMaterials) {
        ContentValues values = new ContentValues();

        values.put("id", billOfMaterials.get_id());
        values.put("amountArrived", billOfMaterials.getAmountArrived());
        values.put("datetimeAdded",billOfMaterials.getDatetimeAdded());
        values.put("deliveredBy", billOfMaterials.getDeliveredBy());
        values.put("contactNumber", billOfMaterials.getContactNumber());
        values.put("productId", billOfMaterials.getProductId());

        // Inserting Row
        myDataBase.insert("BillOfMaterials", null, values);
    }

    /**
     *
     * @param id
     * @return billOfMaterials with specified id at @param. Returns null if billOfMaterials does not exist in db.
     */
    public BillOfMaterials getBillOfMaterials(int id) {
        BillOfMaterials billOfMaterials = null;

        String selectQuery = "SELECT * FROM BillOfMaterials where id = '" + id + "'";
        Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                // Constructing a product from result set
                billOfMaterials = new BillOfMaterials(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        cursor.getString(2),
                        cursor.getString(3),
                        Integer.parseInt(cursor.getString(4)),
                        Integer.parseInt(cursor.getString(5))
                );
            } while (cursor.moveToNext());
        }

        return billOfMaterials;
    }

    /**
     *
     * @return ArrayList of all Clerks from the ScanerisDB_v4.db
     */

    public List<Clerk> getAllClerks() {
        List<Clerk> clerkList = new ArrayList<Clerk>();

        // Select All Query
        String selectQuery = "SELECT  * FROM Clerk";

        Cursor cursor = myDataBase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Clerk clerk = new Clerk();
                clerk.setClerk_id(Integer.parseInt(cursor.getString(0)));
                clerk.setFirstname(cursor.getString(1));
                clerk.setLastname(cursor.getString(2));
                clerk.setContactNumber(Integer.parseInt(cursor.getString(3)));
                clerk.setEmail(cursor.getString(4));



                // Adding contact to list
                clerkList.add(clerk);
            } while (cursor.moveToNext());
        }

        return clerkList;
    }

    /**
     * Inserts a new Clerk into the ScanerisDB_v4.db
     */
    public void insertClerk(Clerk clerk) {
        ContentValues values = new ContentValues();

        values.put("Clerk_id", clerk.getClerk_id());
        values.put("firstname", clerk.getFirstname());
        values.put("lastname", clerk.getLastname());
        values.put("contactNumber", clerk.getContactNumber());
        values.put("email", clerk.getEmail());

        // Inserting Row
        myDataBase.insert("Clerk", null, values);
    }

    /**
     *
     * @param Clerk_id
     * @return Clerk with specified id at @param. Returns null if Clerk does not exist in db.
     */
    public Clerk getClerk(int Clerk_id) {
        Clerk clerk = null;

        String selectQuery = "SELECT * FROM Clerk where Clerk_id = '" + Clerk_id + "'";
        Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                // Constructing a product from result set
                clerk = new Clerk(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4)
                );
            } while (cursor.moveToNext());
        }

        return clerk;
    }

    /**
     *
     * @return ArrayList of all ShopTransaction from the ScanerisDB_v4.db
     */

    public List<ShopTransaction> getAllShopTransactions() {
        List<ShopTransaction> shopTransactionList = new ArrayList<ShopTransaction>();

        // Select All Query
        String selectQuery = "SELECT  * FROM ShopTransaction";

        Cursor cursor = myDataBase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ShopTransaction shopTransaction = new ShopTransaction();
                shopTransaction.set_transaction_id(Integer.parseInt(cursor.getString(0)));
                shopTransaction.setDatetimeCreated(cursor.getString(1));
                shopTransaction.setClerk_id(Integer.parseInt(cursor.getString(2)));
                // Adding contact to list
                shopTransactionList.add(shopTransaction);
            } while (cursor.moveToNext());
        }
        return shopTransactionList;
    }

    /**
     * Inserts a new ShopTransaction into the ScanerisDB_v4.db
     */
    public void insertShopTransaction(ShopTransaction shopTransaction) {
        ContentValues values = new ContentValues();

        values.put("_transaction_id", shopTransaction.get_transaction_id());
        values.put("datetimeCreated", shopTransaction.getDatetimeCreated());
        values.put("Clerk_id", shopTransaction.getClerk_id());
        // Inserting Row
        myDataBase.insert("ShopTransaction", null, values);
    }

    /**
     *
     * @param _transaction_id
     * @return shopTransaction with specified id at @param. Returns null if shopTransaction does not exist in db.
     */
    public ShopTransaction getShopTransaction(int _transaction_id) {
        ShopTransaction shopTransaction = null;

        String selectQuery = "SELECT * FROM ShopTransaction where _transaction_id = '" + _transaction_id + "'";
        Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                // Constructing a product from result set
                shopTransaction = new ShopTransaction(
                        Integer.parseInt(cursor.getString(0)),
                        (cursor.getString(1)),
                        Integer.parseInt(cursor.getString(2))
                );
            } while (cursor.moveToNext());
        }

        return shopTransaction;
    }

    /**
     *
     * @return ArrayList of all ProductTransaction from the ScanerisDB_v4.db
     */

    public List<ProductTransaction> getAllProductTransactions() {
        List<ProductTransaction> productTransactionList = new ArrayList<ProductTransaction>();

        // Select All Query
        String selectQuery = "SELECT  * FROM ProductTransaction";

        Cursor cursor = myDataBase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ProductTransaction productTransaction = new ProductTransaction();
                productTransaction.setSoldAmount(Integer.parseInt(cursor.getString(0)));
                productTransaction.setProductid(Integer.parseInt(cursor.getString(1)));
                productTransaction.setTransactionid(Integer.parseInt(cursor.getString(2)));
                // Adding contact to list
                productTransactionList.add(productTransaction);
            } while (cursor.moveToNext());
        }
        return productTransactionList;
    }

    public void insertProductTransaction(ProductTransaction productTransaction) {
        ContentValues values = new ContentValues();

        values.put("soldAmount", productTransaction.getSoldAmount());
        values.put("productid", productTransaction.getProductid());
        values.put("transactionId", productTransaction.getTransactionid());
        // Inserting Row
        myDataBase.insert("ProductTransaction", null, values);
    }

    /**
     *
     * @param transactionId
     * @return productTransaction with specified id at @param. Returns null if producttransaction does not exist in db.
     */
    public ProductTransaction getProductTransaction(int transactionId) {
        ProductTransaction productTransaction = null;

        String selectQuery = "SELECT * FROM ProductTransaction where transactionId = '" + transactionId + "'";
        Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                // Constructing a product from result set
                productTransaction = new ProductTransaction(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        Integer.parseInt(cursor.getString(2))
                );
            } while (cursor.moveToNext());
        }

        return productTransaction;
    }
}