package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L04SumMatrixElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = matrixDimensions[0];
        System.out.println(rows);

        int cols = matrixDimensions[1];
        System.out.println(cols);

        int[][] matrix = new int[rows][cols];

        populateIntegerMatrix(matrix, scanner);

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(sum);
    }

    private static void populateIntegerMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
    }
}
