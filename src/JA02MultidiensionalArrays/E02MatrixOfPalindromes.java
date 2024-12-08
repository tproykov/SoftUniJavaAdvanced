package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E02MatrixOfPalindromes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        String[][] matrix = new String[rows][cols];

        populateMatrixPalindromes(matrix);

        printMatrix(matrix);
    }

    private static void populateMatrixPalindromes(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                char character1 = (char) (97 + row);
                char character2 = (char) (97 + row + col);
                char character3 = (char) (97 + row);

                matrix[row][col] = "" + character1 + character2 + character3;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
