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

public class ClerkDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression clerk_id;
	public final StringExpression firstname;
	public final StringExpression lastname;
	public final IntegerExpression contact_number;
	public final StringExpression email;
	public final CollectionExpression shopTransaction;
	
	public ClerkDetachedCriteria() {
		super(Clerk.class, ClerkCriteria.class);
		clerk_id = new IntegerExpression("clerk_id", this.getDetachedCriteria());
		firstname = new StringExpression("firstname", this.getDetachedCriteria());
		lastname = new StringExpression("lastname", this.getDetachedCriteria());
		contact_number = new IntegerExpression("contact_number", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		shopTransaction = new CollectionExpression("ORM_ShopTransaction", this.getDetachedCriteria());
	}
	
	public ClerkDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ClerkCriteria.class);
		clerk_id = new IntegerExpression("clerk_id", this.getDetachedCriteria());
		firstname = new StringExpression("firstname", this.getDetachedCriteria());
		lastname = new StringExpression("lastname", this.getDetachedCriteria());
		contact_number = new IntegerExpression("contact_number", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		shopTransaction = new CollectionExpression("ORM_ShopTransaction", this.getDetachedCriteria());
	}
	
	public ShopTransactionDetachedCriteria createShopTransactionCriteria() {
		return new ShopTransactionDetachedCriteria(createCriteria("ORM_ShopTransaction"));
	}
	
	public Clerk uniqueClerk(PersistentSession session) {
		return (Clerk) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Clerk[] listClerk(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Clerk[]) list.toArray(new Clerk[list.size()]);
	}
}

