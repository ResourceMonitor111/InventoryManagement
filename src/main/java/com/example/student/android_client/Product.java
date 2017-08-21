package com.example.student.android_client;

/**
 * Created by student on 17.21.8.
 */

public class Product {
    private int product_id;
    private String barCode;
    private String productName;
    private String productType;
    private int amount;
    private String datetime;
    private double price;
    private String description;


    public Product(int product_id, String barCode, String productName, String productType, int amount,
                   String datetime, double price, String description) {
        super();
        this.product_id = product_id;
        this.barCode = barCode;
        this.productName = productName;
        this.productType = productType;
        this.amount = amount;
        this.datetime = datetime;
        this.price = price;
        this.description = description;
    }

    public Product(){
        super();
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public int getAmount() {
        return amount;
    }

    public String getDatetime() {
        return datetime;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
