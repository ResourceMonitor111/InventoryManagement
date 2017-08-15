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

public class ProductCriteria extends AbstractORMCriteria {
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
	
	public ProductCriteria(Criteria criteria) {
		super(criteria);
		product_id = new IntegerExpression("product_id", this);
		name = new StringExpression("name", this);
		product_type = new IntegerExpression("product_type", this);
		amount = new IntegerExpression("amount", this);
		image = new BlobExpression("image", this);
		datetime_modified = new TimestampExpression("datetime_modified", this);
		bill_Of_Materialsid = new IntegerExpression("bill_Of_Materialsid", this);
		price = new BigDecimalExpression("price", this);
		productTransaction = new CollectionExpression("ORM_ProductTransaction", this);
		bill_Of_Materials = new CollectionExpression("ORM_Bill_Of_Materials", this);
	}
	
	public ProductCriteria(PersistentSession session) {
		this(session.createCriteria(Product.class));
	}
	
	public ProductCriteria() throws PersistentException {
		this(AndroidscanappPersistentManager.instance().getSession());
	}
	
	public ProductTransactionCriteria createProductTransactionCriteria() {
		return new ProductTransactionCriteria(createCriteria("ORM_ProductTransaction"));
	}
	
	public Bill_Of_MaterialsCriteria createBill_Of_MaterialsCriteria() {
		return new Bill_Of_MaterialsCriteria(createCriteria("ORM_Bill_Of_Materials"));
	}
	
	public Product uniqueProduct() {
		return (Product) super.uniqueResult();
	}
	
	public Product[] listProduct() {
		java.util.List list = super.list();
		return (Product[]) list.toArray(new Product[list.size()]);
	}
}

