/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amber.server;

import java.io.IOException;

/**
 *
 * @author Peteris Caurs
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting server...");
        AmberServer server = new AmberServer();
    }
}
