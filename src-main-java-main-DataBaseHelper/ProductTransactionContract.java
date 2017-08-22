package sql;


import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public final class ProductTransactionContract {
    private ProductTransactionContract(){}

    public static final String CONTENT_AUTHORITY = "me.dm7.barcodescanner.zxing.sample";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PRODUCTTRANSACTION = "ProductTransaction";

    public static final class ProductTransactionEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_PRODUCTTRANSACTION).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTTRANSACTION;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTTRANSACTION;

        public static final String TABLE_NAME = "ProductTransaction";

        public static final String COLUMN_SOLD_AMOUNT = "soldAmount";
        public static final String COLUMN_FK_PRODUCT_ID = "productId";
        public static final String COLUMN_TRANSACTION_ID = "transactionId";


        public static Uri buildProductTransactionUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}

