package hoomda.yuttana.lab3;
import java.util.Scanner;
/*this program is numberGuessingGame 
 *input number for guessing 5 times by create method
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
 *

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 1/12/2023
 */

public class NumberGuessingMethodGame {
    static int answer;
    final static int min = 1;
    final static int max = 20;

    public static void main(String[] args) {
        // call method
        genAnswer();
        playGame();
    }

    public static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void playGame() {
        System.out.println("Welcome to a number guessing game!");
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        // while loop input answer 5 times
        while (i < 6) {
            System.out.print("Enter an integer between 1 and 20:");
            int inputNum = scanner.nextInt();

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
            } else {
                System.out.println("Try a higher number!");
            }
            //plyer guess wrong
            if (i == 5) {
                System.out.println("You have tried 5 times. You ran out of guesses");
                System.out.println("The answer is " + answer);
            }
            i++;
        }
        scanner.close();

    }
}
