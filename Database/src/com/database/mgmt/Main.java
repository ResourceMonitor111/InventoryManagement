package com.database.mgmt;

/**
 * Data population of the ScaneristDB.db file
 * @author Peteris Caurs
 */
public class Main {

    /**
     * Invoke SQLiteDB methods here
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SQLiteDB db = new SQLiteDB();
        db.insertProduct("!@#ghJ#$poui1", "Perfume", 42, 1, "resources/perfume.jpg", 666, 21.99);
//        db.readImage(2, "lipstick_from_db.jpg");
    }
    
}
