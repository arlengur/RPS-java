package ru.arlen;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * GameThread
 */
public class GameThread implements Runnable {
    private Socket socket = null;

    GameThread(Socket inSocket) {
        socket = inSocket;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
// new RockPaperScissors().run();


            System.out.println("Send msg to client");
            out.writeUTF("You are connected to the Server");
            // out
            System.out.println("Client: " + in.readUTF());

        } catch (IOException e) {
            System.out.println("Server cannot open input/output streams: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Server cannot close socket: " + e.getMessage());
            }
        }
    }
}