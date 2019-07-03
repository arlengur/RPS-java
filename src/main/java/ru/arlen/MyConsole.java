package ru.arlen;

import java.io.*;

/**
 * MyConsole
 */
public class MyConsole {
    private BufferedReader r;
    private PrintStream w;

    MyConsole() {
        r = new BufferedReader(new InputStreamReader(System.in));
        try {
            w = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void writeLineLn(String str) {
        w.println(str);
    }

    public void writeLine(String str) {
        w.print(str);
    }

    public void writeLinef(String format, Object... args) {
        w.printf(format, args);
    }

    public String readLine() {
        try {
            return r.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}