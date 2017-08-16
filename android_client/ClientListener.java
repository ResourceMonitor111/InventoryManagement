package com.example.student.android_client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;


/**
 * Created by student on 17.15.8.
 */

public class ClientListener extends Listener {

    private Boolean listen;
    private Boolean newMsg;
    private String Msg;
    public Object obj;



    public ClientListener(){
        super();
        setMsg("");
        setNewMsg(false);
        setListen(true);
    }

    @Override
    public void connected(Connection cnctn) {
  //      MainActivity.WriteOnScreen("You are connected...");
    }



    @Override
    public void received(Connection cnctn, Object o) {
        if (o instanceof Packet.TextMessage) {

            if(((Packet.TextMessage) o).text.equals("finish")){
                setListen(false);
            }
            setMsg(((Packet.TextMessage) o).text);
            setNewMsg(true);
        }else if(o instanceof Packet.objectpack){
            this.obj=((Packet.objectpack) o).Mobject;
            setNewMsg(true);
        }
    }

    @Override
    public void disconnected(Connection cnctn) {
        super.disconnected(cnctn); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean getListen() {
        return listen;
    }

    void setListen(Boolean listen) {
        this.listen = listen;
    }


    public String getMsg() {
        setNewMsg(false);
        return Msg;
    }

    void setMsg(String msg) {
        Msg = msg;
    }

    public Boolean getNewMsg() {
        return newMsg;
    }

    void setNewMsg(Boolean newMsg) {
        this.newMsg = newMsg;
    }

}
