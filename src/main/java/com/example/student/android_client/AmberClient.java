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
        kryo.register(Packet.RequestGetProduct.class);
        kryo.register(Packet.ResponseGetProduct.class);
        kryo.register(Packet.ResponseInsertProduct.class);
        kryo.register(Packet.RequestInsertProduct.class);
        kryo.register(Packet.ResponseAddAmount.class);
        kryo.register(Packet.RequestAddAmount.class);
        kryo.register(Packet.ResponseSubtractAmount.class);
        kryo.register(Packet.RequestSubtractAmount.class);
        kryo.register(Product.class);
    }

    public void sendGetProduct(Packet.RequestGetProduct barCode) { client.sendTCP(barCode); }

    public void sendInsertProduct(Packet.ResponseInsertProduct sendable){ client.sendTCP(sendable); }

    public void sendAddAmount(Packet.RequestAddAmount sendable){ client.sendTCP(sendable); }

    public void sendSubtractAmount(Packet.RequestSubtractAmount sendable){ client.sendTCP(sendable); }

    public void closeConnection() {
        client.close();
    }



}
