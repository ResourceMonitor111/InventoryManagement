/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amber.client;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Peteris Caurs
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting client...");
        AmberClient client = new AmberClient("192.168.8.120");
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
    }
}
