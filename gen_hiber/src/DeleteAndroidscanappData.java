/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class DeleteAndroidscanappData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = AndroidscanappPersistentManager.instance().getSession().beginTransaction();
		try {
			Product product = Product.loadProductByQuery(null, null);
			product.delete();
			Bill_Of_Materials bill_Of_Materials = Bill_Of_Materials.loadBill_Of_MaterialsByQuery(null, null);
			bill_Of_Materials.delete();
			ShopTransaction shopTransaction = ShopTransaction.loadShopTransactionByQuery(null, null);
			shopTransaction.delete();
			Clerk clerk = Clerk.loadClerkByQuery(null, null);
			clerk.delete();
			ProductTransaction productTransaction = ProductTransaction.loadProductTransactionByQuery(null, null);
			productTransaction.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteAndroidscanappData deleteAndroidscanappData = new DeleteAndroidscanappData();
			try {
				deleteAndroidscanappData.deleteTestData();
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
