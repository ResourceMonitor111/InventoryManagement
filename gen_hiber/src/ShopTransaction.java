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

public class ShopTransaction {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(ShopTransaction.class);
	public ShopTransaction() {
	}
	
	public static ShopTransaction loadShopTransactionByORMID(int _transaction_id) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadShopTransactionByORMID(session, _transaction_id);
		}
		catch (Exception e) {
			_logger.error("loadShopTransactionByORMID(int _transaction_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction getShopTransactionByORMID(int _transaction_id) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return getShopTransactionByORMID(session, _transaction_id);
		}
		catch (Exception e) {
			_logger.error("getShopTransactionByORMID(int _transaction_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction loadShopTransactionByORMID(int _transaction_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadShopTransactionByORMID(session, _transaction_id, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadShopTransactionByORMID(int _transaction_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction getShopTransactionByORMID(int _transaction_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return getShopTransactionByORMID(session, _transaction_id, lockMode);
		}
		catch (Exception e) {
			_logger.error("getShopTransactionByORMID(int _transaction_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction loadShopTransactionByORMID(PersistentSession session, int _transaction_id) throws PersistentException {
		try {
			return (ShopTransaction) session.load(ShopTransaction.class, new Integer(_transaction_id));
		}
		catch (Exception e) {
			_logger.error("loadShopTransactionByORMID(PersistentSession session, int _transaction_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction getShopTransactionByORMID(PersistentSession session, int _transaction_id) throws PersistentException {
		try {
			return (ShopTransaction) session.get(ShopTransaction.class, new Integer(_transaction_id));
		}
		catch (Exception e) {
			_logger.error("getShopTransactionByORMID(PersistentSession session, int _transaction_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction loadShopTransactionByORMID(PersistentSession session, int _transaction_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ShopTransaction) session.load(ShopTransaction.class, new Integer(_transaction_id), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadShopTransactionByORMID(PersistentSession session, int _transaction_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction getShopTransactionByORMID(PersistentSession session, int _transaction_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ShopTransaction) session.get(ShopTransaction.class, new Integer(_transaction_id), lockMode);
		}
		catch (Exception e) {
			_logger.error("getShopTransactionByORMID(PersistentSession session, int _transaction_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryShopTransaction(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return queryShopTransaction(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryShopTransaction(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryShopTransaction(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return queryShopTransaction(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryShopTransaction(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction[] listShopTransactionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return listShopTransactionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listShopTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction[] listShopTransactionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return listShopTransactionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listShopTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryShopTransaction(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ShopTransaction as ShopTransaction");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listShopTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryShopTransaction(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ShopTransaction as ShopTransaction");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ShopTransaction", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listShopTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction[] listShopTransactionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryShopTransaction(session, condition, orderBy);
			return (ShopTransaction[]) list.toArray(new ShopTransaction[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listShopTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction[] listShopTransactionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryShopTransaction(session, condition, orderBy, lockMode);
			return (ShopTransaction[]) list.toArray(new ShopTransaction[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listShopTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction loadShopTransactionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadShopTransactionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadShopTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction loadShopTransactionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadShopTransactionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadShopTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction loadShopTransactionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ShopTransaction[] shopTransactions = listShopTransactionByQuery(session, condition, orderBy);
		if (shopTransactions != null && shopTransactions.length > 0)
			return shopTransactions[0];
		else
			return null;
	}
	
	public static ShopTransaction loadShopTransactionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ShopTransaction[] shopTransactions = listShopTransactionByQuery(session, condition, orderBy, lockMode);
		if (shopTransactions != null && shopTransactions.length > 0)
			return shopTransactions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateShopTransactionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return iterateShopTransactionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateShopTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateShopTransactionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return iterateShopTransactionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateShopTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateShopTransactionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ShopTransaction as ShopTransaction");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateShopTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateShopTransactionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ShopTransaction as ShopTransaction");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ShopTransaction", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateShopTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ShopTransaction loadShopTransactionByCriteria(ShopTransactionCriteria shopTransactionCriteria) {
		ShopTransaction[] shopTransactions = listShopTransactionByCriteria(shopTransactionCriteria);
		if(shopTransactions == null || shopTransactions.length == 0) {
			return null;
		}
		return shopTransactions[0];
	}
	
	public static ShopTransaction[] listShopTransactionByCriteria(ShopTransactionCriteria shopTransactionCriteria) {
		return shopTransactionCriteria.listShopTransaction();
	}
	
	public static ShopTransaction createShopTransaction() {
		return new ShopTransaction();
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
			if(getClerkClerk() != null) {
				getClerkClerk().shopTransaction.remove(this);
			}
			
			ProductTransaction[] lProductTransactions = productTransaction.toArray();
			for(int i = 0; i < lProductTransactions.length; i++) {
				lProductTransactions[i].setTransaction_transaction(null);
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
			if(getClerkClerk() != null) {
				getClerkClerk().shopTransaction.remove(this);
			}
			
			ProductTransaction[] lProductTransactions = productTransaction.toArray();
			for(int i = 0; i < lProductTransactions.length; i++) {
				lProductTransactions[i].setTransaction_transaction(null);
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
		if (key == ORMConstants.KEY_SHOPTRANSACTION_PRODUCTTRANSACTION) {
			return ORM_productTransaction;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_SHOPTRANSACTION_CLERKCLERK) {
			this.clerkClerk = (Clerk) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int _transaction_id;
	
	private java.sql.Timestamp datetime_created;
	
	private Clerk clerkClerk;
	
	private java.util.Set ORM_productTransaction = new java.util.HashSet();
	
	private void set_transaction_id(int value) {
		this._transaction_id = value;
	}
	
	public int get_transaction_id() {
		return _transaction_id;
	}
	
	public int getORMID() {
		return get_transaction_id();
	}
	
	public void setDatetime_created(java.sql.Timestamp value) {
		this.datetime_created = value;
	}
	
	public java.sql.Timestamp getDatetime_created() {
		return datetime_created;
	}
	
	public void setClerkClerk(Clerk value) {
		if (clerkClerk != null) {
			clerkClerk.shopTransaction.remove(this);
		}
		if (value != null) {
			value.shopTransaction.add(this);
		}
	}
	
	public Clerk getClerkClerk() {
		return clerkClerk;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_ClerkClerk(Clerk value) {
		this.clerkClerk = value;
	}
	
	private Clerk getORM_ClerkClerk() {
		return clerkClerk;
	}
	
	private void setORM_ProductTransaction(java.util.Set value) {
		this.ORM_productTransaction = value;
	}
	
	private java.util.Set getORM_ProductTransaction() {
		return ORM_productTransaction;
	}
	
	public final ProductTransactionSetCollection productTransaction = new ProductTransactionSetCollection(this, _ormAdapter, ORMConstants.KEY_SHOPTRANSACTION_PRODUCTTRANSACTION, ORMConstants.KEY_PRODUCTTRANSACTION_TRANSACTION_TRANSACTION, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(get_transaction_id());
	}
	
}
