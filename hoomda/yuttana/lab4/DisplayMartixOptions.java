import java.util.Scanner;
/*this program is loop of DisplayMatrix with 5 choice
 **choice = 1 ---> User input matrix
 **choice = 2 ---> Random numbers 0 - 9
 **choice = 3 ---> Matrix is all 0
 **choice = 4 ---> Matrix is all 1
 **choice = 5 ---> Display diagonal matrix ; Row = Column
 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 22/12/2023
 */

public class DisplayMartixOptions {
    static Scanner input = new Scanner(System.in);
    static int choice, row, column, randomValue, diagonalValue;
    static int[][] matrixValue;

    public static void main(String[] args) {
        while (true) {
            selectOption();
            configure();
            process();
            displayMartix();
        }
    }

    public static void selectOption() {
        System.out.println("Select matrix initialization method:");
        System.out.println("1. User Input");
        System.out.println("2. Random Numbers");
        System.out.println("3. All Zeros");
        System.out.println("4. All Ones");
        System.out.println("5. Diagonal Matrix");

        System.out.print("Enter choice (1-5): ");
        choice = input.nextInt();
    }

    public static void configure() {
        // For diagonal matrix, prompt the user for the number of rows and columns
        if (choice == 5) {
            System.out.print("Enter the number of rows and columns for diagonal matrix: ");
            diagonalValue = input.nextInt();
            row = diagonalValue;
            column = diagonalValue;
        } else {
            // For other options, prompt the user for the number of rows and columns
            // separately
            System.out.print("Enter the number of rows: ");
            row = input.nextInt();
            while (true) {
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
                if (column > 0) {
                    break;
                } else {
                    System.out.println(
                            "Enter the number of columns: Both rows and columns must be greater than 0. Please try again.");
                    System.out.print("Enter the number of columns: ");
                    column = input.nextInt();
                }
            }
        }

        matrixValue = new int[row][column];
    }

    public static void process() {
        if (choice == 1) {
            // User input
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    System.out.print("Enter element [" + r + "][" + c + "]: ");
                    matrixValue[r][c] = input.nextInt();
                }
            }
        } else if (choice == 2) {
            // Random 0 - 9
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    randomValue = 0 + (int) (Math.random() * ((9 - 0) + 1));
                    matrixValue[r][c] = randomValue;
                }
            }
        } else if (choice == 3) {
            // All 0
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    matrixValue[r][c] = 0;
                }
            }
        } else if (choice == 4) {
            // All 1
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    matrixValue[r][c] = 1;
                }
            }
        } else if (choice == 5) {
            // Diagonal Matrix: Initialize the matrix with diagonal elements set to 1,
            // others set to 0
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    if (r == c) {
                        matrixValue[r][c] = 1;
                    } else {
                        matrixValue[r][c] = 0;
                    }
                }
            }
        }
    }

    public static void displayMartix() {
        System.out.println("Displaying Matrix:");
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.print(matrixValue[r][c] + " ");
            }
            System.out.println();
        }
    }
}
