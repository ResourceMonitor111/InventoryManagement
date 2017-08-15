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

public class ClerkCriteria extends AbstractORMCriteria {
	public final IntegerExpression clerk_id;
	public final StringExpression firstname;
	public final StringExpression lastname;
	public final IntegerExpression contact_number;
	public final StringExpression email;
	public final CollectionExpression shopTransaction;
	
	public ClerkCriteria(Criteria criteria) {
		super(criteria);
		clerk_id = new IntegerExpression("clerk_id", this);
		firstname = new StringExpression("firstname", this);
		lastname = new StringExpression("lastname", this);
		contact_number = new IntegerExpression("contact_number", this);
		email = new StringExpression("email", this);
		shopTransaction = new CollectionExpression("ORM_ShopTransaction", this);
	}
	
	public ClerkCriteria(PersistentSession session) {
		this(session.createCriteria(Clerk.class));
	}
	
	public ClerkCriteria() throws PersistentException {
		this(AndroidscanappPersistentManager.instance().getSession());
	}
	
	public ShopTransactionCriteria createShopTransactionCriteria() {
		return new ShopTransactionCriteria(createCriteria("ORM_ShopTransaction"));
	}
	
	public Clerk uniqueClerk() {
		return (Clerk) super.uniqueResult();
	}
	
	public Clerk[] listClerk() {
		java.util.List list = super.list();
		return (Clerk[]) list.toArray(new Clerk[list.size()]);
	}
}

