package sql;
import java.sql.Timestamp;
public class Product {
    java.util.Date date;
    private String barcode;
    private String productName;
    private String productType;
    private int productAmount;
    private String productImage; //FIXME SerialBlob
    private Timestamp datetimeModified;
    private double productPrice; //FIXME BigDecimal or Money
    private String productDescription;


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

    @Override
    public String toString() {
        return "Product{" + "barcode='" + barcode + '\'' + ", productName=" + productName + ", productType='" + productType + '\'' + ", productAmount=" + productAmount + ", productImage='" + productImage + '\'' + ", datetimeModified='" + datetimeModified +'\'' + ", productPrice=" + productPrice + '}';
    }
}