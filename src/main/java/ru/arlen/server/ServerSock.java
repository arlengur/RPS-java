package ru.arlen.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static ru.arlen.Constants.*;

/**
 * Runs server and manages thread pool.
 */
public class ServerSock extends Thread {
    private boolean isStopped = false;
    private ServerSocket serverSocket = null;
    private ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public ServerSock() {
    }

    public void run() {
        openServerSocket();
        while (!isStopped()) {
            try {
                /**
                 * Gets thread for a game from ExecutorService
                 */
                threadPool.execute(new GameThread(serverSocket.accept()));
            } catch (IOException e) {
                if (isStopped()) {
                    try {
                        if (!serverSocket.isClosed())
                            serverSocket.close();
                    } catch (IOException e1) {
                        throw new RuntimeException("Socket close error", e);
                    }
                    break;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
        }
        threadPool.shutdown();
        System.out.println("Server Stopped.");
    }

    /**
     * Gets isStopped flag value.
     * 
     * @return isStopped boolean value
     */
    private synchronized boolean isStopped() {
        return isStopped;
    }

    /**
     * Sets isStopped = true to shutdown the server.
     */
    public synchronized void stopGameServer() {
        isStopped = true;
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    /**
     * Creates Server socket
     */
    private void openServerSocket() {
        try {
            serverSocket = new ServerSocket(HOST_PORT);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port " + HOST_PORT, e);
        }
    }
}