/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class CreateAndroidscanappData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = AndroidscanappPersistentManager.instance().getSession().beginTransaction();
		try {
			Product product = Product.createProduct();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : bill_Of_Materials, productTransaction, bill_Of_Materialsid, datetime_modified, amount, name
			product.save();
			Bill_Of_Materials bill_Of_Materials = Bill_Of_Materials.createBill_Of_Materials();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : productproduct, contact_number, delivered_by, datetime_added, amount_arrived
			bill_Of_Materials.save();
			ShopTransaction shopTransaction = ShopTransaction.createShopTransaction();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : productTransaction, clerkClerk, datetime_created
			shopTransaction.save();
			Clerk clerk = Clerk.createClerk();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : shopTransaction, lastname, firstname
			clerk.save();
			ProductTransaction productTransaction = ProductTransaction.createProductTransaction();
			// Initialize the properties of the persistent object here
			productTransaction.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateAndroidscanappData createAndroidscanappData = new CreateAndroidscanappData();
			try {
				createAndroidscanappData.createTestData();
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
