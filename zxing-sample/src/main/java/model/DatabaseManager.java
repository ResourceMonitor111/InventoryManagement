package model;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

/**
 * Created by kirillsuvorov on 18/08/2017.
 */

/*
  The helper can be kept open across all activities in your app with the same SQLite database connection reused by all threads.
  If you open multiple connections to the same database, stale data and unexpected results may occur.
  We recommend using the OpenHelperManager to monitor the usage of the helper – it will create it on the first access,
  track each time a part of your code is using it, and then it will close the last time the helper is released.
 Once you have defined your database helper and are managing it correctly, you will need to use it in your Activity classes.
 An easy way to use the OpenHelperManager is to extend OrmLiteBaseActivity for each of your activity classes –
 there is also OrmLiteBaseListActivity, OrmLiteBaseService, and OrmLiteBaseTabActivity.
 These classes provide a helper protected field and a getHelper() method to access the database helper whenever it is needed
 and will automatically create the helper in the onCreate() method and release it in the onDestroy() method.
 See the sample HelloAndroid activity class in the examples. See section Android Examples.
 If you do not want to extend the OrmLiteBaseActivity and other base classes then you will need to duplicate their functionality.
http://ormlite.com/javadoc/ormlite-core/doc-files/ormlite_4.html#Use-With-Android
 */

public class DatabaseManager<H extends OrmLiteSqliteOpenHelper> {

    private H helper;

    @SuppressWarnings("unchecked")
    public H getHelper(Context context)
    {
        if(helper == null)
        {
            helper = (H) OpenHelperManager.getHelper(context);
            //helper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return helper;
    }

    public void releaseHelper(H helper)
    {
        if (helper != null) {
            OpenHelperManager.releaseHelper();
            helper = null;
        }
    }

}
