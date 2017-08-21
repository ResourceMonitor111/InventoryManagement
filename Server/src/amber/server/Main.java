/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amber.server;

import java.io.IOException;

/**
 *
 * @author Peteris Caurs
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting server...");
        AmberServer server = new AmberServer();
        
//        Product product=new Product(1,"000","Mars","sweets",50,"today",0.98,"good enough");
//        SQLiteDB.insertProduct(product);
//        
//        product=new Product(2,"110","Twix","sweets",35,"tomorrow",1.25,"decent");
//        SQLiteDB.insertProduct(product);
//        
        
        SQLiteDB.selectProducts();
        
        Product product=SQLiteDB.findProduct("000");
        if(product!=null){
        	System.out.println(product.productName);
        }
        
        product=SQLiteDB.findProduct("110");
        if(product!=null){
        	System.out.println(product.productName);
        }
        product=SQLiteDB.findProduct("497452817892");
        if(product!=null){
        	System.out.println(product.productName);
        }
        product=SQLiteDB.findProduct("4974052817885");
        if(product!=null){
        	System.out.println(product.productName);
        }
        
        product=SQLiteDB.findProduct("000");
        if(product!=null){
        	System.out.println(product.productName);
        }
    }
}
