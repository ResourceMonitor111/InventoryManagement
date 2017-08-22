package main;


public class ProductTransaction {
    private int soldAmount;
    private int productId;
    private int transactionId;

    public ProductTransaction() {}

    public ProductTransaction(int soldAmount, int productId, int transactionId) {
        this.soldAmount = soldAmount;
        this.productId = productId;
        this.transactionId = transactionId;
    }

    public int getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(int soldAmount) {
        this.soldAmount = soldAmount;
    }

    public int getProductid() {
        return productId;
    }

    public void setProductid(int productId) {
        this.productId = productId;
    }

    public int getTransactionid() {
        return transactionId;
    }

    public void setTransactionid(int transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "ProductTransaction{" +
                "soldAmount='" + soldAmount + '\'' +
                ", productid=" + productId +
                ", transactionid='" + transactionId + '\'' +
                '}';
    }
}
