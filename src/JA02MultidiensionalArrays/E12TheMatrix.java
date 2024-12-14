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

        char[][] matrix = new char[rows][cols];

        populateCharMatrix(matrix, scanner);

        char fillChar = scanner.nextLine().charAt(0);

        int[] startPositions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int startRow = startPositions[0];
        int startCol = startPositions[1];

        char startChar = matrix[startRow][startCol];

        floodFill(matrix, startRow, startCol, startChar, fillChar);

        printMatrix(matrix);
    }

    private static void floodFill(char[][] matrix, int row, int col, char startChar, char fillChar) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return;
        }

        if (matrix[row][col] != startChar) {
            return;
        }

        matrix[row][col] = fillChar;

        floodFill(matrix, row - 1, col, startChar, fillChar);
        floodFill(matrix, row + 1, col, startChar, fillChar);
        floodFill(matrix, row, col - 1, startChar, fillChar);
        floodFill(matrix, row, col + 1, startChar, fillChar);
    }

    private static void populateCharMatrix(char[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.next().charAt(0);
            }
            scanner.nextLine();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}