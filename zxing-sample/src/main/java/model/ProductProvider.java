package model;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by kirillsuvorov on 17/08/2017.
 */

public class ProductProvider extends ContentProvider {
    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private ProductDbHelper mProductDbHelper;

    private static final int PRODUCT = 100;
    private static final int PRODUCT_ID = 101;

    private static UriMatcher buildUriMatcher() {

        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = ProductContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, ProductContract.ProductEntry.TABLE_NAME, PRODUCT);
        matcher.addURI(authority, ProductContract.ProductEntry.TABLE_NAME + "/#", PRODUCT_ID);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        mProductDbHelper = new ProductDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case PRODUCT:
                return ProductContract.ProductEntry.CONTENT_DIR_TYPE;
            case PRODUCT_ID:
                return ProductContract.ProductEntry.CONTENT_ITEM_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Cursor query(Uri uri,
                        String[] projection,
                        String selection,
                        String[] selectionArgs,
                        String sortOrder) {
        Cursor retCursor;
        switch (sUriMatcher.match(uri)) {
            case PRODUCT:
                retCursor = mProductDbHelper.getReadableDatabase().query(
                        ProductContract.ProductEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                retCursor.setNotificationUri(getContext().getContentResolver(), uri);
                return retCursor;
            case PRODUCT_ID:
                retCursor = mProductDbHelper.getReadableDatabase().query(
                        ProductContract.ProductEntry.TABLE_NAME,
                        projection,
                        ProductContract.ProductEntry._ID + " = ?",
                        new String[]{String.valueOf(ContentUris.parseId(uri))},
                        null,
                        null,
                        sortOrder);
                retCursor.setNotificationUri(getContext().getContentResolver(), uri);
                return retCursor;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final SQLiteDatabase db = mProductDbHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        Uri returnUri;

        switch (match) {
            case PRODUCT:
                long _id = db.insert(ProductContract.ProductEntry.TABLE_NAME, null, contentValues);
                if (_id > 0) {
                    returnUri = ProductContract.ProductEntry.buildProductUri(_id);
                } else {
                    throw new android.database.SQLException("Failed to insert row into: " + uri);
                }
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mProductDbHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int numDeleted;
        switch (match) {
            case PRODUCT:
                numDeleted = db.delete(
                        ProductContract.ProductEntry.TABLE_NAME, selection, selectionArgs);
                db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" +
                        ProductContract.ProductEntry.TABLE_NAME + "'");
                break;
            case PRODUCT_ID:
                numDeleted = db.delete(
                        ProductContract.ProductEntry.TABLE_NAME,
                        ProductContract.ProductEntry._ID + " = ?",
                        new String[]{String.valueOf(ContentUris.parseId(uri))});
                db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" +
                        ProductContract.ProductEntry.TABLE_NAME + "'");
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        return numDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mProductDbHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int numUpdated = 0;

        if (contentValues == null) {
            throw new IllegalArgumentException("Cannot have null content values");
        }

        switch (match) {
            case PRODUCT:
                numUpdated = db.update(ProductContract.ProductEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            case PRODUCT_ID:
                numUpdated = db.update(ProductContract.ProductEntry.TABLE_NAME,
                        contentValues,
                        ProductContract.ProductEntry._ID + " = ?",
                        new String[]{String.valueOf(ContentUris.parseId(uri))});
                break;
            default: {
                throw new UnsupportedOperationException("Unknown uri: " + uri);
            }
        }
        return numUpdated;
    }
}
