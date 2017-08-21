package amber.server;

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
    private static Connection connect() {
        // Create an object that will represent the database
        Connection connection = null;

        // SQLite connection string
        String url = "jdbc:sqlite:ScaneristDB_v4.db";
        try {
            // Create a connection to the database
        	//DriverManager.registerDriver(driver);
        	connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
        	System.out.println("no connection :(");
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
    static private byte[] readFile(String file)
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
        String selectSQL = "SELECT image FROM [Product] WHERE product_id = ?";
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
    static public boolean insertProduct(Product product) {
        String sql = "INSERT INTO [Product] (barcode, name, productType, amount, "
                + "datetimeModified, price, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        if(!productExists(product.barCode)){
	        try (Connection conn = connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	
	            // Set the values
	        	pstmt.setString(1, product.barCode);
	            pstmt.setString(2, product.productName);
	            pstmt.setString(3, product.productType);
	            pstmt.setInt(4, product.amount);
	            pstmt.setString(5,product.datetime);
	            pstmt.setDouble(6, product.price);
	            pstmt.setString(7, product.description);
	
	            // Execute query
	            pstmt.executeUpdate();
	        } catch (SQLException ex) {
	        	System.out.println("fail");
	            System.out.println(ex);
	            return false;
	        }
	        return true;
	    }
        return false;
        
//        catch (IOException ex) {
//        	System.out.println("fail");
//            System.out.println(ex);
//        }
    }

    /**
     * Query data from [product] table and print out in console
     */
    static public void selectProducts() {
        String sql = "SELECT * FROM [Product]";

        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("product_id") +  "\t" +
                                   rs.getString("barcode")  +  "\t" +
                                   rs.getString("name")  +  "\t" +
                                   rs.getString("productType")  +  "\t" +
                                   rs.getInt("amount")  +  "\t" +
                                   rs.getString("datetimeModified")  +  "\t" +
                                   rs.getDouble("price")  +  "\t" +
                                   rs.getString("description")
                );
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
    static public boolean productExists(String barcode) {
        String sql = "SELECT barcode FROM [Product] where barcode = ?";
        try (Connection conn = connect();
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
    
    static public Product findProduct(String barcode){
    	if(productExists(barcode)){
    		String sql="SELECT * FROM [Product] Where barcode = '"+barcode+"'";
    		try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
    			// Set the values
    			ResultSet resultset = pstmt.executeQuery();
                Product product;
                // if (resultset.next()){
            	product=new Product(resultset.getInt(1),resultset.getString(2),resultset.getString(3),
            						resultset.getString(4),resultset.getInt(5),
            						resultset.getString(6),resultset.getLong(7),resultset.getString(8));
            	return product;
            } catch (SQLException ex) {}

    	}
    	return null;
    }
    
    static public boolean changeProductAmount(String barcode,int amount,boolean add){
    	if(productExists(barcode)){
    		int curramount=0;
    		String sql="SELECT amount From [product] Where barcode="+barcode;
    		try (Connection conn = connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {

                   // Set the values

                   ResultSet resultset = pstmt.executeQuery();
                   if(resultset.next()){
                	   curramount=resultset.getInt("amount");
                   }
                   
                   if((add)&&(curramount-amount)<0) return false;
                   if(add) amount=-amount;
                   else{
                	   sql="Update [product] SET amount="+(curramount+amount)+" Where barcode="+barcode;
                	   PreparedStatement pstmt2=conn.prepareStatement(sql);
                	   pstmt2.executeQuery();
                	   return true;
                   }
                   
                   // Execute query
       //            pstmt.executeUpdate();
               } catch (SQLException ex) {}

    	}
    	
    	return false;
    }
}
