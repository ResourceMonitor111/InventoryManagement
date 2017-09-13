/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amber.server;

/**
 * Message wrapper when sending it across the network
 * @author Peteris Caurs
 */
public class Packet {
	
    public static class ResponseGetProduct{
    	public Product product;
    }
    
    public static class RequestGetProduct{
    	public String barCode;
    }
  
    public static class ResponseInsertProduct{
    	public boolean bool;
    }
    
    public static class RequestInsertProduct{
    	public Product product;
    }
    
    public static class ResponseAddAmount{
    	public boolean bool;
    }
    
    public static class RequestAddAmount{
		public String barCode;
		public int amount;
    }
    
    public static class ResponseSubtractAmount{
    	public boolean bool;
    }
   
    public static class RequestSubtractAmount{
    	public String barCode;
    	public int amount;
    }
}
