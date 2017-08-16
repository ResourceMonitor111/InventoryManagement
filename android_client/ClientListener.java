package com.example.student.android_client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;


/**
 * Created by student on 17.15.8.
 */

public class ClientListener extends Listener {


    @Override
    public void connected(Connection cnctn) {
        System.out.println("You are connected...");
    }



    @Override
    public void received(Connection cnctn, Object o) {
        if (o instanceof Packet.TextMessage) {
            MainActivity.WriteOnScreen(((Packet.TextMessage) o).text);
      //      System.out.println(((TextMessage) o).text);
        }
    }

    @Override
    public void disconnected(Connection cnctn) {
        super.disconnected(cnctn); //To change body of generated methods, choose Tools | Templates.
    }

}
