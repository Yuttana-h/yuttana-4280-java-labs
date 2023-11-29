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
        //if input argument not equals 3 print error
        if (args.length != 3 ) {
            System.err.println("Error: Please provide exactly three arguments.");
        }
        else {
            int firstNumber = Integer.parseInt(args[0]);
            int secondNumber = Integer.parseInt(args[1]);
            String operator = args[2];
            int cal = 0;

            if (operator.equals("+")) {
                cal = firstNumber + secondNumber;
                System.out.println(args[0] + args[2] + args[1] + "=" + cal);
            }
            else if (operator.equals("-")) {
                cal = firstNumber - secondNumber;
                System.out.println(args[0] + args[2] + args[1] + "=" + cal);
            }
            else if (operator.equals("x")) {
                cal = firstNumber * secondNumber;
                System.out.println(args[0] + args[2] + args[1] + "=" + cal);
            }
            else if (operator.equals("/")) {
                // if division by zero print error
                if (secondNumber == 0) {
                    System.err.println("Error: Division by zero is not allowed.");
                }
                else {
                    cal = firstNumber / secondNumber;
                    System.out.println(args[0] + args[2] + args[1] + "=" + cal);
                }
            }
            else {
                System.err.println("Error: Invalid operator. Please use '+', '-', 'x', or '/'.");
            }
        }
        
    }
}