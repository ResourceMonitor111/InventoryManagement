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

public class ProductDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression product_id;
	public final StringExpression name;
	public final IntegerExpression product_type;
	public final IntegerExpression amount;
	public final BlobExpression image;
	public final TimestampExpression datetime_modified;
	public final IntegerExpression bill_Of_Materialsid;
	public final BigDecimalExpression price;
	public final CollectionExpression productTransaction;
	public final CollectionExpression bill_Of_Materials;
	
	public ProductDetachedCriteria() {
		super(Product.class, ProductCriteria.class);
		product_id = new IntegerExpression("product_id", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		product_type = new IntegerExpression("product_type", this.getDetachedCriteria());
		amount = new IntegerExpression("amount", this.getDetachedCriteria());
		image = new BlobExpression("image", this.getDetachedCriteria());
		datetime_modified = new TimestampExpression("datetime_modified", this.getDetachedCriteria());
		bill_Of_Materialsid = new IntegerExpression("bill_Of_Materialsid", this.getDetachedCriteria());
		price = new BigDecimalExpression("price", this.getDetachedCriteria());
		productTransaction = new CollectionExpression("ORM_ProductTransaction", this.getDetachedCriteria());
		bill_Of_Materials = new CollectionExpression("ORM_Bill_Of_Materials", this.getDetachedCriteria());
	}
	
	public ProductDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ProductCriteria.class);
		product_id = new IntegerExpression("product_id", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		product_type = new IntegerExpression("product_type", this.getDetachedCriteria());
		amount = new IntegerExpression("amount", this.getDetachedCriteria());
		image = new BlobExpression("image", this.getDetachedCriteria());
		datetime_modified = new TimestampExpression("datetime_modified", this.getDetachedCriteria());
		bill_Of_Materialsid = new IntegerExpression("bill_Of_Materialsid", this.getDetachedCriteria());
		price = new BigDecimalExpression("price", this.getDetachedCriteria());
		productTransaction = new CollectionExpression("ORM_ProductTransaction", this.getDetachedCriteria());
		bill_Of_Materials = new CollectionExpression("ORM_Bill_Of_Materials", this.getDetachedCriteria());
	}
	
	public ProductTransactionDetachedCriteria createProductTransactionCriteria() {
		return new ProductTransactionDetachedCriteria(createCriteria("ORM_ProductTransaction"));
	}
	
	public Bill_Of_MaterialsDetachedCriteria createBill_Of_MaterialsCriteria() {
		return new Bill_Of_MaterialsDetachedCriteria(createCriteria("ORM_Bill_Of_Materials"));
	}
	
	public Product uniqueProduct(PersistentSession session) {
		return (Product) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Product[] listProduct(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Product[]) list.toArray(new Product[list.size()]);
	}
}

