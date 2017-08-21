package sql;
public class BillOfMaterials {

    private int id;
    private int amountArrived;
    private String datetimeAdded;
    private String deliveredBy;
    private int contactNumber;
    private int productId;

    public BillOfMaterials(int id,
                             int amountArrived,
                             String deliveredBy,
                             String datetimeAdded,
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
                "id='" + id + '\'' +
                ", amountArrived=" + amountArrived +
                ", datetimeAdded='" + datetimeAdded + '\'' +
                ", deliveredBy=" + deliveredBy +
                ", contactNumber=" + contactNumber +
                ", productId='" + productId + '\'' +
                '}';
    }
}
