package ru.arlen.core;

import java.util.Random;

/**
 * Computer moves
 */
public class Computer {
    private Move move;

    Computer(Move move) {
        this.move = move;
    }

    /**
     * Gets manufactored move or random move.
     *
     * @return move
     */
    public Move getMove() {
        if (move != null)
            return move;

        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }
}
