package ru.arlen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * GameClient
 */
public class GameClient {
    public static void main(String[] args) {
        // getting localhost ip 
        // InetAddress ip = InetAddress.getByName("localhost");
        try (Socket socket = new Socket(InetAddress.getByName("localhost"), 9000);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            System.out.println("Client started!");
            // ;
            // Socket socket = new Socket("localhost", 9000);
            // Create an input stream to receive data from the server
            // DataInputStream in = new DataInputStream(socket.getInputStream());
            // Create an output stream to send data to the server
            // DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Server: "+in.readUTF());
            out.writeUTF("Great!");

            // } catch (Exception e) {
            // TODO: handle exception
        } catch (IOException e) {
            // socket.co
        }
    }

}