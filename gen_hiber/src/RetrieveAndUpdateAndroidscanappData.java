/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class RetrieveAndUpdateAndroidscanappData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = AndroidscanappPersistentManager.instance().getSession().beginTransaction();
		try {
			Product product = Product.loadProductByQuery(null, null);
			// Update the properties of the persistent object
			product.save();
			Bill_Of_Materials bill_Of_Materials = Bill_Of_Materials.loadBill_Of_MaterialsByQuery(null, null);
			// Update the properties of the persistent object
			bill_Of_Materials.save();
			ShopTransaction shopTransaction = ShopTransaction.loadShopTransactionByQuery(null, null);
			// Update the properties of the persistent object
			shopTransaction.save();
			Clerk clerk = Clerk.loadClerkByQuery(null, null);
			// Update the properties of the persistent object
			clerk.save();
			ProductTransaction productTransaction = ProductTransaction.loadProductTransactionByQuery(null, null);
			// Update the properties of the persistent object
			productTransaction.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Product by ProductCriteria");
		ProductCriteria productCriteria = new ProductCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//productCriteria.product_id.eq();
		System.out.println(productCriteria.uniqueProduct());
		
		System.out.println("Retrieving Bill_Of_Materials by Bill_Of_MaterialsCriteria");
		Bill_Of_MaterialsCriteria bill_Of_MaterialsCriteria = new Bill_Of_MaterialsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//bill_Of_MaterialsCriteria.id.eq();
		System.out.println(bill_Of_MaterialsCriteria.uniqueBill_Of_Materials());
		
		System.out.println("Retrieving ShopTransaction by ShopTransactionCriteria");
		ShopTransactionCriteria shopTransactionCriteria = new ShopTransactionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//shopTransactionCriteria._transaction_id.eq();
		System.out.println(shopTransactionCriteria.uniqueShopTransaction());
		
		System.out.println("Retrieving Clerk by ClerkCriteria");
		ClerkCriteria clerkCriteria = new ClerkCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//clerkCriteria.clerk_id.eq();
		System.out.println(clerkCriteria.uniqueClerk());
		
		System.out.println("Retrieving ProductTransaction by ProductTransactionCriteria");
		ProductTransactionCriteria productTransactionCriteria = new ProductTransactionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//productTransactionCriteria.productproduct.eq();
		//productTransactionCriteria.transaction_transaction.eq();
		System.out.println(productTransactionCriteria.uniqueProductTransaction());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateAndroidscanappData retrieveAndUpdateAndroidscanappData = new RetrieveAndUpdateAndroidscanappData();
			try {
				retrieveAndUpdateAndroidscanappData.retrieveAndUpdateTestData();
				//retrieveAndUpdateAndroidscanappData.retrieveByCriteria();
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
