package JA02MultidiensionalArrays;

import java.util.Scanner;

public class L08WrongMeasurements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read number of rows
        int rows = scanner.nextInt();

        // First scan to determine number of columns
        String firstLine = scanner.nextLine(); // consume the newline
        firstLine = scanner.nextLine();
        String[] firstRow = firstLine.trim().split("\\s+");
        int cols = firstRow.length;

        // Create and fill the matrix
        int[][] matrix = new int[rows][cols];

        // Fill first row from previously read line
        for (int j = 0; j < cols; j++) {
            matrix[0][j] = Integer.parseInt(firstRow[j]);
        }

        // Fill rest of the matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Read the values to be replaced
        int wrongValue1 = scanner.nextInt();
        int wrongValue2 = scanner.nextInt();

        // Fix the matrix
        fixMatrix(matrix, wrongValue1, wrongValue2);

        // Print the result
        printMatrix(matrix);

        scanner.close();
    }

    private static void fixMatrix(int[][] matrix, int wrongValue1, int wrongValue2) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == wrongValue1 || matrix[i][j] == wrongValue2) {
                    matrix[i][j] = calculateReplacement(matrix, i, j);
                }
            }
        }
    }

    private static int calculateReplacement(int[][] matrix, int row, int col) {
        int sum = 0;
        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check up
        if (row > 0) {
            sum += matrix[row - 1][col];
            count++;
        }

        // Check down
        if (row < rows - 1) {
            sum += matrix[row + 1][col];
            count++;
        }

        // Check left
        if (col > 0) {
            sum += matrix[row][col - 1];
            count++;
        }

        // Check right
        if (col < cols - 1) {
            sum += matrix[row][col + 1];
            count++;
        }

        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix[0].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
