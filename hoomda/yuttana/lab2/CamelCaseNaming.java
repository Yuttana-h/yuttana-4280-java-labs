package hoomda.yuttana.lab2;
/*this program input 2 argument
 *about convert first of string to uppercase
 *out put is should be
 *Camel Case Result: XxxxxYyyyyy

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 28/11/2023
 */

public class CamelCaseNaming {
    public static void main(String[] args) {
        if (args.length == 2) {
            String firstName = args[0];
            String lastName = args[1];
            //convert first of fistrname to uppercase
            char upperFirstName = firstName.toUpperCase().charAt(0);
            //substring first of char to last of char
            String lowwerFirstName = firstName.substring(1).toLowerCase();
            String camelFirstName = upperFirstName + lowwerFirstName;

            //convert first of lastname to uppercase
            char upperLastName = lastName.toUpperCase().charAt(0);
            //substring first of char to last of char
            String lowwerLastName = lastName.substring(1).toLowerCase();
            String camelLastName = upperLastName + lowwerLastName;

            System.out.println("Camel Case Result: " + camelFirstName + camelLastName);
        }
        //if input argument it not equal 2 print error
        else {
            System.err.println("Error: Please provide exactly two arguments.");
        }
    }
}
