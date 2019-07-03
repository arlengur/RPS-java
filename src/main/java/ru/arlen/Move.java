package ru.arlen;

/**
 * @author satovritti
 *
 *         Player moves
 */
public enum Move {
    ROCK, SCISSORS, PAPER;

    /**
     * Compare moves to determine victory, loss or tie.
     *
     * @param otherMove the move against which the current
     * @return 1 - current move wins, -1 - otherMove wins, 0 - tie
     */
    public int compareMoves(Move otherMove) {
        // Tie
        if (this == otherMove)
            return 0;

        switch (this) {
        case ROCK:
            return (otherMove == SCISSORS ? 1 : -1);
        case PAPER:
            return (otherMove == ROCK ? 1 : -1);
        case SCISSORS:
            return (otherMove == PAPER ? 1 : -1);
        default:
            return 0;
        }
    }
}
