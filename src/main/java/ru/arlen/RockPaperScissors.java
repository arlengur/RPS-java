package ru.arlen;

/**
 * @author satovritti
 */
public class RockPaperScissors {
    private User user;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfGames;

    private RockPaperScissors() {
        user = new User();
        computer = new Computer();
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    private void run() {
        System.out.println("ROCK, PAPER, SCISSORS!");
        Move userMove = user.getMove();
        Move computerMove = computer.getMove();
        System.out.println("\nYour move - " + userMove + ", computer move - " + computerMove + ".");

        int compareMoves = userMove.compareMoves(computerMove);
        switch (compareMoves) {
            case 0: // Tie
                System.out.println("Tie!");
                break;
            case 1: // Player wins
                System.out.println(userMove + " beats " + computerMove + ". You win!");
                userScore++;
                break;
            case -1: // Player loses
                System.out.println(computerMove + " beats " + userMove + ". You lose.");
                computerScore++;
                break;
        }
        numberOfGames++;

        if (user.playAgain()) {
            System.out.println();
            run();
        } else {
            printGameStats();
        }
    }

    private void printGameStats() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;

        // Print line
        System.out.print("+");
        printStars(49);
        System.out.println("+");

        // Print table head
        System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |\n", "WIN", "LOSE", "TIE", "TOTAL GAMES");

        // Print line
        System.out.print("|");
        printStars(10);
        System.out.print("+");
        printStars(10);
        System.out.print("+");
        printStars(10);
        System.out.print("+");
        printStars(16);
        System.out.println("+");

        // Print values
        System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |\n", wins, losses, ties, numberOfGames);

        // Print line
        System.out.print("+");
        printStars(49);
        System.out.println("+");
    }

    private void printStars(int i) {
        String repeatedStar = new String(new char[i]).replace('\0', '*');
        System.out.print(repeatedStar);
    }

    public static void main(String[] args) {
        new RockPaperScissors().run();
    }

}
