package data;

import java.sql.SQLException;
import java.util.List;

import model.BillOfMaterialsORM;
import model.Product;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class RepoUsers {

    Dao<BillOfMaterialsORM, Integer> BillOfMaterialsORMDao = null;
    Dao<Product, Integer> ProductDao = null;

    public RepoUsers(DatabaseHelper db)
    {
        try {
            ProductDao = db.getProductDao();
            BillOfMaterialsORMDao = db.getBillOfMaterialsORMDao();
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

}