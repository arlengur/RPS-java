package ru.arlen;

import java.util.Random;

/**
 * @author satovritti
 */
public class Computer {
    public Move getMove() {
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }
}
