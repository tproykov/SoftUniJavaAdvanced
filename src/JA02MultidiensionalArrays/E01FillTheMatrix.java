package JA02MultidiensionalArrays;

import java.util.Scanner;

public class E01FillTheMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(input[0]);
        String fillMethod = input[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        switch (fillMethod) {
            case "A" -> fillMatrixMethodA(matrix, scanner);
            case "B" -> fillMatrixMethodB(matrix, scanner);
        }

        printMatrix(matrix);
    }

    private static void fillMatrixMethodA(int[][] matrix, Scanner scanner) {

        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }

    private static void fillMatrixMethodB(int[][] matrix, Scanner scanner) {

        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {

            if (col % 2 != 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
            else {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}