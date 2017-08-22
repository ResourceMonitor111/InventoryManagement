package sql;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class ClerkContract {

    public static final String CONTENT_AUTHORITY = "me.dm7.barcodescanner.zxing.sample";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_CLERK = "Clerk";

    public static final class ClerkEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_CLERK).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CLERK;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CLERK;

        public static final String TABLE_NAME = "Clerk";

        public static final String COLUMN_FRIST_NAME = "firstname";
        public static final String COLUMN_LAST_NAME = "lastname";
        public static final String COLUMN_CONTACT_NUMBER = "contactNumber";
        public static final String COLUMN_EMAIL = "email";


        public static Uri buildClerkUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}

