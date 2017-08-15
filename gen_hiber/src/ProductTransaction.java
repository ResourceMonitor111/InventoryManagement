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

import java.io.Serializable;
public class ProductTransaction implements Serializable {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(ProductTransaction.class);
	public ProductTransaction() {
	}
	
	public static ProductTransaction loadProductTransactionByORMID(Product productproduct, ShopTransaction transaction_transaction) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadProductTransactionByORMID(session, productproduct, transaction_transaction);
		}
		catch (Exception e) {
			_logger.error("loadProductTransactionByORMID(Product productproduct, ShopTransaction transaction_transaction)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction getProductTransactionByORMID(Product productproduct, ShopTransaction transaction_transaction) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return getProductTransactionByORMID(session, productproduct, transaction_transaction);
		}
		catch (Exception e) {
			_logger.error("getProductTransactionByORMID(Product productproduct, ShopTransaction transaction_transaction)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction loadProductTransactionByORMID(Product productproduct, ShopTransaction transaction_transaction, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadProductTransactionByORMID(session, productproduct, transaction_transaction, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProductTransactionByORMID(Product productproduct, ShopTransaction transaction_transaction, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction getProductTransactionByORMID(Product productproduct, ShopTransaction transaction_transaction, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return getProductTransactionByORMID(session, productproduct, transaction_transaction, lockMode);
		}
		catch (Exception e) {
			_logger.error("getProductTransactionByORMID(Product productproduct, ShopTransaction transaction_transaction, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction loadProductTransactionByORMID(PersistentSession session, Product productproduct, ShopTransaction transaction_transaction) throws PersistentException {
		try {
			ProductTransaction producttransaction = new ProductTransaction();
			producttransaction.setORM_Productproduct(productproduct);
			producttransaction.setORM_Transaction_transaction(transaction_transaction);
			
			return (ProductTransaction) session.load(ProductTransaction.class, producttransaction);
		}
		catch (Exception e) {
			_logger.error("loadProductTransactionByORMID(PersistentSession session, Product productproduct, ShopTransaction transaction_transaction)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction getProductTransactionByORMID(PersistentSession session, Product productproduct, ShopTransaction transaction_transaction) throws PersistentException {
		try {
			ProductTransaction producttransaction = new ProductTransaction();
			producttransaction.setORM_Productproduct(productproduct);
			producttransaction.setORM_Transaction_transaction(transaction_transaction);
			
			return (ProductTransaction) session.get(ProductTransaction.class, producttransaction);
		}
		catch (Exception e) {
			_logger.error("getProductTransactionByORMID(PersistentSession session, Product productproduct, ShopTransaction transaction_transaction)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction loadProductTransactionByORMID(PersistentSession session, Product productproduct, ShopTransaction transaction_transaction, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			ProductTransaction producttransaction = new ProductTransaction();
			producttransaction.setORM_Productproduct(productproduct);
			producttransaction.setORM_Transaction_transaction(transaction_transaction);
			
			return (ProductTransaction) session.load(ProductTransaction.class, producttransaction, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProductTransactionByORMID(PersistentSession session, Product productproduct, ShopTransaction transaction_transaction, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction getProductTransactionByORMID(PersistentSession session, Product productproduct, ShopTransaction transaction_transaction, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			ProductTransaction producttransaction = new ProductTransaction();
			producttransaction.setORM_Productproduct(productproduct);
			producttransaction.setORM_Transaction_transaction(transaction_transaction);
			
			return (ProductTransaction) session.get(ProductTransaction.class, producttransaction, lockMode);
		}
		catch (Exception e) {
			_logger.error("getProductTransactionByORMID(PersistentSession session, Product productproduct, ShopTransaction transaction_transaction, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryProductTransaction(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return queryProductTransaction(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryProductTransaction(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryProductTransaction(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return queryProductTransaction(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryProductTransaction(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction[] listProductTransactionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return listProductTransactionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listProductTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction[] listProductTransactionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return listProductTransactionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listProductTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryProductTransaction(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ProductTransaction as ProductTransaction");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listProductTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryProductTransaction(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ProductTransaction as ProductTransaction");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ProductTransaction", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listProductTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction[] listProductTransactionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProductTransaction(session, condition, orderBy);
			return (ProductTransaction[]) list.toArray(new ProductTransaction[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listProductTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction[] listProductTransactionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProductTransaction(session, condition, orderBy, lockMode);
			return (ProductTransaction[]) list.toArray(new ProductTransaction[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listProductTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction loadProductTransactionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadProductTransactionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadProductTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction loadProductTransactionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadProductTransactionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProductTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction loadProductTransactionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ProductTransaction[] productTransactions = listProductTransactionByQuery(session, condition, orderBy);
		if (productTransactions != null && productTransactions.length > 0)
			return productTransactions[0];
		else
			return null;
	}
	
	public static ProductTransaction loadProductTransactionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ProductTransaction[] productTransactions = listProductTransactionByQuery(session, condition, orderBy, lockMode);
		if (productTransactions != null && productTransactions.length > 0)
			return productTransactions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProductTransactionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return iterateProductTransactionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateProductTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProductTransactionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return iterateProductTransactionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateProductTransactionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProductTransactionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ProductTransaction as ProductTransaction");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateProductTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProductTransactionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ProductTransaction as ProductTransaction");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ProductTransaction", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateProductTransactionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ProductTransaction loadProductTransactionByCriteria(ProductTransactionCriteria productTransactionCriteria) {
		ProductTransaction[] productTransactions = listProductTransactionByCriteria(productTransactionCriteria);
		if(productTransactions == null || productTransactions.length == 0) {
			return null;
		}
		return productTransactions[0];
	}
	
	public static ProductTransaction[] listProductTransactionByCriteria(ProductTransactionCriteria productTransactionCriteria) {
		return productTransactionCriteria.listProductTransaction();
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof ProductTransaction))
			return false;
		ProductTransaction producttransaction = (ProductTransaction)aObj;
		if (getProductproduct() == null) {
			if (producttransaction.getProductproduct() != null)
				return false;
		}
		else if (!getProductproduct().equals(producttransaction.getProductproduct()))
			return false;
		if (getTransaction_transaction() == null) {
			if (producttransaction.getTransaction_transaction() != null)
				return false;
		}
		else if (!getTransaction_transaction().equals(producttransaction.getTransaction_transaction()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getProductproduct() != null) {
			hashcode = hashcode + (int) getProductproduct().getORMID();
		}
		if (getTransaction_transaction() != null) {
			hashcode = hashcode + (int) getTransaction_transaction().getORMID();
		}
		return hashcode;
	}
	
	public static ProductTransaction createProductTransaction() {
		return new ProductTransaction();
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
			Product productproduct = getProductproduct();
			if(getProductproduct() != null) {
				getProductproduct().productTransaction.remove(this);
			}
			setORM_Productproduct(productproduct);
			
			ShopTransaction transaction_transaction = getTransaction_transaction();
			if(getTransaction_transaction() != null) {
				getTransaction_transaction().productTransaction.remove(this);
			}
			setORM_Transaction_transaction(transaction_transaction);
			
			return delete();
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			Product productproduct = getProductproduct();
			if(getProductproduct() != null) {
				getProductproduct().productTransaction.remove(this);
			}
			setORM_Productproduct(productproduct);
			
			ShopTransaction transaction_transaction = getTransaction_transaction();
			if(getTransaction_transaction() != null) {
				getTransaction_transaction().productTransaction.remove(this);
			}
			setORM_Transaction_transaction(transaction_transaction);
			
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
		if (key == ORMConstants.KEY_PRODUCTTRANSACTION_PRODUCTPRODUCT) {
			this.productproduct = (Product) owner;
		}
		
		else if (key == ORMConstants.KEY_PRODUCTTRANSACTION_TRANSACTION_TRANSACTION) {
			this.transaction_transaction = (ShopTransaction) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private Integer sold_amount;
	
	private Product productproduct;
	
	private int productproductId;
	
	private void setProductproductId(int value) {
		this.productproductId = value;
	}
	
	public int getProductproductId() {
		return productproductId;
	}
	
	private ShopTransaction transaction_transaction;
	
	private int transaction_transactionId;
	
	private void setTransaction_transactionId(int value) {
		this.transaction_transactionId = value;
	}
	
	public int getTransaction_transactionId() {
		return transaction_transactionId;
	}
	
	public void setSold_amount(int value) {
		setSold_amount(new Integer(value));
	}
	
	public void setSold_amount(Integer value) {
		this.sold_amount = value;
	}
	
	public Integer getSold_amount() {
		return sold_amount;
	}
	
	public void setProductproduct(Product value) {
		if (productproduct != null) {
			productproduct.productTransaction.remove(this);
		}
		if (value != null) {
			value.productTransaction.add(this);
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
	
	public void setTransaction_transaction(ShopTransaction value) {
		if (transaction_transaction != null) {
			transaction_transaction.productTransaction.remove(this);
		}
		if (value != null) {
			value.productTransaction.add(this);
		}
	}
	
	public ShopTransaction getTransaction_transaction() {
		return transaction_transaction;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Transaction_transaction(ShopTransaction value) {
		this.transaction_transaction = value;
	}
	
	private ShopTransaction getORM_Transaction_transaction() {
		return transaction_transaction;
	}
	
	public String toString() {
		return String.valueOf(((getProductproduct() == null) ? "" : String.valueOf(getProductproduct().getORMID())) + " " + ((getTransaction_transaction() == null) ? "" : String.valueOf(getTransaction_transaction().getORMID())));
	}
	
}
