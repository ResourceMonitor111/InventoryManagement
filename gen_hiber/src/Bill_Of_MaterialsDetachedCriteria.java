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

public class Bill_Of_MaterialsDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression amount_arrived;
	public final TimestampExpression datetime_added;
	public final StringExpression delivered_by;
	public final IntegerExpression contact_number;
	public final IntegerExpression productproductId;
	public final AssociationExpression productproduct;
	
	public Bill_Of_MaterialsDetachedCriteria() {
		super(Bill_Of_Materials.class, Bill_Of_MaterialsCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		amount_arrived = new IntegerExpression("amount_arrived", this.getDetachedCriteria());
		datetime_added = new TimestampExpression("datetime_added", this.getDetachedCriteria());
		delivered_by = new StringExpression("delivered_by", this.getDetachedCriteria());
		contact_number = new IntegerExpression("contact_number", this.getDetachedCriteria());
		productproductId = new IntegerExpression("productproduct.product_id", this.getDetachedCriteria());
		productproduct = new AssociationExpression("productproduct", this.getDetachedCriteria());
	}
	
	public Bill_Of_MaterialsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, Bill_Of_MaterialsCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		amount_arrived = new IntegerExpression("amount_arrived", this.getDetachedCriteria());
		datetime_added = new TimestampExpression("datetime_added", this.getDetachedCriteria());
		delivered_by = new StringExpression("delivered_by", this.getDetachedCriteria());
		contact_number = new IntegerExpression("contact_number", this.getDetachedCriteria());
		productproductId = new IntegerExpression("productproduct.product_id", this.getDetachedCriteria());
		productproduct = new AssociationExpression("productproduct", this.getDetachedCriteria());
	}
	
	public ProductDetachedCriteria createProductproductCriteria() {
		return new ProductDetachedCriteria(createCriteria("productproduct"));
	}
	
	public Bill_Of_Materials uniqueBill_Of_Materials(PersistentSession session) {
		return (Bill_Of_Materials) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Bill_Of_Materials[] listBill_Of_Materials(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Bill_Of_Materials[]) list.toArray(new Bill_Of_Materials[list.size()]);
	}
}

