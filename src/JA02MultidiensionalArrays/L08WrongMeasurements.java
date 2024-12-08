package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L08WrongMeasurements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();

        int[][] matrix = new int[rows][];

        populateMatrix(rows, scanner, matrix);

        int[] wrongValuePosition = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int wrongRow = wrongValuePosition[0];
        int wrongCol = wrongValuePosition[1];

        int wrongValue = matrix[wrongRow][wrongCol];

        int[][] resultMatrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            resultMatrix[i] = matrix[i].clone();    // Creates a new copy of the array
        }

        // Replace all occurrences of the wrong value with their own adjacent sums
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == wrongValue) {
                    resultMatrix[row][col] = calculateAdjacentSum(matrix, row, col, wrongValue);
                }
            }
        }

        printMatrix(resultMatrix);
    }

    private static void populateMatrix(int rows, Scanner scanner, int[][] matrix) {
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
    }

    private static int calculateAdjacentSum(int[][] matrix, int row, int col, int wrongValue) {
        int sum = 0;
        int rows = matrix.length;
        int cols = matrix[row].length;

        if (row > 0 && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }

        if (row < rows - 1 && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }

        if (col > 0 && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }

        if (col < cols - 1 && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }

        return sum;
    }

    private static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            for (int col = 0; col < row.length; col++) {

                System.out.print(row[col] + " ");
            }
            System.out.println();
        }
    }
}