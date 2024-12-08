package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L01CompareMatrices {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensionsMatrix1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rowsMatrix1 = dimensionsMatrix1[0];
        int colsMatrix1 = dimensionsMatrix1[1];

        int[][] matrix1 = new int[rowsMatrix1][colsMatrix1];

        populateIntegerMatrix(matrix1, scanner);

        int[] dimensionsMatrix2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rowsMatrix2 = dimensionsMatrix2[0];
        int colsMatrix2 = dimensionsMatrix2[1];

        int[][] matrix2 = new int[rowsMatrix2][colsMatrix2];

        populateIntegerMatrix(matrix2, scanner);

        if (compareIntegerMatrices(matrix1, matrix2)) {
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }
    }

    private static void populateIntegerMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
            scanner.nextLine();
        }
    }

    private static boolean compareIntegerMatrices(int[][] matrix1, int[][] matrix2) {

        if (matrix1.length != matrix2.length) {
            return false;
        }

        for (int row = 0; row < matrix1.length; row++) {
            if (matrix1[row].length != matrix2[row].length) {
                return false;
            }
        }

        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                if (matrix1[row][col] != matrix2[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}