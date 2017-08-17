import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class BillOfMaterialsContract {

    public static final String CONTENT_AUTHORITY = "com.sudhirkhanger.app.inventoryapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PRODUCT = "product";

    public static final class BillOfMaterialsEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_PRODUCT).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT;

        public static final String TABLE_NAME = "Bill_Of_Materials";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_AMOUNT_ARRIVED = "amountArrived";
        public static final String COLUMN_DATETIME_ADDED = "datetimeAdded";
        public static final String COLUMN_DELIVERED_BY = "deliveredBy";
        public static final String COLUMN_CONTACT_NUMBER = "contactNumber";
        public static final String COLUMN_FK_PRODUCT_ID = "productId";


        public static Uri buildProductUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}


