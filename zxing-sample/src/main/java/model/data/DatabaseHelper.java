package data;

import java.io.IOException;
import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import model.ProductTransaction;
import model.Product;
import model.Clerk;
import model.BillOfMaterialsORM;
import model.ShopTransaction;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "ScaneristDB_v3.db";
	private static final int DATABASE_VERSION = 1;

	private Dao<Product, Integer> ProductDao = null;
	private Dao<Clerk, Integer> ClerkDao = null;
	private Dao<BillOfMaterialsORM, Integer> BillOfMaterialsORMDao = null;
	private Dao<ProductTransaction, Integer> ProductTransactionDao = null;
	private Dao<ShopTransaction, Integer> ShopTransactionDao = null;



	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

		DatabaseInitializer initializer = new DatabaseInitializer(context);
		try {
			initializer.createDatabase();
			initializer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");

			TableUtils.createTable(connectionSource, Product.class);
			TableUtils.createTable(connectionSource, Clerk.class);
			TableUtils.createTable(connectionSource, BillOfMaterialsORM.class);
			TableUtils.createTable(connectionSource, ProductTransaction.class);
			TableUtils.createTable(connectionSource, ShopTransaction.class);


		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");

			TableUtils.dropTable(connectionSource, Product.class, true);
			TableUtils.dropTable(connectionSource, Clerk.class, true);
			TableUtils.dropTable(connectionSource, BillOfMaterialsORM.class, true);
			TableUtils.dropTable(connectionSource, ProductTransaction.class, true);
			TableUtils.dropTable(connectionSource, ShopTransaction.class, true);

			onCreate(db);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}


	public Dao<Product, Integer> getProductDao() throws SQLException {
		if (ProductDao == null) {
			ProductDao = DaoManager.createDao(getConnectionSource(), Product.class);
		}
		return ProductDao;
	}

	public Dao<Clerk, Integer> getClerkDao() throws SQLException {
		if (ClerkDao == null) {
			ClerkDao = DaoManager.createDao(getConnectionSource(), Clerk.class);
		}
		return ClerkDao;
	}

	public Dao<BillOfMaterialsORM, Integer> getBillOfMaterialsORMDao() throws SQLException {
		if (BillOfMaterialsORMDao == null) {
			BillOfMaterialsORMDao = DaoManager.createDao(getConnectionSource(), Clerk.class);
		}
		return BillOfMaterialsORMDao;
	}

	public Dao<ProductTransaction, Integer> getProductTransactionDao() throws SQLException {
		if (ProductTransactionDao == null) {
			ProductTransactionDao = DaoManager.createDao(getConnectionSource(), Clerk.class);
		}
		return ProductTransactionDao;
	}

	public Dao<ShopTransaction, Integer> getShopTransactionDao() throws SQLException {
		if (ShopTransactionDao == null) {
			ShopTransactionDao = DaoManager.createDao(getConnectionSource(), Clerk.class);
		}
		return ShopTransactionDao;
	}

	@Override
	public void close() {
		super.close();
		ProductDao = null;
		ClerkDao = null;
		BillOfMaterialsORMDao = null;
		ProductTransactionDao = null;
		ShopTransactionDao = null;
	}
}