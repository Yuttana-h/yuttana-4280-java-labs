package hoomda.yuttana.lab2;
/*this program input 3 argument
 *out put is should be
 *Patient's Name: <patient_name>
 *Age: <patient_age>
 *Gender: <patient_gender>

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 28/11/2023
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        int firstNumber = Integer.parseInt(args[0]);
        int secondNumber = Integer.parseInt(args[1]);
        String operator = args[2];
        int cal = 0;
        //define error for when error equal false answer doesn't out
        boolean error = false;

        //if input argument not equals 3 print error
        if (args.length != 3 ) {
            System.err.println("Error: Please provide exactly three arguments.");
        }
        else {
            if (operator.equals("+")) {
                cal = firstNumber + secondNumber;
            }
            else if (operator.equals("-")) {
                cal = firstNumber - secondNumber;
            }
            else if (operator.equals("x")) {
                cal = firstNumber * secondNumber;
            }
            else if (operator.equals("/")) {
                // if division by zero print error
                if (secondNumber == 0) {
                    // error = true answer doesn't print
                    error = true;
                    System.err.println("Error: Division by zero is not allowed.");
                }
                else {
                    cal = firstNumber / secondNumber;
                }
            }
            else {
                error = true;
                System.err.println("Error: Invalid operator. Please use '+', '-', 'x', or '/'.");
            }
        }
        if (error == false) {
            System.out.println(args[0] + args[2] + args[1] + "=" + cal);
        }
    }
}