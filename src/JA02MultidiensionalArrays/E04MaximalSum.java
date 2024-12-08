package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E04MaximalSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        int[][] matrix = new int[rows][cols];

        populateIntegerMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int startRowIndex = 0;
        int startColIndex = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = 0;
                for (int currentRow = row; currentRow < row + 3; currentRow++) {
                    for (int currentCol = col; currentCol < col + 3; currentCol++) {
                        sum += matrix[currentRow][currentCol];
                    }
                }

                if (sum > maxSum) {
                    maxSum = sum;
                    startRowIndex = row;
                    startColIndex = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printOutputMatrix(startRowIndex, startColIndex, matrix);
    }

    private static void populateIntegerMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
            scanner.nextLine();
        }
    }

    private static void printOutputMatrix(int startRowIndex, int startColIndex, int[][] matrix) {

        for (int currentRow = startRowIndex; currentRow < startRowIndex + 3; currentRow++) {
            for (int currentCol = startColIndex; currentCol < startColIndex + 3; currentCol++) {

                System.out.print(matrix[currentRow][currentCol] + " ");
            }
            System.out.println();
        }
    }
}