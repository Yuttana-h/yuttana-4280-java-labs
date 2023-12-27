package hoomda.yuttana.lab4;
/*this program is loop of DisplayMatrix 
 with 5 choices and 5 operations
 At first select choice
 **choice = 1 ---> User input matrix
 **choice = 2 ---> Random numbers 0 - 9
 **choice = 3 ---> Matrix is all 0
 **choice = 4 ---> Matrix is all 1
 **choice = 5 ---> Display diagonal matrix ; Row = Column
 Select operation (loop)
 **choose = 1 ---> Transpose matrix
 **choose = 2 ---> Display each sum row and column 
 **choose = 3 ---> Display min and max value of matrix
 **choose = 4 ---> Display matrix position[Row = Column]
 **choose = 5 ---> Exit loop of operations

 *Author : Yuttana Hoomda
 *ID : 663040428-0
 *Sec : 2

 *Update : 26/12/2023
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MartixOperations {
    static Scanner input = new Scanner(System.in);
    static int choiceOption, row, column, randomValue, diagonalValue, choiceOperation, min, max;
    static int[] sumRow, sumColumn;
    static ArrayList<Integer> diagonal = new ArrayList<>();
    static int[][] matrixValue;
    static int[][] transposeMatrix;

    public static void main(String[] args) {
        while (true) {
            selectOption();
            configure();
            processOption();
            displayMartix();
            processOperation();
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
        choiceOption = input.nextInt();
    }

    public static void configure() {
        if (choiceOption == 5) {
            // For diagonal matrix, prompt the user for the number of rows and columns
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

    public static void processOption() {
        if (choiceOption == 1) {
            // User input
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    System.out.print("Enter element [" + r + "][" + c + "]: ");
                    matrixValue[r][c] = input.nextInt();
                }
            }
        } else if (choiceOption == 2) {
            // Random 0 - 9
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    randomValue = 0 + (int) (Math.random() * ((9 - 0) + 1));
                    matrixValue[r][c] = randomValue;
                }
            }
        } else if (choiceOption == 3) {
            // All 0
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    matrixValue[r][c] = 0;
                }
            }
        } else if (choiceOption == 4) {
            // All 1
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    matrixValue[r][c] = 1;
                }
            }
        } else if (choiceOption == 5) {
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

    public static void processOperation() {
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Transpose Matrix");
            System.out.println("2. Row and Column Sum");
            System.out.println("3. Find Max/Min Value");
            System.out.println("4. Diagonal Display");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choiceOperation = input.nextInt();

            if (choiceOperation == 1) {
                // Transpose the matrix
                transposeMatrix = new int[matrixValue[0].length][matrixValue.length];
                System.out.println("Displaying Matrix:");
                for (int r = 0; r < matrixValue[0].length; r++) {
                    for (int c = 0; c < matrixValue.length; c++) {
                        transposeMatrix[r][c] = matrixValue[c][r];
                        System.out.print(transposeMatrix[r][c] + " ");
                    }
                    System.out.println();

                }
                matrixValue = transposeMatrix;

            } else if (choiceOperation == 2) {
                // Calculate and display row and column sums
                sumRow = new int[matrixValue.length];
                System.out.println("Row Sums:");
                for (int r = 0; r < matrixValue.length; r++) {
                    for (int c = 0; c < matrixValue[0].length; c++) {
                        sumRow[r] += matrixValue[r][c];
                    }
                    System.out.println("Row " + (r + 1) + ": " + sumRow[r]);
                }
                sumColumn = new int[matrixValue[0].length];
                for (int c = 0; c < matrixValue[0].length; c++) {
                    for (int r = 0; r < matrixValue.length; r++) {
                        sumColumn[c] += matrixValue[r][c];
                    }
                    System.out.println("Column " + (c + 1) + ": " + sumColumn[c]);
                }
            } else if (choiceOperation == 3) {
                max = matrixValue[0][0];
                min = matrixValue[0][0];
                for (int r = 0; r < matrixValue.length; r++) {
                    for (int c = 0; c < matrixValue[0].length; c++) {
                        if (matrixValue[r][c] > max) {
                            max = matrixValue[r][c];
                        } else if (matrixValue[r][c] < min) {
                            min = matrixValue[r][c];
                        }
                    }
                }
                System.out.println("Maximum Value: " + max);
                System.out.println("Minimum Value: " + min);

            } else if (choiceOperation == 4) {
                for (int r = 0; r < matrixValue.length; r++) {
                    for (int c = 0; c < matrixValue[0].length; c++) {
                        if (r == c) {
                            diagonal.add(matrixValue[r][c]);
                        }
                    }
                }

                System.out.println("Main Diagonal:");
                for (int i = 0; i < diagonal.size(); i++) {
                    System.out.print(diagonal.get(i) + " ");
                }
                System.out.println();
            } else if (choiceOperation == 5) {
                break;
            }
        }
    }
}
