package ru.arlen;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * MyConsole
 */
public class MyConsole {
    private BufferedReader r;
    private PrintStream w;

    MyConsole() {
        this(System.in, System.out);
    }

    MyConsole(InputStream in, OutputStream out) {
        r = new BufferedReader(new InputStreamReader(in));
        try {
            w = new PrintStream(out, true, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            // The default encoding should always be available
            throw new Error(e);
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