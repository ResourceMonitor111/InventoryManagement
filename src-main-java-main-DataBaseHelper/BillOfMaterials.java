package main;

import java.security.Timestamp;
import java.util.Arrays;

/**
 * Created by metl on 18.08.2017.
 */

public class BillOfMaterials {

    //private variables
    int id;
    int amountArrived;
    String datetimeAdded;
    String deliveredBy;
    int contactNumber;
    int productId;


    /**
     * No-arg constructor
     */
    public BillOfMaterials() {}

    /**
     * Creates a new product
     * @param id
     * @param amountArrived
     * @param datetimeAdded
     * @param deliveredBy
     * @param contactNumber
     * @param productId
     */
    public BillOfMaterials(int id, int amountArrived, String datetimeAdded, String deliveredBy, int contactNumber, int productId) {
        this.id = id;
        this.amountArrived = amountArrived;
        this.datetimeAdded = datetimeAdded;
        this.deliveredBy = deliveredBy;
        this.contactNumber = contactNumber;
        this.productId = productId;
    }

    public int get_id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public int getAmountArrived() {
        return amountArrived;
    }

    public void setAmountArrived(int amountArrived) {
        this.amountArrived = amountArrived;
    }

    public String getDatetimeAdded() {
        return datetimeAdded;
    }

    public void setDatetimeAdded(String datetimeAdded) {
        this.datetimeAdded = datetimeAdded;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "BillOfMaterials{" +
                ", id=" + id +
                ", amountArrived=" + amountArrived +
                ", datetimeAdded='" + datetimeAdded + '\'' +
                ", deliveredBy=" + deliveredBy +
                ", contactNumber=" + contactNumber +
                ", productId='" + productId + '\'' +
                '}';
    }
}