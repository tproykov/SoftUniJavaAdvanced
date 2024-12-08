package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L05MaxSumOfSubmatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        int[][] matrix = new int[rows][cols];

        populateIntegerMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;

        for (int row = 0; row < matrix.length - 1; row++)
            for (int col = 0; col < matrix[row].length - 1; col++) {

                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    resultRow = row;
                    resultCol = col;
                }
            }

        int[][] resultMatrix = new int[2][2];

        resultMatrix[0][0] = matrix[resultRow][resultCol];
        resultMatrix[0][1] = matrix[resultRow][resultCol + 1];
        resultMatrix[1][0] = matrix[resultRow + 1][resultCol];
        resultMatrix[1][1] = matrix[resultRow + 1][resultCol + 1];

        printIntegerMatrix(resultMatrix);
        System.out.println(maxSum);
    }

    private static void populateIntegerMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
    }

    private static void printIntegerMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}