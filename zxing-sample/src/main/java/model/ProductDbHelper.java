package model;
import model.ProductContract;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ProductDbHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = ProductDbHelper.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "ScaneristDB_v3.db";

    public ProductDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATION_PRODUCT_TABLE =
                "CREATE TABLE " + ProductContract.ProductEntry.TABLE_NAME + " (" +
                        ProductContract.ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ProductContract.ProductEntry.COLUMN_BARCODE + " VARCHAR(13) UNIQUE NOT NULL, " + //OR TEXT
                        ProductContract.ProductEntry.COLUMN_NAME + " VARCHAR(50) UNIQUE NOT NULL, " +
                        ProductContract.ProductEntry.COLUMN_PRODUCTTYPE + " VARCHAR(15) NOT NULL, " +
                        ProductContract.ProductEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                        ProductContract.ProductEntry.COLUMN_IMAGE + " BLOB, " +
                        ProductContract.ProductEntry.COLUMN_DATETIMEMODIFIED + " TIMESTAMP NOT NULL, " +
                        ProductContract.ProductEntry.COLUMN_PRICE + " NUMERIC(7,2) , " +
                        ProductContract.ProductEntry.COLUMN_DESCRIPTION+ " TEXT" +
                        " );";
        final String SQL_CREATION_BILLOFMATERIALS_TABLE = "";
        final String SQL_CREATION_PRODUCTTRANSACTION = "";
        final String SQL_CREATION_CLERK = "";
        final String SQL_CREATION_SHOPTRANSACTION = "";

        Log.d(LOG_TAG, "onCreate: " + SQL_CREATION_PRODUCT_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATION_PRODUCT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProductContract.ProductEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void deleteDatabase(Context context) {

        context.deleteDatabase(DATABASE_NAME);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

