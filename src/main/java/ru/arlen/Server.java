package ru.arlen;

import java.io.IOException;

/**
 * This program implements a server that listens to port 9000 and play Rock
 * Paper Scissors with them.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSock server = new ServerSock();
        server.start();
        // try {
        //     Thread.sleep(20 * 1000);
        // } catch (InterruptedException e) {
        //     System.out.println("Thread sleep was interrupted.");
        // }
        // server.stopGameServer();
    }
}