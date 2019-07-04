package ru.arlen;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author satovritti
 */
public class RockPaperScissors {
    private User user;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfGames;
    private MyConsole console;

    public RockPaperScissors() {
        this(null);
    }

    RockPaperScissors(Move move) {
        console = new MyConsole();
        this.user = new User(console);
        computer = new Computer(move);
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    RockPaperScissors(Move move, InputStream in, OutputStream out) {
        console = new MyConsole(in, out);
        this.user = new User(console);
        computer = new Computer(move);
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    public void run() {
        console.writeLineLn("ROCK, PAPER, SCISSORS!");
        Move userMove = user.getMove();
        Move computerMove = computer.getMove();
        console.writeLineLn("\nYour move - " + userMove + ", computer move - " + computerMove + ".");

        int compareMoves = userMove.compareMoves(computerMove);
        switch (compareMoves) {
        case 0: // Tie
            console.writeLineLn("Tie!");
            break;
        case 1: // Player wins
            console.writeLineLn(userMove + " beats " + computerMove + ". You win!");
            userScore++;
            break;
        case -1: // Player loses
            console.writeLineLn(computerMove + " beats " + userMove + ". You lose.");
            computerScore++;
            break;
        }
        numberOfGames++;

        if (user.playAgain()) {
            console.writeLineLn("\n");
            run();
        } else {
            printGameStats();
        }
    }

    /**
     * Displays game statistics.
     *
     * @return move
     */
    private void printGameStats() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;

        // Print line
        console.writeLine("+");
        printStars(49);
        console.writeLineLn("+");

        // Print table head
        console.writeLinef("|  %6s  |  %6s  |  %6s  |  %12s  |\n", "WIN", "LOSE", "TIE", "TOTAL GAMES");

        // Print line
        console.writeLine("|");
        printStars(10);
        console.writeLine("+");
        printStars(10);
        console.writeLine("+");
        printStars(10);
        console.writeLine("+");
        printStars(16);
        console.writeLineLn("+");

        // Print values
        console.writeLinef("|  %6d  |  %6d  |  %6d  |  %12d  |\n", wins, losses, ties, numberOfGames);

        // Print line
        console.writeLine("+");
        printStars(49);
        console.writeLineLn("+");
    }

    private void printStars(int i) {
        String repeatedStar = new String(new char[i]).replace('\0', '*');
        console.writeLine(repeatedStar);
    }

    /**
     * Game entry point.
     */
    public static void main(String[] args) {
        new RockPaperScissors().run();
    }

}
