package com.database.mgmt;

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

/**
 *
 * @author Peteris Caurs
 */
public class SQLiteDB {

    /**
     * Connect to the ScaneristDB.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // Create an object that will represent the database
        Connection connection = null;

        // SQLite connection string
        String url = "jdbc:sqlite:ScaneristDB.db";
        try {
            // Create a connection to the database
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
     * Read the picture file and insert into the material master table
     *
     * @param materialId
     * @param filename
     */
    public void readImage(int product_id, String image) {
        // update sql
        String selectSQL = "SELECT image FROM Product WHERE product_id = ?";
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
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
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

            } catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Insert new record into Product table. Field 'datetime_modified' is
     * current time in GMT.
     *
     * @param name
     * @param productType
     * @param amount
     * @param image path to image
     * @param billOfMaterialsId
     * @param price
     */
    public void insertProduct(String name, int productType, int amount,
            String image, int billOfMaterialsId, double price) {
        String sql = "INSERT INTO Product (name, product_type, amount, "
                + "image, datetime_modified, Bill_Of_Materialsid, price) VALUES (?, ?, ?, ?, datetime('now'), ?, ?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values
            pstmt.setString(1, name);
            pstmt.setInt(2, productType);
            pstmt.setInt(3, amount);
            pstmt.setBytes(4, readFile(image));
            pstmt.setInt(5, billOfMaterialsId);
            pstmt.setDouble(6, price);

            // Execute query
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
