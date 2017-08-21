package sql;

/**
 * Created by kirillsuvorov on 17/08/2017.
 */

public class ProductTransaction {
    private int soldAmount;
    private int productid;
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
