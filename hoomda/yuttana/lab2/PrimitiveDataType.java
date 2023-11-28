package hoomda.yuttana.lab2;
/*this program is about datatype
 *out put is should be
 Student ID : 663040428-0
 First Name : Yuttana
 Byte Value : 80
 Short Value : 280
 Int Value : 404280
 Long Value : 30404280
 Float Value : 0.28
 Double Value : 0.3040428
 Char Value : Y
 Boolean Value : false

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 24/11/2023
*/
public class PrimitiveDataType {
    public static void main(String[] args) {
        String studentId = "663040428-0";
        String firstName = "Yuttana";
        Byte valueB = 80;
        Short valueS = 280;
        int valueI = 404280;
        long valueL = 30404280;
        float valueF = 0.28f;
        double valueD = 0.3040428;
        char valueC = 'Y';
        boolean valueBoo = false;

        System.out.println("Student ID : " + studentId);
        System.out.println("First Name : " + firstName);
        System.out.println("Byte Value : " + valueB);
        System.out.println("Short Value : " + valueS);
        System.out.println("Int Value : " + valueI);
        System.out.println("Long Value : " + valueL);
        System.out.println("Float Value : " + valueF);
        System.out.println("Double Value : " + valueD);
        System.out.println("Char Value : " + valueC);
        System.out.println("Boolean Value : " + valueBoo);
    }
}
