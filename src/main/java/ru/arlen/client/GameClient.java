package ru.arlen.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import static ru.arlen.Constants.*;

/**
 * Game Client
 */
public class GameClient extends Thread {
    private static Socket socket;
    /* Reads from a console */
    private static BufferedReader reader;
    /* Reads from a socket */
    private static BufferedReader in;
    /* Writes to a socket */
    private static BufferedWriter out;

    public GameClient() {
        try {
            socket = new Socket(HOST_NAME, HOST_PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

            String msg;
            while (true) {
                while ((msg = in.readLine()) != null && !msg.equals(">")) {
                    System.out.println(msg);
                }
                if (msg == null)
                    break;
                writeLineLn(reader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Input/outpur exception: " + e.getMessage());
        } finally {
            try {
                reader.close();
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println("Input/outpur close exception: " + e.getMessage());
            }

        }
    }

    /**
     * Writes a string. to the OutputStream and writes a line separator.
     * 
     * @param str string
     */
    public void writeLineLn(String str) {
        try {
            out.write(str);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            System.out.println("Write line exception: " + e.getMessage());
        }
    }
}