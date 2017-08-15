/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class ListAndroidscanappData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Product...");
		Product[] products = Product.listProductByQuery(null, null);
		int length = Math.min(products.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(products[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Bill_Of_Materials...");
		Bill_Of_Materials[] bill_Of_Materialses = Bill_Of_Materials.listBill_Of_MaterialsByQuery(null, null);
		length = Math.min(bill_Of_Materialses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bill_Of_Materialses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ShopTransaction...");
		ShopTransaction[] shopTransactions = ShopTransaction.listShopTransactionByQuery(null, null);
		length = Math.min(shopTransactions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(shopTransactions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Clerk...");
		Clerk[] clerks = Clerk.listClerkByQuery(null, null);
		length = Math.min(clerks.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(clerks[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ProductTransaction...");
		ProductTransaction[] productTransactions = ProductTransaction.listProductTransactionByQuery(null, null);
		length = Math.min(productTransactions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(productTransactions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Product by Criteria...");
		ProductCriteria productCriteria = new ProductCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//productCriteria.product_id.eq();
		productCriteria.setMaxResults(ROW_COUNT);
		Product[] products = productCriteria.listProduct();
		int length =products== null ? 0 : Math.min(products.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(products[i]);
		}
		System.out.println(length + " Product record(s) retrieved."); 
		
		System.out.println("Listing Bill_Of_Materials by Criteria...");
		Bill_Of_MaterialsCriteria bill_Of_MaterialsCriteria = new Bill_Of_MaterialsCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//bill_Of_MaterialsCriteria.id.eq();
		bill_Of_MaterialsCriteria.setMaxResults(ROW_COUNT);
		Bill_Of_Materials[] bill_Of_Materialses = bill_Of_MaterialsCriteria.listBill_Of_Materials();
		length =bill_Of_Materialses== null ? 0 : Math.min(bill_Of_Materialses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bill_Of_Materialses[i]);
		}
		System.out.println(length + " Bill_Of_Materials record(s) retrieved."); 
		
		System.out.println("Listing ShopTransaction by Criteria...");
		ShopTransactionCriteria shopTransactionCriteria = new ShopTransactionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//shopTransactionCriteria._transaction_id.eq();
		shopTransactionCriteria.setMaxResults(ROW_COUNT);
		ShopTransaction[] shopTransactions = shopTransactionCriteria.listShopTransaction();
		length =shopTransactions== null ? 0 : Math.min(shopTransactions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(shopTransactions[i]);
		}
		System.out.println(length + " ShopTransaction record(s) retrieved."); 
		
		System.out.println("Listing Clerk by Criteria...");
		ClerkCriteria clerkCriteria = new ClerkCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//clerkCriteria.clerk_id.eq();
		clerkCriteria.setMaxResults(ROW_COUNT);
		Clerk[] clerks = clerkCriteria.listClerk();
		length =clerks== null ? 0 : Math.min(clerks.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(clerks[i]);
		}
		System.out.println(length + " Clerk record(s) retrieved."); 
		
		System.out.println("Listing ProductTransaction by Criteria...");
		ProductTransactionCriteria productTransactionCriteria = new ProductTransactionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ProductCriteria productTransactionCriteria_Product = productTransactionCriteria.createProductproductCriteria();
		//productTransactionCriteria_Product.product_id.eq();
		//ShopTransactionCriteria productTransactionCriteria_ShopTransaction = productTransactionCriteria.createTransaction_transactionCriteria();
		//productTransactionCriteria_ShopTransaction._transaction_id.eq();
		productTransactionCriteria.setMaxResults(ROW_COUNT);
		ProductTransaction[] productTransactions = productTransactionCriteria.listProductTransaction();
		length =productTransactions== null ? 0 : Math.min(productTransactions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(productTransactions[i]);
		}
		System.out.println(length + " ProductTransaction record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListAndroidscanappData listAndroidscanappData = new ListAndroidscanappData();
			try {
				listAndroidscanappData.listTestData();
				//listAndroidscanappData.listByCriteria();
			}
			finally {
				AndroidscanappPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
