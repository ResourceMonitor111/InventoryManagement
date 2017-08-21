package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.security.Timestamp;
import models.Product;


@DatabaseTable
public class BillOfMaterialsORM {

    @DatabaseField(generatedId = true, columnName = "id")
    private int id;
    @DatabaseField(canBeNull = false, unique = false, columnName = "amountArrived")
    private int amountArrived;
    @DatabaseField(canBeNull = false, unique = false, columnName = "datetimeAdded")
    private Timestamp datetimeAdded;
    @DatabaseField(canBeNull = false, unique = false, columnName = "deliveredBy")
    private String deliveredBy;
    @DatabaseField(canBeNull = false, unique = false, columnName = "contactNumber")
    private int contactNumber;
    @DatabaseField(foreign = true, canBeNull = false, unique = false)
    private Product product;

    public BillOfMaterialsORM(int id,
                           int amountArrived,
                           String deliveredBy,
                           Timestamp datetimeAdded,
                           int contactNumber,
                           Product product) {
        this.id = id;
        this.product = product;
        this.contactNumber = contactNumber;
        this.amountArrived = amountArrived;
        this.deliveredBy = deliveredBy;
        this.datetimeAdded = datetimeAdded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountArrived() {
        return amountArrived;
    }

    public void setAmountArrived(int amountArrived) {
        this.amountArrived = amountArrived;
    }

    public Timestamp getDatetimeAdded() {
        return datetimeAdded;
    }

    public void setDatetimeAdded(Timestamp datetimeAdded) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "BillOfMaterials{" +
                "id='" + id + '\'' +
                ", amountArrived=" + amountArrived +
                ", datetimeAdded='" + datetimeAdded + '\'' +
                ", deliveredBy=" + deliveredBy +
                ", contactNumber=" + contactNumber +
                ", productId='" + product + '\'' +
                '}';
    }
}

