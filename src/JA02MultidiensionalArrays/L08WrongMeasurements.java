package JA02MultidiensionalArrays;

import java.util.Scanner;

public class L08WrongMeasurements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read number of rows
        int rows = scanner.nextInt();

        // Create matrix with same number of columns as rows
        int[][] matrix = new int[rows][];

        // Read matrix rows
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                line = scanner.nextLine().trim();
            }
            String[] numbers = line.split("\\s+");
            matrix[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        // Read position of wrong value
        int wrongRow = scanner.nextInt();
        int wrongCol = scanner.nextInt();

        // Get the wrong value from the specified position
        int wrongValue = matrix[wrongRow][wrongCol];

        // Create a new matrix for results to avoid affecting calculations
        int[][] result = new int[rows][];
        for (int i = 0; i < rows; i++) {
            result[i] = matrix[i].clone();
        }

        // Replace all occurrences of the wrong value with their own adjacent sums
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    result[i][j] = calculateAdjacentSum(matrix, i, j, wrongValue);
                }
            }
        }

        // Print result
        printMatrix(result);

        scanner.close();
    }

    private static int calculateAdjacentSum(int[][] matrix, int row, int col, int wrongValue) {
        int sum = 0;
        int rows = matrix.length;
        int cols = matrix[row].length;

        // Check up
        if (row > 0 && matrix[row-1][col] != wrongValue) {
            sum += matrix[row-1][col];
        }

        // Check down
        if (row < rows-1 && matrix[row+1][col] != wrongValue) {
            sum += matrix[row+1][col];
        }

        // Check left
        if (col > 0 && matrix[row][col-1] != wrongValue) {
            sum += matrix[row][col-1];
        }

        // Check right
        if (col < cols-1 && matrix[row][col+1] != wrongValue) {
            sum += matrix[row][col+1];
        }

        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
