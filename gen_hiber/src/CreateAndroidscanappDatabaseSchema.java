/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class CreateAndroidscanappDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(AndroidscanappPersistentManager.instance());
			AndroidscanappPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
