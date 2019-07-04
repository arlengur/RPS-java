package ru.arlen;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ServerSocket
 */
public class ServerSock extends Thread {
    private int serverPort = 9000;
    private boolean isStopped = false;
    private ServerSocket serverSocket = null;
    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public ServerSock() {
    }

    public ServerSock(int port) {
        serverPort = port;
    }

    public void run() {
        openServerSocket();
        while (!isStopped()) {
            try {
                threadPool.execute(new GameThread(serverSocket.accept()));
            } catch (IOException e) {
                if (isStopped())
                    break;
                throw new RuntimeException("Error accepting client connection", e);
            }
        }
        threadPool.shutdown();
        System.out.println("Server Stopped.");
    }

    private synchronized boolean isStopped() {
        return isStopped;
    }

    public synchronized void stopGameServer() {
        isStopped = true;
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Server started!");
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }

}