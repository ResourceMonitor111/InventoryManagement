/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amber.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

/**
 * Responsible for listening the events sent to the server
 * @author Peteris Caurs
 */
class ServerListener extends Listener {

    private Server server;
    private Connection[] allClients;
    
    public ServerListener(Server server) {
        this.server = server;
    }
    
    @Override
    public void connected(Connection cnctn) {
        System.out.println("Client " + cnctn.getID() + " has connected");
    }
    @Override
    public void received(Connection cnctn, Object o) {
    	if(o instanceof Packet.RequestGetProduct){
        	System.out.println("got barcode");
        	Packet.ResponseGetProduct sendable=new Packet.ResponseGetProduct();
        	sendable.product=SQLiteDB.findProduct(((Packet.RequestGetProduct) o).barCode);
        	server.sendToTCP(cnctn.getID(), sendable);
        }else if(o instanceof Packet.ResponseGetProduct){
        	System.out.println("got product to insert");
        	Packet.ResponseInsertProduct sendable=new Packet.ResponseInsertProduct();
        	sendable.bool=SQLiteDB.insertProduct(((Packet.ResponseGetProduct) o).product);
        	server.sendToTCP(cnctn.getID(),sendable);
        }else if(o instanceof Packet.RequestAddAmount){
        	System.out.println("got add amount request");
    		Packet.ResponseAddAmount sendable=new Packet.ResponseAddAmount();
    		sendable.bool=SQLiteDB.changeProductAmount(((Packet.RequestAddAmount) o).barCode,
    												   ((Packet.RequestAddAmount) o).amount,true);
    		server.sendToTCP(cnctn.getID(), sendable);
        }else if(o instanceof Packet.RequestSubtractAmount){
        	System.out.println("got sutract amount request");
        	Packet.ResponseSubtractAmount sendable= new Packet.ResponseSubtractAmount();
        	sendable.bool=SQLiteDB.changeProductAmount(((Packet.RequestSubtractAmount) o).barCode,
        											   ((Packet.RequestSubtractAmount) o).amount,false);
        	server.sendToTCP(cnctn.getID(), sendable);
        }
    }

    @Override
    public void disconnected(Connection cnctn) {
        System.out.println("Client " + cnctn.getID() + " has diconnected");
    }
    
}
