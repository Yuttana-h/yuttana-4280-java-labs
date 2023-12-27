package hoomda.yuttana.lab4;

import java.util.ArrayList;
import java.util.Scanner;
/*this program is numberGuessingGame 
 *input number for guessing by create method
 *out put is should be
 *Enter the min value:<inputMinValue>
 *Enter the max value:<inputMaxValue>
 *Enter the maximum number of tries:<inputMaxtriesNumber>
 *Welcome to a number guessing game!
 *Enter an integer between 1 and 5 :3
 *Try a higher number!
 *Enter an integer between 1 and 5 :2
 *Try a higher number!
 *Enter an integer between 1 and 5 :0
 Your guess should be in [1,5]:1
 *Congratulations
 *You have tried 3 times
 *Enter 'a' to list all guesses, 'g' for a specific guess, or any orther key to quit: a
 *All guesses:
 *3 2 1
 *Enter 'a' to list all guesses, 'g' for a specific guess, or any orther key to quit: g
 *Enter the number of the guess you want to see (1-3): 1
 *Guess 1: 3
 *Enter 'a' to list all guesses, 'g' for a specific guess, or any orther key to quit: p
 *Want to play again? (Y or y):y --- if is not y,Y --> stop loop game
  play game loop again...

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 26/12/2023
 */

public class GuessNumberGamesV2 {
    static Scanner input = new Scanner(System.in);
    static int min, max, maxtrie, answer, inputNum, numtrie;
    static String seeAnswer, arkToPlay;
    static ArrayList<Integer> arrayGuess = new ArrayList<>();

    public static void main(String[] args) {
        configure();
        do {
            playGame();
            arkToSeeAnswer();
        } while (playAgain());
    }

    public static boolean playAgain() {
        // Ask the player if they want to play again.
        // @return true if the player wants to play again, false otherwise.
        System.out.print("Want to play again (Y or y):");
        arkToPlay = input.next().toUpperCase();
        return arkToPlay.equals("Y");
    }

    public static void arkToSeeAnswer() {
        // Ask the player if they want to see the answer and display the guesses
        // accordingly.
        do {
            int rangeOfAnswer = numtrie - 1;
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any orther key to quit: ");
            seeAnswer = input.next();
            if (seeAnswer.equals("a")) {
                System.out.println("All guesses:");
                for (int array : arrayGuess) {
                    System.out.print(array + " ");
                }
                System.out.println();

            } else if (seeAnswer.equals("g")) {
                System.out.print("Enter the number of the guess you want to see (1-" + rangeOfAnswer + "): ");
                int seeSpecificAnswer = input.nextInt();
                System.out.print("Guess " + seeSpecificAnswer + ": " + arrayGuess.get(seeSpecificAnswer - 1));
                System.out.println();
            }
        } while (seeAnswer.equals("a") || seeAnswer.equals("g"));
    }

    public static void playGame() {
        arrayGuess.clear();
        genAnswer();

        for (numtrie = 1; numtrie <= maxtrie; numtrie++) {
            System.out.print("Enter an integer between " + min + " and " + max + " :");
            int inputNum = input.nextInt(); // Assuming 'input' is a Scanner object

            while (true) {
                if (inputNum >= min && inputNum <= max) {
                    break;
                } else {
                    System.out.print("Your guess should be in [" + min + "," + max + "]:");
                    inputNum = input.nextInt();
                }
            }
            arrayGuess.add(inputNum);

            // Check if the guess is correct
            if (inputNum == answer) {
                System.out.println("Congratulations");
                if (numtrie == 1) {
                    System.out.println("You have tried 1 time");
                } else {
                    System.out.println("You have tried " + numtrie + " times");
                }
                break;

            } else if (inputNum > answer) {
                System.out.println("Try a lower number!");
            } else if (inputNum < answer) {
                System.out.println("Try a higher number!");
            }

            // If the player runs out of guesses, display the correct answer
            if (numtrie == maxtrie) {
                System.out.println("You ran out of guesses. The answer is " + answer);
            }

        }
    }

    public static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        do {
            System.out.print("Enter the max value:");
            max = input.nextInt();
            if (max < min) {
                System.out.println("The max value must be at least equal to the min value");
            }
        } while (max < min);

        do {
            System.out.print("Enter the maximum number of tries:");
            maxtrie = input.nextInt();
            if (maxtrie <= 0) {
                System.out.println("The maximum number of tries must be greater than 0");
            }
        } while (maxtrie <= 0);
    }
}