package data;

import java.sql.SQLException;
import java.util.List;

import model.BillOfMaterialsORM;
import model.Clerk;
import model.Product;
import model.ProductTransaction;
import model.ShopTransaction;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoUsers {

    Dao<BillOfMaterialsORM, Integer> BillOfMaterialsORMDao = null;
    Dao<Product, Integer> ProductDao = null;
    Dao<Clerk, Integer> ClerkDao = null;
    Dao<ProductTransaction, Integer> ProductTransactionDao = null;
    Dao<ShopTransaction, Integer> ShopTransactionDao = null;


    public RepoUsers(DatabaseHelper db)
    {
        try {
            ProductDao = db.getProductDao();
            BillOfMaterialsORMDao = db.getBillOfMaterialsORMDao();
            ClerkDao = db.getClerkDao();
            ProductTransactionDao = db.getProductTransactionDao();
            ShopTransactionDao = db.getShopTransactionDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
    }

    public int create(Product Product)
    {
        try {
            return ProductDao.create(Product);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Product Product)
    {
        try {
            return ProductDao.update(Product);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Product Product)
    {
        try {
            return ProductDao.delete(Product);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }


    public Product getByProductname(String Productname)
    {
        try {
            QueryBuilder<Product, Integer> qb = ProductDao.queryBuilder();

            qb.where().eq("name", Productname);

            PreparedQuery<Product> pq = qb.prepare();
            return ProductDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductByBarcode(String barcode){
        try {
            QueryBuilder<Product, Integer> qb = ProductDao.queryBuilder();

            qb.where().eq("barcode", barcode);

            PreparedQuery<Product> pq = qb.prepare();
            return ProductDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public List<Product> getAllProducts()
    {
        try {
            return ProductDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    /*
    BillOfMaterials Repo
     */

    public int create(BillOfMaterialsORM BillOfMaterialsORM)
    {
        try {
            return BillOfMaterialsORMDao.create(BillOfMaterialsORM);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int update(BillOfMaterialsORM BillOfMaterialsORM)
    {
        try {
            return BillOfMaterialsORMDao.update(BillOfMaterialsORM);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }


    public int delete(BillOfMaterialsORM BillOfMaterialsORM)
    {
        try {
            return BillOfMaterialsORMDao.delete(BillOfMaterialsORM);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }


    public BillOfMaterialsORM getBillByProductId(String productId)
    {
        try {
            QueryBuilder<BillOfMaterialsORM, Integer> qb = BillOfMaterialsORMDao.queryBuilder();

            qb.where().eq("productId", productId);

            PreparedQuery<BillOfMaterialsORM> pq = qb.prepare();
            return BillOfMaterialsORMDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public BillOfMaterialsORM getBillByDelivery (String deliveredBy){
        try {
            QueryBuilder<BillOfMaterialsORM, Integer> qb = BillOfMaterialsORMDao.queryBuilder();

            qb.where().eq("deliveredBy", deliveredBy);

            PreparedQuery<BillOfMaterialsORM> pq = qb.prepare();
            return BillOfMaterialsORMDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public BillOfMaterialsORM getBillByDate (String datetimeAdded){
        try {
            QueryBuilder<BillOfMaterialsORM, Integer> qb = BillOfMaterialsORMDao.queryBuilder();

            qb.where().eq("datetimeAdded", datetimeAdded);

            PreparedQuery<BillOfMaterialsORM> pq = qb.prepare();
            return BillOfMaterialsORMDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public List<BillOfMaterialsORM> getAllBills()
    {
        try {
            return BillOfMaterialsORMDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

     /*
    ProductTransaction Repo
     */

    public int create(ProductTransaction ProductTransaction)
    {
        try {
            return ProductTransactionDao.create(ProductTransaction);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int update(ProductTransaction ProductTransaction)
    {
        try {
            return ProductTransactionDao.update(ProductTransaction);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }


    public int delete(ProductTransaction ProductTransaction)
    {
        try {
            return ProductTransactionDao.delete(ProductTransaction);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }


    public ProductTransaction GetProductTransactionByProductId (String productId)
    {
        try {
            QueryBuilder<ProductTransaction, Integer> qb = ProductTransactionDao.queryBuilder();

            qb.where().eq("productId", productId);

            PreparedQuery<ProductTransaction> pq = qb.prepare();
            return ProductTransactionDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public List<ProductTransaction> getAllProductTransactions()
    {
        try {
            return ProductTransactionDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

     /*
    ShopTransaction Repo
     */

    public int create(ShopTransaction ShopTransaction)
    {
        try {
            return ShopTransactionDao.create(ShopTransaction);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int update(ShopTransaction ShopTransaction)
    {
        try {
            return ShopTransactionDao.update(ShopTransaction);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }


    public int delete(ShopTransaction ShopTransaction)
    {
        try {
            return ShopTransactionDao.delete(ShopTransaction);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }


    public ShopTransaction GetShopTransactionByClerkId (String Clerk_id)
    {
        try {
            QueryBuilder<ShopTransaction, Integer> qb = ShopTransactionDao.queryBuilder();

            qb.where().eq("Clerk_id", Clerk_id);

            PreparedQuery<ShopTransaction> pq = qb.prepare();
            return ShopTransactionDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public ShopTransaction GetShopTransactionByDate (String datetime_created)
    {
        try {
            QueryBuilder<ShopTransaction, Integer> qb = ShopTransactionDao.queryBuilder();

            qb.where().eq("datetime_created", datetime_created);

            PreparedQuery<ShopTransaction> pq = qb.prepare();
            return ShopTransactionDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }


    public List<ShopTransaction> getAllShopTransactions()
    {
        try {
            return ShopTransactionDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

      /*
    Clerk Repo
     */

    public int create(Clerk Clerk)
    {
        try {
            return ClerkDao.create(Clerk);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int update(Clerk Clerk)
    {
        try {
            return ClerkDao.update(Clerk);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }


    public int delete(Clerk Clerk)
    {
        try {
            return ClerkDao.delete(Clerk);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }


    public Clerk getClerkByFirstName(String firstName)
    {
        try {
            QueryBuilder<Clerk, Integer> qb = ClerkDao.queryBuilder();

            qb.where().eq("firstName", firstName);

            PreparedQuery<Clerk> pq = qb.prepare();
            return ClerkDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public Clerk getClerkByLastName (String lastName){
        try {
            QueryBuilder<Clerk, Integer> qb = ClerkDao.queryBuilder();

            qb.where().eq("lastName", lastName);

            PreparedQuery<Clerk> pq = qb.prepare();
            return ClerkDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

    public Clerk getClerkById (String Clerk_id){
        try {
            QueryBuilder<Clerk, Integer> qb = ClerkDao.queryBuilder();

            qb.where().eq("Clerk_id", Clerk_id);

            PreparedQuery<Clerk> pq = qb.prepare();
            return ClerkDao.queryForFirst(pq);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
    public List<Clerk> getAllClerks()
    {
        try {
            return ClerkDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }

}