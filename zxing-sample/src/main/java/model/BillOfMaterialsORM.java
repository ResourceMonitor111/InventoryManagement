package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.security.Timestamp;


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
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignColumnName = "productId")
    private int productId;

    public BillOfMaterialsORM(int id,
                           int amountArrived,
                           String deliveredBy,
                           Timestamp datetimeAdded,
                           int contactNumber,
                              int productId) {
        this.id = id;
        this.productId = productId;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "BillOfMaterials{" +
                "id='" + id + '\'' +
                ", amountArrived=" + amountArrived +
                ", datetimeAdded='" + datetimeAdded + '\'' +
                ", deliveredBy=" + deliveredBy +
                ", contactNumber=" + contactNumber +
                ", productId='" + productId + '\'' +
                '}';
    }
}

