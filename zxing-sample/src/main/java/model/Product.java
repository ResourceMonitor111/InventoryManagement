package model;
import java.sql.Timestamp;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Product {
    java.util.Date date;
    @DatabaseField(generatedId = true, columnName = "product_id")
    private int product_id;
    @DatabaseField(canBeNull = false, columnName = "barcode", unique = true)
    private String barcode;
    @DatabaseField(canBeNull = false, unique = true, columnName = "name")
    private String productName;
    @DatabaseField(canBeNull = true, unique = false, columnName = "productType")
    private String productType;
    @DatabaseField(canBeNull = false, unique = false, columnName = "amount")
    private int productAmount;
    @DatabaseField(canBeNull = true, unique = true, columnName = "image")
    private String productImage; //FIXME SerialBlob or byte[]
    @DatabaseField(canBeNull = false, columnName = "datetimeModified")
    private Timestamp datetimeModified;
    @DatabaseField(canBeNull = true, columnName = "price")
    private double productPrice; //FIXME BigDecimal or Money
    @DatabaseField(canBeNull = true,  columnName = "description")
    private String productDescription;

    public Product(){
        //empty constructor, required by ORMLite
    }
    public Product(String barcode, String productName, String productType, int productAmount, double productPrice, String productImage, String productDescription) {
        this.barcode = barcode;
        this.productName = productName;
        this.productType = productType;
        this.productAmount = productAmount;
        this.productImage = productImage;
        this.datetimeModified = new Timestamp(date.getTime()); // FIXME date.getTime()
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }


    public Timestamp getDatetimeModified() {
        return datetimeModified;
    }

    public void setDatetimeModified(Timestamp datetimeModified) {
        this.datetimeModified = datetimeModified;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    /*public int save(Repo repo)
    {
        if(repo.Users.getByUsername(username) == null)
        {
            return repo.Users.create(this);
        }
        else
        {
            return repo.Users.update(this);
        }
    }

    public int delete(Repo repo)
    {
        return repo.Users.delete(this);
    }*/

    @Override
    public String toString() {
        return "Product{" + "barcode='" + barcode + '\'' + ", productName=" + productName + ", productType='" + productType + '\'' + ", productAmount=" + productAmount + ", productImage='" + productImage + '\'' + ", datetimeModified='" + datetimeModified +'\'' + ", productPrice=" + productPrice + '}';
    }
}