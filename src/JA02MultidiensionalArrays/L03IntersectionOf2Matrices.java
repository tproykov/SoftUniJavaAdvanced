package JA02MultidiensionalArrays;

import java.util.Scanner;

public class L03IntersectionOf2Matrices {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] matrix1 = new String[rows][cols];
        populateStringMatrix(matrix1, scanner);

        String[][] matrix2 = new String[rows][cols];
        populateStringMatrix(matrix2, scanner);

        String[][] intersectionMatrix = new String[rows][cols];

        for (int row = 0; row < intersectionMatrix.length; row++) {
            for (int col = 0; col < intersectionMatrix[row].length; col++) {

                if (matrix1[row][col].equals(matrix2[row][col])) {
                    intersectionMatrix[row][col] = matrix1[row][col];
                }
                else {
                    intersectionMatrix[row][col] = "*";
                }
            }
        }

        printStringMatrix(intersectionMatrix);
    }

    private static void populateStringMatrix(String[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.next();
            }
            scanner.nextLine();
        }
    }

    private static void printStringMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}