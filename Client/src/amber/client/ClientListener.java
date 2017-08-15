/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amber.client;

import amber.client.Packet.TextMessage;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

/**
 * Responsible for listening the events sent to the client
 * @author Peteris Caurs
 */
class ClientListener extends Listener {

    @Override
    public void connected(Connection cnctn) {
        System.out.println("You are connected...");
    }
    
    @Override
    public void received(Connection cnctn, Object o) {
        if (o instanceof Packet.TextMessage) {
            System.out.println(((TextMessage) o).text);
        }
    }

    @Override
    public void disconnected(Connection cnctn) {
        super.disconnected(cnctn); //To change body of generated methods, choose Tools | Templates.
    }
    
}
