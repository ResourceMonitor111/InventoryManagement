package sql;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class ClerkContract {

    public static final String CONTENT_AUTHORITY = "me.dm7.barcodescanner.zxing.sample";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PRODUCT = "product";

    public static final class BClerkContractEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_PRODUCT).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCT;

        public static final String TABLE_NAME = "BillOfMaterials";

        public static final String COLUMN_CLERK_ID = "Clerk_id";
        public static final String COLUMN_FRIST_NAME = "firstname";
        public static final String COLUMN_LAST_NAME = "lastname";
        public static final String COLUMN_CONTACT_NUMBER = "contactNumber";
        public static final String COLUMN_email = "email";


        public static Uri buildProductUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}

