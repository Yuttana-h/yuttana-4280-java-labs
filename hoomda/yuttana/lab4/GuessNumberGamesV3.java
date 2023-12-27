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
 *Game Log: Answer: 1, Guesses: 3, Win: true
 *Want to play again? (Y or y):y --- if is not y,Y --> stop loop game
 *----- Game Statistics -----
 Total games played: 1
 Total wins: 1
 Win Ratio: 100.0%
 Average guess per game: 3.0
 High Score (Least Guesses): 0
  play game loop again...

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 23/12/2023
 */

public class GuessNumberGamesV3 {
    static Scanner input = new Scanner(System.in);
    static int min, max, maxtrie, answer, inputNum, numtrie, minOfArraynumtrie;
    static int numWin, sum = 0;
    static int numPlay = 1;
    static String seeAnswer, arkToPlay, win;
    static ArrayList<Integer> arrayGuess = new ArrayList<>();
    static ArrayList<Integer> arrayNumtrie = new ArrayList<>();

    public static void main(String[] args) {
        configure();
        do {
            playGame();
            arkToSeeAnswer();
            gameLog();
        } while (playAgain());
        gameStatistic();
    }

    public static void gameStatistic() {
        // Calculate win rate, average guesses, and find the minimum number of guesses
        float winRate = ((float) numWin / numPlay) * 100;
        for (int i = 0; i < arrayNumtrie.size(); i++) {
            sum += arrayNumtrie.get(i);
            if (arrayNumtrie.get(i) < arrayNumtrie.get(0)) {
                minOfArraynumtrie = arrayNumtrie.get(i);
            } else if (arrayNumtrie.get(i) == arrayNumtrie.get(0)) {
                minOfArraynumtrie = arrayNumtrie.get(i);
            }
        }

        float averageGuess = sum / arrayNumtrie.size();

        System.out.println("----- Game Statistics -----");
        System.out.println("Total games played: " + numPlay);
        System.out.println("Total wins: " + numWin);
        System.out.println("Win Ratio: " + winRate + "%");
        System.out.println("Average guess per game: " + averageGuess);
        if (numWin > 0) {
            System.out.println("High Score (Least Guesses): " + minOfArraynumtrie);
        } else {
            System.out.println("High Score (Least Guesses): N/A");
        }
    }

    public static void gameLog() {
        System.out.println("Game Log: Answer: " + answer + ", Guesses: " + numtrie + ", Win: " + win);
    }

    public static boolean playAgain() {
        // Ask the player if they want to play again.
        // @return true if the player wants to play again, false otherwise.
        System.out.print("Want to play again (Y or y):");
        arkToPlay = input.next().toUpperCase();
        if (arkToPlay.equals("Y")) {
            numPlay++;
        }
        return arkToPlay.equals("Y");
    }

    public static void arkToSeeAnswer() {
        // Ask the player if they want to see the answer and display the guesses
        // accordingly.
        do {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any orther key to quit: ");
            seeAnswer = input.next();
            if (seeAnswer.equals("a")) {
                System.out.println("All guesses:");
                for (int array : arrayGuess) {
                    System.out.print(array + " ");
                }
                System.out.println();

            } else if (seeAnswer.equals("g")) {
                System.out.print("Enter the number of the guess you want to see (1-" + numtrie + "): ");
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
                arrayNumtrie.add(numtrie);
                numWin++;
                win = "true";
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
                win = "false";
                arrayNumtrie.add(numtrie);
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