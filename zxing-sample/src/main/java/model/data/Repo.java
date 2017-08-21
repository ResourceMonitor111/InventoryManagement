package data;
import android.content.Context;


public class Repo {
	DatabaseHelper db;

	public RepoUsers Products;
	public RepoUsers BillsOfMaterialsORM;
	public RepoUsers Clerk;
	public RepoUsers ShopTransaction;
	public RepoUsers ProductTransaction;

	public Repo(Context context)
	{
		DatabaseManager<DatabaseHelper> manager = new DatabaseManager<DatabaseHelper>();
		db = manager.getHelper(context);


		Products = new RepoUsers(db);
		BillsOfMaterialsORM = new RepoUsers(db);
		Clerk = new RepoUsers(db);
		ShopTransaction = new RepoUsers(db);
		ProductTransaction = new RepoUsers(db);

	}
}