package JA02MultidiensionalArrays;

import java.util.Scanner;

public class E03DiagonalDifference {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        populateIntegerMatrix(matrix, scanner);

        System.out.println(Math.abs(sumOfPrimaryDiagonal(matrix) - sumOfSecondaryDiagonal(matrix)));
    }

    private static void populateIntegerMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
            scanner.nextLine();
        }
    }

    private static int sumOfPrimaryDiagonal(int[][] matrix) {

        int sum = 0;
        for (int n = 0; n < matrix.length; n++) {
            sum += matrix[n][n];
        }

        return sum;
    }

    private static int sumOfSecondaryDiagonal(int[][] matrix) {

        int sum = 0;
        int counter = 0;
        for (int n = matrix.length - 1; n >= 0; n--) {
            sum += matrix[n][counter];
            counter++;
        }

        return sum;
    }
}