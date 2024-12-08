package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E05MatrixShuffling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        String[][] matrix = new String[rows][cols];

        populateStringMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            String[] tokens = command.split("\\s+");

            if (tokens.length != 5) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            String commandName = tokens[0];
            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

            if (commandName.equals("swap") && row1 >= 0 && row2 >= 0 && col1 >= 0 && col2 >= 0
                    && row1 < matrix.length && col1 < matrix[0].length && row2 < matrix.length
                    && col2 < matrix[0].length) {

                String stringToSwap = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = stringToSwap;

                printMatrix(matrix);
            }
            else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }
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

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}