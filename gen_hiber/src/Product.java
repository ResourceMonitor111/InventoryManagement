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

public class Product {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(Product.class);
	public Product() {
	}
	
	public static Product loadProductByORMID(int product_id) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadProductByORMID(session, product_id);
		}
		catch (Exception e) {
			_logger.error("loadProductByORMID(int product_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product getProductByORMID(int product_id) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return getProductByORMID(session, product_id);
		}
		catch (Exception e) {
			_logger.error("getProductByORMID(int product_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product loadProductByORMID(int product_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadProductByORMID(session, product_id, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProductByORMID(int product_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product getProductByORMID(int product_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return getProductByORMID(session, product_id, lockMode);
		}
		catch (Exception e) {
			_logger.error("getProductByORMID(int product_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product loadProductByORMID(PersistentSession session, int product_id) throws PersistentException {
		try {
			return (Product) session.load(Product.class, new Integer(product_id));
		}
		catch (Exception e) {
			_logger.error("loadProductByORMID(PersistentSession session, int product_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product getProductByORMID(PersistentSession session, int product_id) throws PersistentException {
		try {
			return (Product) session.get(Product.class, new Integer(product_id));
		}
		catch (Exception e) {
			_logger.error("getProductByORMID(PersistentSession session, int product_id)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product loadProductByORMID(PersistentSession session, int product_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Product) session.load(Product.class, new Integer(product_id), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProductByORMID(PersistentSession session, int product_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product getProductByORMID(PersistentSession session, int product_id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Product) session.get(Product.class, new Integer(product_id), lockMode);
		}
		catch (Exception e) {
			_logger.error("getProductByORMID(PersistentSession session, int product_id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryProduct(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return queryProduct(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryProduct(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryProduct(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return queryProduct(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryProduct(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product[] listProductByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return listProductByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listProductByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product[] listProductByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return listProductByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listProductByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryProduct(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Product as Product");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listProductByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryProduct(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Product as Product");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Product", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listProductByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product[] listProductByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProduct(session, condition, orderBy);
			return (Product[]) list.toArray(new Product[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listProductByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product[] listProductByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProduct(session, condition, orderBy, lockMode);
			return (Product[]) list.toArray(new Product[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listProductByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product loadProductByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadProductByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadProductByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product loadProductByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return loadProductByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProductByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product loadProductByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Product[] products = listProductByQuery(session, condition, orderBy);
		if (products != null && products.length > 0)
			return products[0];
		else
			return null;
	}
	
	public static Product loadProductByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Product[] products = listProductByQuery(session, condition, orderBy, lockMode);
		if (products != null && products.length > 0)
			return products[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProductByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return iterateProductByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateProductByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProductByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = AndroidscanappPersistentManager.instance().getSession();
			return iterateProductByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateProductByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProductByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Product as Product");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateProductByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProductByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Product as Product");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Product", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateProductByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Product loadProductByCriteria(ProductCriteria productCriteria) {
		Product[] products = listProductByCriteria(productCriteria);
		if(products == null || products.length == 0) {
			return null;
		}
		return products[0];
	}
	
	public static Product[] listProductByCriteria(ProductCriteria productCriteria) {
		return productCriteria.listProduct();
	}
	
	public static Product createProduct() {
		return new Product();
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
			ProductTransaction[] lProductTransactions = productTransaction.toArray();
			for(int i = 0; i < lProductTransactions.length; i++) {
				lProductTransactions[i].setProductproduct(null);
			}
			Bill_Of_Materials[] lBill_Of_Materialss = bill_Of_Materials.toArray();
			for(int i = 0; i < lBill_Of_Materialss.length; i++) {
				lBill_Of_Materialss[i].setProductproduct(null);
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
			ProductTransaction[] lProductTransactions = productTransaction.toArray();
			for(int i = 0; i < lProductTransactions.length; i++) {
				lProductTransactions[i].setProductproduct(null);
			}
			Bill_Of_Materials[] lBill_Of_Materialss = bill_Of_Materials.toArray();
			for(int i = 0; i < lBill_Of_Materialss.length; i++) {
				lBill_Of_Materialss[i].setProductproduct(null);
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
		if (key == ORMConstants.KEY_PRODUCT_PRODUCTTRANSACTION) {
			return ORM_productTransaction;
		}
		else if (key == ORMConstants.KEY_PRODUCT_BILL_OF_MATERIALS) {
			return ORM_bill_Of_Materials;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int product_id;
	
	private String name;
	
	private Integer product_type;
	
	private int amount;
	
	private java.sql.Blob image;
	
	private java.sql.Timestamp datetime_modified;
	
	private int bill_Of_Materialsid;
	
	private java.math.BigDecimal price;
	
	private java.util.Set ORM_productTransaction = new java.util.HashSet();
	
	private java.util.Set ORM_bill_Of_Materials = new java.util.HashSet();
	
	private void setProduct_id(int value) {
		this.product_id = value;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	
	public int getORMID() {
		return getProduct_id();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setProduct_type(int value) {
		setProduct_type(new Integer(value));
	}
	
	public void setProduct_type(Integer value) {
		this.product_type = value;
	}
	
	public Integer getProduct_type() {
		return product_type;
	}
	
	public void setAmount(int value) {
		this.amount = value;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setImage(java.sql.Blob value) {
		this.image = value;
	}
	
	public java.sql.Blob getImage() {
		return image;
	}
	
	public void setDatetime_modified(java.sql.Timestamp value) {
		this.datetime_modified = value;
	}
	
	public java.sql.Timestamp getDatetime_modified() {
		return datetime_modified;
	}
	
	public void setBill_Of_Materialsid(int value) {
		this.bill_Of_Materialsid = value;
	}
	
	public int getBill_Of_Materialsid() {
		return bill_Of_Materialsid;
	}
	
	public void setPrice(java.math.BigDecimal value) {
		this.price = value;
	}
	
	public java.math.BigDecimal getPrice() {
		return price;
	}
	
	private void setORM_ProductTransaction(java.util.Set value) {
		this.ORM_productTransaction = value;
	}
	
	private java.util.Set getORM_ProductTransaction() {
		return ORM_productTransaction;
	}
	
	public final ProductTransactionSetCollection productTransaction = new ProductTransactionSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCT_PRODUCTTRANSACTION, ORMConstants.KEY_PRODUCTTRANSACTION_PRODUCTPRODUCT, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Bill_Of_Materials(java.util.Set value) {
		this.ORM_bill_Of_Materials = value;
	}
	
	private java.util.Set getORM_Bill_Of_Materials() {
		return ORM_bill_Of_Materials;
	}
	
	public final Bill_Of_MaterialsSetCollection bill_Of_Materials = new Bill_Of_MaterialsSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCT_BILL_OF_MATERIALS, ORMConstants.KEY_BILL_OF_MATERIALS_PRODUCTPRODUCT, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getProduct_id());
	}
	
}
