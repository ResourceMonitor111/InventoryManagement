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
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class Clerk {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Clerk.class);
	public Clerk() {
	}
	
	public static Clerk loadClerkByORMID(int clerk_id) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadClerkByORMID(session, clerk_id);
		}
		catch (Exception e) {
			_logger.error("loadClerkByORMID(int clerk_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk getClerkByORMID(int clerk_id) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return getClerkByORMID(session, clerk_id);
		}
		catch (Exception e) {
			_logger.error("getClerkByORMID(int clerk_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk loadClerkByORMID(int clerk_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadClerkByORMID(session, clerk_id, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadClerkByORMID(int clerk_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk getClerkByORMID(int clerk_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return getClerkByORMID(session, clerk_id, lockMode);
		}
		catch (Exception e) {
			_logger.error("getClerkByORMID(int clerk_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk loadClerkByORMID(PersistentSession session, int clerk_id) throws PersistentException {
		try {
			return (Clerk) session.load(Clerk.class, new Integer(clerk_id));
		}
		catch (Exception e) {
			_logger.error("loadClerkByORMID(PersistentSession session, int clerk_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk getClerkByORMID(PersistentSession session, int clerk_id) throws PersistentException {
		try {
			return (Clerk) session.get(Clerk.class, new Integer(clerk_id));
		}
		catch (Exception e) {
			_logger.error("getClerkByORMID(PersistentSession session, int clerk_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk loadClerkByORMID(PersistentSession session, int clerk_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Clerk) session.load(Clerk.class, new Integer(clerk_id), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadClerkByORMID(PersistentSession session, int clerk_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk getClerkByORMID(PersistentSession session, int clerk_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Clerk) session.get(Clerk.class, new Integer(clerk_id), lockMode);
		}
		catch (Exception e) {
			_logger.error("getClerkByORMID(PersistentSession session, int clerk_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryClerk(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return queryClerk(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryClerk(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryClerk(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return queryClerk(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryClerk(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk[] listClerkByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return listClerkByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listClerkByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk[] listClerkByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return listClerkByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listClerkByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryClerk(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Clerk as Clerk");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listClerkByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryClerk(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Clerk as Clerk");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Clerk", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listClerkByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk[] listClerkByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryClerk(session, condition, orderBy);
			return (Clerk[]) list.toArray(new Clerk[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listClerkByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk[] listClerkByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryClerk(session, condition, orderBy, lockMode);
			return (Clerk[]) list.toArray(new Clerk[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listClerkByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk loadClerkByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadClerkByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadClerkByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk loadClerkByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadClerkByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadClerkByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk loadClerkByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Clerk[] clerks = listClerkByQuery(session, condition, orderBy);
		if (clerks != null && clerks.length > 0)
			return clerks[0];
		else
			return null;
	}
	
	public static Clerk loadClerkByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Clerk[] clerks = listClerkByQuery(session, condition, orderBy, lockMode);
		if (clerks != null && clerks.length > 0)
			return clerks[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateClerkByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return iterateClerkByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateClerkByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateClerkByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return iterateClerkByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateClerkByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateClerkByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Clerk as Clerk");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateClerkByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateClerkByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Clerk as Clerk");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Clerk", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateClerkByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Clerk loadClerkByCriteria(ClerkCriteria clerkCriteria) {
		Clerk[] clerks = listClerkByCriteria(clerkCriteria);
		if(clerks == null || clerks.length == 0) {
			return null;
		}
		return clerks[0];
	}
	
	public static Clerk[] listClerkByCriteria(ClerkCriteria clerkCriteria) {
		return clerkCriteria.listClerk();
	}
	
	public static Clerk createClerk() {
		return new Clerk();
	}
	
	public boolean save() throws PersistentException {
		try {
			AndroidscanappPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			_logger.error("save()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			AndroidscanappPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			AndroidscanappPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			AndroidscanappPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			ShopTransaction[] lShopTransactions = shopTransaction.toArray();
			for(int i = 0; i < lShopTransactions.length; i++) {
				lShopTransactions[i].setClerkClerk(null);
			}
			return delete();
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			ShopTransaction[] lShopTransactions = shopTransaction.toArray();
			for(int i = 0; i < lShopTransactions.length; i++) {
				lShopTransactions[i].setClerkClerk(null);
			}
			try {
				session.delete(this);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate(org.orm.PersistentSession session)", e);
			throw new PersistentException(e);
		}
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CLERK_SHOPTRANSACTION) {
			return ORM_shopTransaction;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int clerk_id;
	
	private String firstname;
	
	private String lastname;
	
	private Integer contact_number;
	
	private String email;
	
	private java.util.Set ORM_shopTransaction = new java.util.HashSet();
	
	private void setClerk_id(int value) {
		this.clerk_id = value;
	}
	
	public int getClerk_id() {
		return clerk_id;
	}
	
	public int getORMID() {
		return getClerk_id();
	}
	
	public void setFirstname(String value) {
		this.firstname = value;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setLastname(String value) {
		this.lastname = value;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setContact_number(int value) {
		setContact_number(new Integer(value));
	}
	
	public void setContact_number(Integer value) {
		this.contact_number = value;
	}
	
	public Integer getContact_number() {
		return contact_number;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	private void setORM_ShopTransaction(java.util.Set value) {
		this.ORM_shopTransaction = value;
	}
	
	private java.util.Set getORM_ShopTransaction() {
		return ORM_shopTransaction;
	}
	
	public final ShopTransactionSetCollection shopTransaction = new ShopTransactionSetCollection(this, _ormAdapter, ORMConstants.KEY_CLERK_SHOPTRANSACTION, ORMConstants.KEY_SHOPTRANSACTION_CLERKCLERK, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getClerk_id());
	}
	
}
