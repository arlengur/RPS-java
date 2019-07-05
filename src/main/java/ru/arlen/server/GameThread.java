package ru.arlen.server;

import java.io.IOException;
import java.net.Socket;

import ru.arlen.core.RockPaperScissors;

/**
 * Runs game for a new player
 */
public class GameThread implements Runnable {
    private Socket socket = null;

    GameThread(Socket inSocket) {
        socket = inSocket;
    }

    @Override
    public void run() {
        try {
            new RockPaperScissors(null, socket.getInputStream(), socket.getOutputStream()).run();
            socket.close();
        } catch (IOException e) {
            System.out.println("Socket wasn't closed: " + e.getMessage());
        }
    }
}