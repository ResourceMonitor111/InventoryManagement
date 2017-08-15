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

public class ProductTransactionCriteria extends AbstractORMCriteria {
	public final IntegerExpression sold_amount;
	public final IntegerExpression productproductId;
	public final AssociationExpression productproduct;
	public final IntegerExpression transaction_transactionId;
	public final AssociationExpression transaction_transaction;
	
	public ProductTransactionCriteria(Criteria criteria) {
		super(criteria);
		sold_amount = new IntegerExpression("sold_amount", this);
		productproductId = new IntegerExpression("ORM_Productproduct.product_id", this);
		productproduct = new AssociationExpression("ORM_Productproduct", this);
		transaction_transactionId = new IntegerExpression("ORM_Transaction_transaction._transaction_id", this);
		transaction_transaction = new AssociationExpression("ORM_Transaction_transaction", this);
	}
	
	public ProductTransactionCriteria(PersistentSession session) {
		this(session.createCriteria(ProductTransaction.class));
	}
	
	public ProductTransactionCriteria() throws PersistentException {
		this(AndroidscanappPersistentManager.instance().getSession());
	}
	
	public ProductCriteria createProductproductCriteria() {
		return new ProductCriteria(createCriteria("ORM_Productproduct"));
	}
	
	public ShopTransactionCriteria createTransaction_transactionCriteria() {
		return new ShopTransactionCriteria(createCriteria("ORM_Transaction_transaction"));
	}
	
	public ProductTransaction uniqueProductTransaction() {
		return (ProductTransaction) super.uniqueResult();
	}
	
	public ProductTransaction[] listProductTransaction() {
		java.util.List list = super.list();
		return (ProductTransaction[]) list.toArray(new ProductTransaction[list.size()]);
	}
}

