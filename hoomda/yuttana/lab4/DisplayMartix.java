import java.util.ArrayList;
import java.util.Scanner;
/*this program is loop of DisplayMatrix
 *out put is should be
 *Enter the number of rows: 2
 *Enter the number of columns: 3
 *Enter element [0][0]: 1
  Enter element [0][1]: 2
  Enter element [0][2]: 3
  Enter element [1][0]: 4
  Enter element [1][1]: 5
  Enter element [1][2]: 6
  1 2 3 
  4 5 6
 *input again if row and column less than 0
  Enter the number of rows: 0
  Enter the number of rows: Both rows and columns must be greater than 0. Please try again.
  Enter the number of columns: 0
  Enter the number of columns: Both rows and columns must be greater than 0. Please try again.

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 22/12/2023
 */

public class DisplayMartix {
    static Scanner input = new Scanner(System.in);
    static int row, column, inputMartix;
    static int[][] matrixValue;

    public static void main(String[] args) {
        while (true) {
            configure();
            rowAndColumn();
            displayMartix();
        }
    }

    public static void configure() {
        System.out.print("Enter the number of rows: ");
        row = input.nextInt();

        while (true) {
            // check row > 0
            if (row > 0) {
                break;
            } else {
                System.out.println(
                        "Enter the number of rows: Both rows and columns must be greater than 0. Please try again.");
                System.out.print("Enter the number of rows: ");
                row = input.nextInt();
            }
        }

        System.out.print("Enter the number of columns: ");
        column = input.nextInt();

        while (true) {
            // check column > 0
            if (column > 0) {
                break;
            } else {
                System.out.println(
                        "Enter the number of columns: Both rows and columns must be greater than 0. Please try again.");
                System.out.print("Enter the number of columns: ");
                column = input.nextInt();
            }
        }

        matrixValue = new int[row][column];
    }

    public static void rowAndColumn() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.print("Enter element [" + r + "][" + c + "]: ");
                matrixValue[r][c] = input.nextInt();
            }
        }
    }

    public static void displayMartix() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.print(matrixValue[r][c] + " ");
            }
            System.out.println();
        }
    }
}
