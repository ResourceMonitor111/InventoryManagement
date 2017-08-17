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
    private Packet.TextMessage message;
    
    public ServerListener(Server server) {
        this.server = server;
        this.message = new Packet.TextMessage();
    }
    
    @Override
    public void connected(Connection cnctn) {
        System.out.println("Client " + cnctn.getID() + " has connected");
    }
    @Override
    public void received(Connection cnctn, Object o) {
    	if(o instanceof Packet.objectpack){
        	Packet.objectpack res=new Packet.objectpack();
        	res.Mobject=Controler.work(((Packet.objectpack) o).Mobject);
        	server.sendToTCP(cnctn.getID(),res);
        }
    }

    @Override
    public void disconnected(Connection cnctn) {
        System.out.println("Client " + cnctn.getID() + " has diconnected");
    }
    
}
