package main;

public class ShopTransaction {
    private int _transaction_id;
    private String datetimeCreated;
    private int Clerk_id;

    public ShopTransaction(){}

    public ShopTransaction(int transaction_id, String datetimeCreated, int Clerk_id){
        _transaction_id = transaction_id;
        this.datetimeCreated = datetimeCreated;
        this.Clerk_id = Clerk_id;
    }

    public int get_transaction_id() {
        return _transaction_id;
    }

    public void set_transaction_id(int _transaction_id) {
        this._transaction_id = _transaction_id;
    }

    public String getDatetimeCreated() {
        return datetimeCreated;
    }

    public void setDatetimeCreated(String datetimeCreated) { this.datetimeCreated = datetimeCreated; }

    public int getClerk_id() {
        return Clerk_id;
    }

    public void setClerk_id(int clerk_id) {
        Clerk_id = clerk_id;
    }

    public String toString() {
        return "ShopTransaction{" +
                "Clerk_id='" + Clerk_id + '\'' +
                ", _transaction_id=" + _transaction_id +
                ", datetimeCreated='" + datetimeCreated + '\'' +
                ", Clerk_id=" + Clerk_id +
                '}';
    }
}
