package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Timestamp;

/**
 * Created by kirillsuvorov on 17/08/2017.
 */
@DatabaseTable
public class ShopTransaction {
    @DatabaseField(generatedId = true, columnName = "_transaction_id")
    private int _transaction_id;
    @DatabaseField(canBeNull = false, unique = false, columnName = "datimeCreated")
    private Timestamp datetimeCreated;
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignColumnName = "Clerk_id")
    private int Clerk_id;

    public ShopTransaction(int transaction_id, Timestamp datetimeCreated, int Clerk_id){
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

    public Timestamp getDatetimeCreated() {
        return datetimeCreated;
    }

    public void setDatetimeCreated(Timestamp datetimeCreated) {
        this.datetimeCreated = datetimeCreated;
    }

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
