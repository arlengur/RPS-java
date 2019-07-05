package ru.arlen.server;

import java.util.Scanner;

/**
 * This program implements a server that listens to port 9000 and play Rock
 * Paper Scissors game with clients.
 */
public class Server {
    public static void main(String[] args) {
        ServerSock server = new ServerSock();
        server.start();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("(Server started, use Enter to stop and go back to the console...)");
            scanner.nextLine();
            server.stopGameServer();
        }
    }
}