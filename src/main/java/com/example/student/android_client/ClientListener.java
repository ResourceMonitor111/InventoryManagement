package com.example.student.android_client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;


/**
 * Created by student on 17.15.8.
 */

public class ClientListener extends Listener {

    private Boolean newMsg;
    private Object obj;



    public ClientListener(){
        super();
        setNewMsg(false);
    }

    @Override
    public void connected(Connection cnctn) {
  //      MainActivity.WriteOnScreen("You are connected...");
    }



    @Override
    public void received(Connection cnctn, Object o) {
        if((o instanceof Packet.ResponseGetProduct)||(o instanceof Packet.ResponseAddAmount)||(o instanceof Packet.ResponseSubtractAmount)||
           (o instanceof Packet.ResponseInsertProduct)) {
            setObj(o);
            setNewMsg(true);
        }
    }

    @Override
    public void disconnected(Connection cnctn) {
        super.disconnected(cnctn); //To change body of generated methods, choose Tools | Templates.
    }



    public Object getObj() {
        setNewMsg(false);
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }


    public Boolean getNewMsg() {
        return newMsg;
    }

    void setNewMsg(Boolean newMsg) {
        this.newMsg = newMsg;
    }

}