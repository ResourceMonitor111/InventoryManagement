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

public class Bill_Of_MaterialsCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression amount_arrived;
	public final TimestampExpression datetime_added;
	public final StringExpression delivered_by;
	public final IntegerExpression contact_number;
	public final IntegerExpression productproductId;
	public final AssociationExpression productproduct;
	
	public Bill_Of_MaterialsCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		amount_arrived = new IntegerExpression("amount_arrived", this);
		datetime_added = new TimestampExpression("datetime_added", this);
		delivered_by = new StringExpression("delivered_by", this);
		contact_number = new IntegerExpression("contact_number", this);
		productproductId = new IntegerExpression("productproduct.product_id", this);
		productproduct = new AssociationExpression("productproduct", this);
	}
	
	public Bill_Of_MaterialsCriteria(PersistentSession session) {
		this(session.createCriteria(Bill_Of_Materials.class));
	}
	
	public Bill_Of_MaterialsCriteria() throws PersistentException {
		this(AndroidscanappPersistentManager.instance().getSession());
	}
	
	public ProductCriteria createProductproductCriteria() {
		return new ProductCriteria(createCriteria("productproduct"));
	}
	
	public Bill_Of_Materials uniqueBill_Of_Materials() {
		return (Bill_Of_Materials) super.uniqueResult();
	}
	
	public Bill_Of_Materials[] listBill_Of_Materials() {
		java.util.List list = super.list();
		return (Bill_Of_Materials[]) list.toArray(new Bill_Of_Materials[list.size()]);
	}
}

