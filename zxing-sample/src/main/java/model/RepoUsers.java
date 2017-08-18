package model;

/**
 * Created by kirillsuvorov on 18/08/2017.
 */

import java.sql.SQLException;
import java.util.List;

import model.Product;
//import com.j256.ormlite.dao;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

    public class RepoUsers {

        Dao<Product, String> ProductDao = null;

        /*public Dao<Product, String> getProductDao() throws SQLException {
            if (ProductDao == null) {
                ProductDao = BaseDaoImpl.createDao(getConnectionSource(), Product.class);
            }
            return ProductDao;
        }*/

        public RepoUsers(DatabaseHelper db)
        {
            try {
                ProductDao = db.getProductDao();
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
                QueryBuilder<Product, String> qb = ProductDao.queryBuilder();

                qb.where().eq("Productname", Productname);

                PreparedQuery<Product> pq = qb.prepare();
                return ProductDao.queryForFirst(pq);
            } catch (SQLException e) {
                // TODO: Exception Handling
                e.printStackTrace();
            }
            return null;
        }
        public List<Product> getAll()
        {
            try {
                return ProductDao.queryForAll();
            } catch (SQLException e) {
                // TODO: Exception Handling
                e.printStackTrace();
            }
            return null;
        }

    }