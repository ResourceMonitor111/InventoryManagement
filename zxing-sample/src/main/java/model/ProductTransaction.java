package model;

/**
 * Created by kirillsuvorov on 17/08/2017.
 */
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ProductTransaction {
    @DatabaseField(canBeNull = false, unique = false, columnName = "soldAmount")
    private int soldAmount;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignColumnName = "productid")
    private int productid;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignColumnName = "transactionid")
    private int transactionid;

    public ProductTransaction(int soldAmount, int productid, int transactionid) {
        this.soldAmount = soldAmount;
        this.productid = productid;
        this.transactionid = transactionid;
    }

    public int getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(int soldAmount) {
        this.soldAmount = soldAmount;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }

    @Override
    public String toString() {
        return "ProductTransaction{" +
                "soldAmount='" + soldAmount + '\'' +
                ", productid=" + productid +
                ", transactionid='" + transactionid + '\'' +
                '}';
    }
}
