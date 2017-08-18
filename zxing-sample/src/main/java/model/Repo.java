package model;
import android.content.Context;
/**
 * Created by kirillsuvorov on 18/08/2017.
 */

public class Repo {
    DatabaseHelper db;

    public RepoUsers Products;

    public Repo(Context context)
    {
        DatabaseManager<DatabaseHelper> manager = new DatabaseManager<DatabaseHelper>();
        db = manager.getHelper(context);

        Products = new RepoUsers(db);

    }
}
