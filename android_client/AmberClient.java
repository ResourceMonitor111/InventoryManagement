package com.example.student.android_client;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

import java.io.IOException;

/**
 * Created by student on 17.15.8.
 */

public class AmberClient {

    private Client client;
    public ClientListener clientListener;
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
        kryo.register(Packet.objectpack.class);
    }

    public void sendMessage(Packet.TextMessage textMessage) {
        client.sendTCP(textMessage);
    }

    public void sendObject(Packet.objectpack obj){
        client.sendTCP(obj);
    }

    public void closeConnection() {
        client.close();
    }



}
