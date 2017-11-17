package ru.arlen;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author satovritti
 */
public class User {
    private Scanner inputScanner;

    public User() {
        inputScanner = new Scanner(System.in);
    }

    public Move getMove() {
        try {
            System.out.printf("1 - %s\n2 - %s\n3 - %s\nInput item number:", Move.ROCK, Move.SCISSORS, Move.PAPER);
            int input = new Scanner(System.in).nextInt();

            if (input < 1 || input > 3) {
                System.out.println("Incorrect input. Try again.");
                return getMove();
            }
            return Move.values()[input - 1];
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input. Try again.");
            return getMove();
        }
    }

    public boolean playAgain() {
        System.out.print("Play again? (Y/N) ");
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        if (userInput.charAt(0) != 'Y' && userInput.charAt(0) != 'N') {
            System.out.println("Incorrect input. Try again.");
            return playAgain();
        }
        return userInput.charAt(0) == 'Y';
    }
}
