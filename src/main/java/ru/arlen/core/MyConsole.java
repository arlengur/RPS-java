package ru.arlen.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;

import org.apache.log4j.Logger;

/**
 * Inpput/output logic implementation.
 */
public class MyConsole {
    private static final Logger logger = Logger.getLogger(MyConsole.class);
    private BufferedReader in;
    private BufferedWriter out;

    MyConsole() {
        this(System.in, System.out);
    }

    MyConsole(InputStream inStream, OutputStream outStream) {
        in = new BufferedReader(new InputStreamReader(inStream));
        out = new BufferedWriter(new OutputStreamWriter(outStream, StandardCharsets.UTF_8));
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
            logger.error("Write line exception", e);
        }
    }

    /**
     * Writes a string to the OutputStream.
     * 
     * @param str
     */
    public void writeLine(String str) {
        try {
            out.write(str);
            out.flush();
        } catch (IOException e) {
            logger.error("Write line exception", e);
        }
    }

    /**
     * Writes a formatted string.
     * 
     * @param format string format
     * @param args   arguments for a string
     */
    public void writeLinef(String format, Object... args) {
        try (Formatter formatter = new Formatter()) {
            out.write(formatter.format(format, args).toString());
            out.flush();
        } catch (IOException e) {
            logger.error("Write line exception", e);
        }
    }

    /**
     * Reads a string from the InputStream
     * 
     * @return string
     */
    public String readLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new Error("Something goes wrong: " + e.getMessage());
        }
    }
}