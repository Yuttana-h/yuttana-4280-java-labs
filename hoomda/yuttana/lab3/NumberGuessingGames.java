package hoomda.yuttana.lab3;

import java.util.Scanner;
/*this program is numberGuessingGame 
 *input number for guessing by create method
 *out put is should be
 *Enter the min value:<inputMinValue>
 *Enter the max value:<inputMaxValue>
 *Enter the maximum number of tries:<inputMaxtriesNumber>
 *Welcome to a number guessing game!
 *Enter an integer between 1 and 5 :1
 *Try a higher number!
 *Enter an integer between 1 and 5 :2
 *Try a higher number!
 *You have tried <maxtriesNumber> times. You ran out of guesses
 *The answer is 5
 *Want to play again? (Y or y):y
  play game loop again...
 *if Want to play again? (Y or y):a
 *Thank you for playing our games. Bye!

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 6/12/2023
 */

public class NumberGuessingGames {
    static int answer, min, max, maxTries;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean play;
        // game play loop
        do {
            configure();
            genAnswer();
            playGame();

            System.out.print("Want to play again? (Y or y):");
            String response = input.next().toLowerCase();
            if (response.equals("y")) {
                play = true;
            } else {
                System.out.println("Thank you for playing our games. Bye!");
                play = false;
            }
        } while (play);
        input.close();
    }

    public static void configure() {

        System.out.print("Enter the min value:");
        min = input.nextInt();

        System.out.print("Enter the max value:");
        max = input.nextInt();

        // if max < min input max again until max > min
        while (max < min) {
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }

        // if maxtries <= 0 input again until maxtries > 0. out of loop
        do {
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
            if (maxTries <= 0) {
                System.out.println("The maximum number of tries must be greater than 0");
            }
        } while (maxTries <= 0);
    }

    public static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void playGame() {
        System.out.println("Welcome to a number guessing game!");
        // for loop in number for guessing
        for (int i = 1; i <= maxTries; i++) {
            System.out.print("Enter an integer between " + min + " and " + max + " :");
            int inputNum = input.nextInt();

            if (inputNum == answer) {
                System.out.println("Congratulations");
                if (i == 1) {
                    System.out.print("You have tried 1 time");
                } else {
                    System.out.print("You have tried " + i + " times");
                }
                break;
            } else if (inputNum < min || inputNum > max) {
                System.out.println("The number must between " + min + " and " + max);
            } else if (inputNum > answer) {
                System.out.println("Try a lower number!");
            } else if (inputNum < answer) {
                System.out.println("Try a higher number!");
            }

            if (i == maxTries) {
                // print if the player guesses wrong
                System.out.println("You have tried " + maxTries + " times. You ran out of guesses");
                System.out.println("The answer is " + answer);
            }
        }
    }
}
