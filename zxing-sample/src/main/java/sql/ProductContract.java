package sql;
/**
 * Created by kirillsuvorov on 17/08/2017.
 */

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public final class ProductContract {
    private ProductContract(){}

    public static final String CONTENT_AUTHORITY = "me.dm7.barcodescanner.zxing.sample";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PRODUCT = "Product";

    public static final class ProductEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_PRODUCT).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT;

        public static final String TABLE_NAME = "Product";

        public static final String COLUMN_BARCODE = "barcode";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRODUCTTYPE = "productType";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_DATETIMEMODIFIED = "datetimeModified";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_DESCRIPTION = "description";

        public static Uri buildProductUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
