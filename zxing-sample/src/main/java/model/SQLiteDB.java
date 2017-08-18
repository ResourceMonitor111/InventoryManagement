package model;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class contains methods to query the serverless SQLite database
 * 
 * @author Peteris Caurs
 */
public class SQLiteDB {

    /**
     * Connect to the ScaneristDB.db database
     *
     * @return the Connection object
     */
    public Connection connect() {
        // Create an object that will represent the database
        Connection connection = null;

        // SQLite connection string
        String url = "jdbc:sqlite:scanerist_db.db";
        try {
            // Create a connection to the database
            connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return connection;
    }

    /**
     * Read the file and returns the byte array
     *
     * @param file
     * @return the bytes of the file
     */
    private byte[] readFile(String file)
            throws FileNotFoundException, IOException {
        ByteArrayOutputStream bos = null;

        File f = new File(file);
        FileInputStream fis = new FileInputStream(f);
        byte[] buffer = new byte[1024];
        bos = new ByteArrayOutputStream();
        for (int len; (len = fis.read(buffer)) != -1;) {
            bos.write(buffer, 0, len);
        }

        return bos != null ? bos.toByteArray() : null;
    }

    /**
     * Read the image file
     *
     * @param product_id
     * @param image
     */
    public void readImage(int product_id, String image) {
        String selectSQL = "SELECT image FROM [product] WHERE product_id = ?";
        ResultSet rs = null;
        FileOutputStream fos = null;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = connect();
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setInt(1, product_id);
            rs = pstmt.executeQuery();

            // write binary stream into file
            File file = new File(image);
            fos = new FileOutputStream(file);

            System.out.println("Writing BLOB to file " + file.getAbsolutePath());
            while (rs.next()) {
                InputStream input = rs.getBinaryStream("image");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    fos.write(buffer);
                }
            }
        } catch (SQLException | IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
                if (fos != null) {
                    fos.close();
                }

            } catch (SQLException | IOException ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     * Insert new record into [product] table
     *
     * @param product_name
     * @param product_type
     * @param amount
     * @param image path to the file, for example "resources/file.jpg"
     * @param price
     * @param description
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void insertProduct(String product_name, String barcode, int product_type, int amount,
                              String image, double price, String description) {
        String sql = "INSERT INTO [product] (product_name, barcode, product_type, amount, "
                + "image, price, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect()) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // Set the values
                pstmt.setString(1, product_name);
                pstmt.setString(2, barcode);
                pstmt.setInt(3, product_type);
                pstmt.setInt(4, amount);
                pstmt.setBytes(5, readFile(image));
                pstmt.setDouble(6, price);
                pstmt.setString(7, description);

                // Execute query
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Query data from [product] table and print out in console
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void selectProducts() {
        String sql = "SELECT * FROM [product]";

        try (Connection conn = this.connect()) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {

                    // loop through the result set
                    while (rs.next()) {
                        System.out.println(rs.getInt("product_id") + "\t" +
                                rs.getString("barcode") + "\t" +
                                rs.getString("product_name") + "\t" +
                                rs.getInt("product_type") + "\t" +
                                rs.getInt("amount") + "\t" +
                                rs.getBytes("image") + "\t" +
                                rs.getString("datetime") + "\t" +
                                rs.getDouble("price") + "\t" +
                                rs.getString("description")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Check if a product with specified barcode at @param exists in the database
     * 
     * @param barcode
     * @return 
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean productExists(String barcode) {
        String sql;
        sql = "SELECT barcode FROM [product] where barcode = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values
            pstmt.setString(1, barcode);

            ResultSet resultset = pstmt.executeQuery();
            
            while (resultset.next()) {
                if (resultset.getString("barcode") != null) {
                    return true;
                }
            }
            
            // Execute query
            pstmt.executeUpdate();
        } catch (SQLException ex) {}
        
        return false;
    }
}
