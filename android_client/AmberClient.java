package com.example.student.android_client;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import static com.example.student.android_client.MainActivity.WriteOnScreen;

/**
 * Created by student on 17.15.8.
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
