import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class ClerkContract {

    public static final String CONTENT_AUTHORITY = "com.sudhirkhanger.app.inventoryapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_CLERK = "clerk";

    public static final class ClerkContractEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_CLERK).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CLERK;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CLERK;


        public static final String TABLE_NAME = "BillOfMaterials";

        public static final String COLUMN_CLERK_ID = "Clerk_id";
        public static final String COLUMN_FRIST_NAME = "firstname";
        public static final String COLUMN_LAST_NAME = "lastname";
        public static final String COLUMN_CONTACT_NUMBER = "contactNumber";
        public static final String COLUMN_EMAIL = "email";


        public static Uri buildClerkUri(int Clerk_id) {
            return ContentUris.withAppendedId(CONTENT_URI, Clerk_id);
        }
    }
}

