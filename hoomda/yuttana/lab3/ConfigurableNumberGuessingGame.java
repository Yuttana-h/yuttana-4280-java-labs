package hoomda.yuttana.lab3;
import java.util.Scanner;
/*this program is numberGuessingGame
 *player can configure minValue, maxValue and maxTries
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

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 1/12/2023
 */

public class ConfigurableNumberGuessingGame {
    static int answer, min, max, numTries, maxTries;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGame();
    }

    public static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        System.out.print("Enter the max value:");
        max = input.nextInt();
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
    }

    public static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void playGame() {
        System.out.println("Welcome to a number guessing game!");
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
            } else if (inputNum > answer) {
                System.out.println("Try a lower number!");
            } else if (inputNum < answer) {
                System.out.println("Try a higher number!");
            }

            if (i == maxTries) {
                // print if player guesses wrong
                System.out.println("You have tried " +  i + " times. You ran out of guesses");
                System.out.println("The answer is " + answer);
            }
        }
        input.close();
    }
}
