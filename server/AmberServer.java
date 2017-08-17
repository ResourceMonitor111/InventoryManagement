/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amber.server;

import amber.server.Packet.TextMessage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import java.io.IOException;

/**
 * Responsible for server connection
 * @author Peteris Caurs
 */
public class AmberServer {
    
    private Server server;
    private Kryo kryo;
    private ServerListener serverListener;

    public AmberServer() throws IOException {
        server = new Server();
        serverListener = new ServerListener(server);
        server.addListener(serverListener);
        registerPackets();
        server.bind(9999);
        server.start();
        System.out.println("Started...");
    }
    
    private void registerPackets() {
        kryo = server.getKryo();
        kryo.register(TextMessage.class);
        kryo.register(Packet.objectpack.class);
    }
    
}
