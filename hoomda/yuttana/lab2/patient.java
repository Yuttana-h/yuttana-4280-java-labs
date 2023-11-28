package hoomda.yuttana.lab2;
/*this program input 3 argument
 *out put is should be
 *Patient's Name: <patient_name>
 *Age: <patient_age>
 *Gender: <patient_gender>

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 24/11/2023
 */

public class patient {

    public static void main(String[] args) {
        // Check arguments. if input 3 arguments display patient information
        if (args.length == 3) {
            System.out.println("Patient's Name: " + args[0]);
            System.out.println("Age: " + args[1]);
            System.out.println("Gender: " + args[2]);
            // if argument not equal 3 message error
        } else {
            System.err.println("Error: Invalid umber of arguments. Please provide exactly three arguments");
        }
    }
}