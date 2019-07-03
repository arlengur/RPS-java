package ru.arlen;

/**
 * @author satovritti
 * 
 *         User moves
 */
public class User {
    MyConsole console;

    User(MyConsole cons) {
        console = cons;
    }

    /**
     * Gets user move.
     *
     * @return move
     */
    public Move getMove() {
        try {
            console.writeLinef("1 - %s\n2 - %s\n3 - %s\nInput item number:", Move.ROCK, Move.SCISSORS, Move.PAPER);
            String in = console.readLine();
            int input = Integer.parseInt(in);

            if (input < 1 || input > 3) {
                console.writeLineLn("Incorrect input. Try again.\n");
                return getMove();
            }
            return Move.values()[input - 1];
        } catch (NumberFormatException e) {
            console.writeLineLn("Incorrect input. Try again.\n");
            return getMove();
        }
    }

    /**
     * Asks user for a new game.
     *
     * @return user's decision
     */
    public boolean playAgain() {
        console.writeLine("Play again? (Y/N)");
        String userInput = console.readLine();
        userInput = userInput.trim().toUpperCase();
        if (userInput.charAt(0) != 'Y' && userInput.charAt(0) != 'N') {
            console.writeLineLn("Incorrect input. Try again.");
            return playAgain();
        }
        return userInput.charAt(0) == 'Y';
    }
}
