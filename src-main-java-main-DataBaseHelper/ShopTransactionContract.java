package sql;


import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public final class ShopTransactionContract {
    private ShopTransactionContract(){}

    public static final String CONTENT_AUTHORITY = "me.dm7.barcodescanner.zxing.sample";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_SHOPTRANSACTION = "ShopTransaction";

    public static final class ShopTransactionEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_SHOPTRANSACTION).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOPTRANSACTION;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SHOPTRANSACTION;

        public static final String TABLE_NAME = "ShopTransaction";

        public static final String COLUMN_TRANSACTION_ID = "_transaction_id";
        public static final String COLUMN_DATETIME_CREATED = "datetimeCreated";
        public static final String COLUMN_CLERK_ID = "Clerk_id";


        public static Uri buildShopTransactionUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
