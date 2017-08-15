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

public class Bill_Of_Materials {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Bill_Of_Materials.class);
	public Bill_Of_Materials() {
	}
	
	public static Bill_Of_Materials loadBill_Of_MaterialsByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadBill_Of_MaterialsByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("loadBill_Of_MaterialsByORMID(int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials getBill_Of_MaterialsByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return getBill_Of_MaterialsByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("getBill_Of_MaterialsByORMID(int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials loadBill_Of_MaterialsByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadBill_Of_MaterialsByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadBill_Of_MaterialsByORMID(int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials getBill_Of_MaterialsByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return getBill_Of_MaterialsByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("getBill_Of_MaterialsByORMID(int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials loadBill_Of_MaterialsByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Bill_Of_Materials) session.load(Bill_Of_Materials.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("loadBill_Of_MaterialsByORMID(PersistentSession session, int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials getBill_Of_MaterialsByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Bill_Of_Materials) session.get(Bill_Of_Materials.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("getBill_Of_MaterialsByORMID(PersistentSession session, int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials loadBill_Of_MaterialsByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Bill_Of_Materials) session.load(Bill_Of_Materials.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadBill_Of_MaterialsByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials getBill_Of_MaterialsByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Bill_Of_Materials) session.get(Bill_Of_Materials.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("getBill_Of_MaterialsByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryBill_Of_Materials(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return queryBill_Of_Materials(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryBill_Of_Materials(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryBill_Of_Materials(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return queryBill_Of_Materials(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryBill_Of_Materials(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials[] listBill_Of_MaterialsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return listBill_Of_MaterialsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listBill_Of_MaterialsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials[] listBill_Of_MaterialsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return listBill_Of_MaterialsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listBill_Of_MaterialsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryBill_Of_Materials(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Bill_Of_Materials as Bill_Of_Materials");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryBill_Of_Materials(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Bill_Of_Materials as Bill_Of_Materials");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Bill_Of_Materials", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials[] listBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBill_Of_Materials(session, condition, orderBy);
			return (Bill_Of_Materials[]) list.toArray(new Bill_Of_Materials[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials[] listBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBill_Of_Materials(session, condition, orderBy, lockMode);
			return (Bill_Of_Materials[]) list.toArray(new Bill_Of_Materials[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials loadBill_Of_MaterialsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadBill_Of_MaterialsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadBill_Of_MaterialsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials loadBill_Of_MaterialsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadBill_Of_MaterialsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadBill_Of_MaterialsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials loadBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Bill_Of_Materials[] bill_Of_Materialses = listBill_Of_MaterialsByQuery(session, condition, orderBy);
		if (bill_Of_Materialses != null && bill_Of_Materialses.length > 0)
			return bill_Of_Materialses[0];
		else
			return null;
	}
	
	public static Bill_Of_Materials loadBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Bill_Of_Materials[] bill_Of_Materialses = listBill_Of_MaterialsByQuery(session, condition, orderBy, lockMode);
		if (bill_Of_Materialses != null && bill_Of_Materialses.length > 0)
			return bill_Of_Materialses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBill_Of_MaterialsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return iterateBill_Of_MaterialsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateBill_Of_MaterialsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBill_Of_MaterialsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return iterateBill_Of_MaterialsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateBill_Of_MaterialsByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Bill_Of_Materials as Bill_Of_Materials");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Bill_Of_Materials as Bill_Of_Materials");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Bill_Of_Materials", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateBill_Of_MaterialsByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Bill_Of_Materials loadBill_Of_MaterialsByCriteria(Bill_Of_MaterialsCriteria bill_Of_MaterialsCriteria) {
		Bill_Of_Materials[] bill_Of_Materialses = listBill_Of_MaterialsByCriteria(bill_Of_MaterialsCriteria);
		if(bill_Of_Materialses == null || bill_Of_Materialses.length == 0) {
			return null;
		}
		return bill_Of_Materialses[0];
	}
	
	public static Bill_Of_Materials[] listBill_Of_MaterialsByCriteria(Bill_Of_MaterialsCriteria bill_Of_MaterialsCriteria) {
		return bill_Of_MaterialsCriteria.listBill_Of_Materials();
	}
	
	public static Bill_Of_Materials createBill_Of_Materials() {
		return new Bill_Of_Materials();
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
			if(getProductproduct() != null) {
				getProductproduct().bill_Of_Materials.remove(this);
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
			if(getProductproduct() != null) {
				getProductproduct().bill_Of_Materials.remove(this);
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
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_BILL_OF_MATERIALS_PRODUCTPRODUCT) {
			this.productproduct = (Product) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private int amount_arrived;
	
	private java.sql.Timestamp datetime_added;
	
	private String delivered_by;
	
	private int contact_number;
	
	private Product productproduct;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setAmount_arrived(int value) {
		this.amount_arrived = value;
	}
	
	public int getAmount_arrived() {
		return amount_arrived;
	}
	
	public void setDatetime_added(java.sql.Timestamp value) {
		this.datetime_added = value;
	}
	
	public java.sql.Timestamp getDatetime_added() {
		return datetime_added;
	}
	
	public void setDelivered_by(String value) {
		this.delivered_by = value;
	}
	
	public String getDelivered_by() {
		return delivered_by;
	}
	
	public void setContact_number(int value) {
		this.contact_number = value;
	}
	
	public int getContact_number() {
		return contact_number;
	}
	
	public void setProductproduct(Product value) {
		if (productproduct != null) {
			productproduct.bill_Of_Materials.remove(this);
		}
		if (value != null) {
			value.bill_Of_Materials.add(this);
		}
	}
	
	public Product getProductproduct() {
		return productproduct;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Productproduct(Product value) {
		this.productproduct = value;
	}
	
	private Product getORM_Productproduct() {
		return productproduct;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
