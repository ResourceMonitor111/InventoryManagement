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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ShopTransactionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression _transaction_id;
	public final TimestampExpression datetime_created;
	public final IntegerExpression clerkClerkId;
	public final AssociationExpression clerkClerk;
	public final CollectionExpression productTransaction;
	
	public ShopTransactionDetachedCriteria() {
		super(ShopTransaction.class, ShopTransactionCriteria.class);
		_transaction_id = new IntegerExpression("_transaction_id", this.getDetachedCriteria());
		datetime_created = new TimestampExpression("datetime_created", this.getDetachedCriteria());
		clerkClerkId = new IntegerExpression("clerkClerk.clerk_id", this.getDetachedCriteria());
		clerkClerk = new AssociationExpression("clerkClerk", this.getDetachedCriteria());
		productTransaction = new CollectionExpression("ORM_ProductTransaction", this.getDetachedCriteria());
	}
	
	public ShopTransactionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ShopTransactionCriteria.class);
		_transaction_id = new IntegerExpression("_transaction_id", this.getDetachedCriteria());
		datetime_created = new TimestampExpression("datetime_created", this.getDetachedCriteria());
		clerkClerkId = new IntegerExpression("clerkClerk.clerk_id", this.getDetachedCriteria());
		clerkClerk = new AssociationExpression("clerkClerk", this.getDetachedCriteria());
		productTransaction = new CollectionExpression("ORM_ProductTransaction", this.getDetachedCriteria());
	}
	
	public ClerkDetachedCriteria createClerkClerkCriteria() {
		return new ClerkDetachedCriteria(createCriteria("clerkClerk"));
	}
	
	public ProductTransactionDetachedCriteria createProductTransactionCriteria() {
		return new ProductTransactionDetachedCriteria(createCriteria("ORM_ProductTransaction"));
	}
	
	public ShopTransaction uniqueShopTransaction(PersistentSession session) {
		return (ShopTransaction) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ShopTransaction[] listShopTransaction(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ShopTransaction[]) list.toArray(new ShopTransaction[list.size()]);
	}
}

