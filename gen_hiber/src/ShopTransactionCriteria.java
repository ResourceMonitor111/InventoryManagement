/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ShopTransactionCriteria extends AbstractORMCriteria {
	public final IntegerExpression _transaction_id;
	public final TimestampExpression datetime_created;
	public final IntegerExpression clerkClerkId;
	public final AssociationExpression clerkClerk;
	public final CollectionExpression productTransaction;
	
	public ShopTransactionCriteria(Criteria criteria) {
		super(criteria);
		_transaction_id = new IntegerExpression("_transaction_id", this);
		datetime_created = new TimestampExpression("datetime_created", this);
		clerkClerkId = new IntegerExpression("clerkClerk.clerk_id", this);
		clerkClerk = new AssociationExpression("clerkClerk", this);
		productTransaction = new CollectionExpression("ORM_ProductTransaction", this);
	}
	
	public ShopTransactionCriteria(PersistentSession session) {
		this(session.createCriteria(ShopTransaction.class));
	}
	
	public ShopTransactionCriteria() throws PersistentException {
		this(AndroidscanappPersistentManager.instance().getSession());
	}
	
	public ClerkCriteria createClerkClerkCriteria() {
		return new ClerkCriteria(createCriteria("clerkClerk"));
	}
	
	public ProductTransactionCriteria createProductTransactionCriteria() {
		return new ProductTransactionCriteria(createCriteria("ORM_ProductTransaction"));
	}
	
	public ShopTransaction uniqueShopTransaction() {
		return (ShopTransaction) super.uniqueResult();
	}
	
	public ShopTransaction[] listShopTransaction() {
		java.util.List list = super.list();
		return (ShopTransaction[]) list.toArray(new ShopTransaction[list.size()]);
	}
}

