/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amber.client;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import java.io.IOException;

/**
 * Responsible for client connection
 * @author Peteris Caurs
 */
public class AmberClient {
    
    private Client client;
    private ClientListener clientListener;
    private Kryo kryo;
    

    public AmberClient(String ipAddress) throws IOException {
        client = new Client();
        clientListener = new ClientListener();
        client.addListener(clientListener);
        registerPackets();
        client.start();
        client.connect(500, ipAddress, 9999);
    }

    private void registerPackets() {
        kryo = client.getKryo();
        kryo.register(Packet.TextMessage.class);
    }
    
    public void sendMessage(Packet.TextMessage textMessage) {
        client.sendTCP(textMessage);
    }
    
    public void closeConnection() {
        client.close();
    }
    
}
