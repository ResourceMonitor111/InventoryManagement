package main;

import java.util.Arrays;

/**
 * Created by metl on 18.08.2017.
 */

public class Product {

    //private variables
    int product_id;
    String barcode;
    String name;
    String productType;
    int amount;
    String datetimeModified;
    double price;
    String description;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDatetimeModified() {
        return datetimeModified;
    }

    public void setDatetimeModified(String datetimeModified) {
        this.datetimeModified = datetimeModified;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {}
    public Product(int product_id, String barcode, String name, String productType, int amount, String datetimeModified, double price, String description) {
        this.product_id = product_id;
        this.barcode = barcode;
        this.name = name;
        this.productType = productType;
        this.amount = amount;
        this.datetimeModified = datetimeModified;
        this.price = price;
        this.description = description;
    }



    @Override
    public String toString() {
        return "Product{" +
                "_id=" + product_id +
                ", barcode='" + barcode + '\'' +
                ", product_name='" + name + '\'' +
                ", product_type='" + productType + '\'' +
                ", amount=" + amount +
                ", datetime='" + datetimeModified + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}