package amber.server;

public class Product {
	public int product_id;
	public String barCode;
	public String productName;
	public String productType;
	public int amount;
	public String datetime;
	public double price;
	public String description;
	
	
	public Product(int product_id, String barCode, String productName, String productType, int amount,
			String datetime, double price, String description) {
		super();
		this.product_id = product_id;
		this.barCode = barCode;
		this.productName = productName;
		this.productType = productType;
		this.amount = amount;
		this.datetime = datetime;
		this.price = price;
		this.description = description;
	}
	
	
}
