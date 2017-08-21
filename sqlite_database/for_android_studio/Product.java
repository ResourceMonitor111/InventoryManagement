package com.caurs.peteris.sqliteproject;

import java.util.Arrays;

/**
 * Created by metl on 18.08.2017.
 */

public class Product {

    //private variables
    int _id;
    String barcode;
    String product_name;
    String product_type;
    int amount;
    byte[] image;
    String datetime;
    double price;


    String description;

    /**
     * No-arg constructor
     */
    public Product() {}

    /**
     * Creates a new product
     * @param _id
     * @param barcode
     * @param product_name
     * @param product_type
     * @param amount
     * @param image
     * @param datetime
     * @param price
     * @param description
     */
    public Product(int _id, String barcode, String product_name, String product_type, int amount, byte[] image, String datetime, double price, String description) {
        this._id = _id;
        this.barcode = barcode;
        this.product_name = product_name;
        this.product_type = product_type;
        this.amount = amount;
        this.image = image;
        this.datetime = datetime;
        this.price = price;
        this.description = description;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
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

    @Override
    public String toString() {
        return "Product{" +
                "_id=" + _id +
                ", barcode='" + barcode + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_type='" + product_type + '\'' +
                ", amount=" + amount +
                ", image=" + Arrays.toString(image) +
                ", datetime='" + datetime + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
