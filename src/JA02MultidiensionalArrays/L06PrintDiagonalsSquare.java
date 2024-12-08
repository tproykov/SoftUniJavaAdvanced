package JA02MultidiensionalArrays;

import java.util.Scanner;

public class L06PrintDiagonalsSquare {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        populateIntegerMatrix(matrix, scanner);

        int[] primaryDiagonal = new int[matrixSize];
        int[] secondaryDiagonal = new int[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            primaryDiagonal[i] = matrix[i][i];
        }

        int counter = 0;
        for (int i = matrixSize -1; i >= 0; i--) {
            secondaryDiagonal[counter] = matrix[i][counter];
            counter++;
        }

        for (int number : primaryDiagonal) {
            System.out.print(number + " ");
        }

        System.out.println();

        for (int number : secondaryDiagonal) {
            System.out.print(number + " ");
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
}