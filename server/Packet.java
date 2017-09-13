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
    
    public static class TextMessage {
        public String text;
    }
    
    public static class objectpack{
    	public Object Mobject;
    }
    
}
