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

public class ProductTransactionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression sold_amount;
	public final IntegerExpression productproductId;
	public final AssociationExpression productproduct;
	public final IntegerExpression transaction_transactionId;
	public final AssociationExpression transaction_transaction;
	
	public ProductTransactionDetachedCriteria() {
		super(ProductTransaction.class, ProductTransactionCriteria.class);
		sold_amount = new IntegerExpression("sold_amount", this.getDetachedCriteria());
		productproductId = new IntegerExpression("ORM_Productproduct.product_id", this.getDetachedCriteria());
		productproduct = new AssociationExpression("ORM_Productproduct", this.getDetachedCriteria());
		transaction_transactionId = new IntegerExpression("ORM_Transaction_transaction._transaction_id", this.getDetachedCriteria());
		transaction_transaction = new AssociationExpression("ORM_Transaction_transaction", this.getDetachedCriteria());
	}
	
	public ProductTransactionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ProductTransactionCriteria.class);
		sold_amount = new IntegerExpression("sold_amount", this.getDetachedCriteria());
		productproductId = new IntegerExpression("ORM_Productproduct.product_id", this.getDetachedCriteria());
		productproduct = new AssociationExpression("ORM_Productproduct", this.getDetachedCriteria());
		transaction_transactionId = new IntegerExpression("ORM_Transaction_transaction._transaction_id", this.getDetachedCriteria());
		transaction_transaction = new AssociationExpression("ORM_Transaction_transaction", this.getDetachedCriteria());
	}
	
	public ProductDetachedCriteria createProductproductCriteria() {
		return new ProductDetachedCriteria(createCriteria("ORM_Productproduct"));
	}
	
	public ShopTransactionDetachedCriteria createTransaction_transactionCriteria() {
		return new ShopTransactionDetachedCriteria(createCriteria("ORM_Transaction_transaction"));
	}
	
	public ProductTransaction uniqueProductTransaction(PersistentSession session) {
		return (ProductTransaction) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ProductTransaction[] listProductTransaction(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ProductTransaction[]) list.toArray(new ProductTransaction[list.size()]);
	}
}

