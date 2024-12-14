package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E12TheMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        String[][] matrix = new String[rows][cols];

        populateStringMatrix(matrix, scanner);

        char fillChar = scanner.nextLine().charAt(0);

        int[] startPositions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int startRow = startPositions[0];
        int startCol = startPositions[1];

        String startChar = matrix[startRow][startCol];

        floodFill(matrix, startRow, startCol, startChar, String.valueOf(fillChar));

        printMatrix(matrix);
    }

    private static void floodFill(String[][] matrix, int row, int col, String startChar, String fillChar) {
        // Check if current position is out of bounds
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return;
        }

        // Check if current position is not the target character
        if (!matrix[row][col].equals(startChar)) {
            return;
        }

        matrix[row][col] = fillChar;

        floodFill(matrix, row - 1, col, startChar, fillChar);
        floodFill(matrix, row + 1, col, startChar, fillChar);
        floodFill(matrix, row, col - 1, startChar, fillChar);
        floodFill(matrix, row, col + 1, startChar, fillChar);
    }

    private static void populateStringMatrix(String[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.next();
            }
            scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}