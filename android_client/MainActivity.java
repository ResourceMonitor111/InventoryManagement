package com.example.student.android_client;

import android.Manifest;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;


import com.esotericsoftware.kryonet.Client;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static TextView mytxt=null;

    public static void WriteOnScreen(String text){
        mytxt.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mytxt= (TextView) findViewById(R.id.thisid);


        WriteOnScreen("Heyyo");

        WriteOnScreen("Starting client...");



        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    if(isHostReachable("192.168.8.118",9999,10000)){
                        WriteOnScreen("got ping");
                        AmberClient client = null;
                        try {
                            client = new AmberClient("192.168.8.118");
                            WriteOnScreen("Connected");
                        } catch (IOException e) {
                            WriteOnScreen(e.toString());
                            e.printStackTrace();
                        }
                        Packet.TextMessage message = new Packet.TextMessage();
                        Scanner scanner = new Scanner(System.in);
                        while(true) {
                            message.text = scanner.nextLine();
                            if (message.text.equals("quit") || message.text.equals("exit")) {
                                break;
                            } else {
                                client.sendMessage(message);
                            }
                        }
                        scanner.close();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();


    }

    public static boolean isHostReachable(String serverAddress, int serverTCPport, int timeoutMS){
        boolean connected = false;
        Socket socket;
        try {
            socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(serverAddress, serverTCPport);
            WriteOnScreen("socket Address");
            socket.connect(socketAddress, timeoutMS);
            WriteOnScreen("connect");
            if (socket.isConnected()) {
                connected = true;
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket = null;

        }
        return connected;
    }
}
