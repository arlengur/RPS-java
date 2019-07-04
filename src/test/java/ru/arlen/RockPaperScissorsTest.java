package ru.arlen;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for RockPaperScissors.
 */
public class RockPaperScissorsTest {
    private ByteArrayOutputStream out;
    private PrintStream ps;

    @Before
    public void init() {
        out = new ByteArrayOutputStream();
        try {
            ps = new PrintStream(out, true, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Cannot instantiate PrintStream.");
        }

    }

    private String getString(ByteArrayOutputStream out) {
        try {
            return out.toString(StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Cannot read from PrintStream.");
            return null;
        }
    }

    @Test
    public void testTie() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\nn".getBytes());
        new RockPaperScissors(Move.ROCK, in, ps).run();
        assertTrue("Result should be tie!", getString(out).contains("Tie!"));
    }

    @Test
    public void testWinRockVsSc() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\nn".getBytes());
        new RockPaperScissors(Move.SCISSORS, in, ps).run();
        assertTrue("Result should be tie!", getString(out).contains("win"));
    }

    @Test
    public void testLoseRockVsPaper() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\nn".getBytes());
        new RockPaperScissors(Move.PAPER, in, ps).run();
        assertTrue("Result should be tie!", getString(out).contains("lose"));
    }

    @Test
    public void testLosePaperVsRock() {
        ByteArrayInputStream in = new ByteArrayInputStream("3\nn".getBytes());
        new RockPaperScissors(Move.ROCK, in, ps).run();
        assertTrue("Result should be tie!", getString(out).contains("win"));
    }

    @Test
    public void testLosePaperVsSc() {
        ByteArrayInputStream in = new ByteArrayInputStream("3\nn".getBytes());
        new RockPaperScissors(Move.SCISSORS, in, ps).run();
        assertTrue("Result should be tie!", getString(out).contains("lose"));
    }

    @Test
    public void testLoseScVsPaper() {
        ByteArrayInputStream in = new ByteArrayInputStream("2\nn".getBytes());
        new RockPaperScissors(Move.PAPER, in, ps).run();
        assertTrue("Result should be tie!", getString(out).contains("win"));
    }

    @Test
    public void testLoseScVsRock() {
        ByteArrayInputStream in = new ByteArrayInputStream("2\nn".getBytes());
        new RockPaperScissors(Move.ROCK, in, ps).run();
        assertTrue("Result should be tie!", getString(out).contains("lose"));
    }

    @Test
    public void testPlayAgain() {
        ByteArrayInputStream in = new ByteArrayInputStream("3\ny\n1\nn".getBytes());
        new RockPaperScissors(Move.ROCK, in, ps).run();
        assertTrue("Result should be tie!", getString(out).contains("*"));
    }

    @Test
    public void testIncorrectInt() {
        ByteArrayInputStream in = new ByteArrayInputStream("h\n4\n0\n1\nd\nn".getBytes());
        new RockPaperScissors(Move.ROCK, in, ps).run();
        assertTrue("Result should be tie!", getString(out).contains("Tie!"));
    }

    @Test
    public void testRandomValue() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\nn".getBytes());
        System.setIn(in);
        System.setOut(ps);
        new RockPaperScissors(null).run();
        assertTrue("Result should be tie!", getString(out).toLowerCase().contains("*"));
    }

    @Test
    public void testConsole() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\nn".getBytes());
        System.setIn(in);
        System.setOut(null);
        new RockPaperScissors(null).run();
        assertTrue("Result should be tie!", getString(out).toLowerCase().contains("*"));
    }
}