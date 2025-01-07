package JA11ExamPreparation.E09_17_Jun_2023;

import java.util.Arrays;
import java.util.Scanner;

public class E092MouseInTheKitchen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int matrixRows = matrixDimensions[0];
        int matrixColumns = matrixDimensions[1];

        char[][] matrix = new char[matrixRows][matrixColumns];
        int mouseRowPosition = 0;
        int mouseColumnPosition = 0;

        for (int row = 0; row < matrixRows; row++) {
            String line = scanner.nextLine();
            for (int column = 0; column < matrixColumns; column++) {
                matrix[row][column] = line.charAt(column);
                if (matrix[row][column] == 'M') {
                    mouseRowPosition = row;
                    mouseColumnPosition = column;
                    matrix[row][column] = '*';
                }
            }
        }

        boolean catAttacks = false;

        String command;
        while (!"danger".equals(command = scanner.nextLine())) {

            int mouseOldRowPosition = mouseRowPosition;
            int mouseOldColumnPosition = mouseColumnPosition;
            matrix[mouseOldRowPosition][mouseOldColumnPosition] = '*';

            switch (command) {
                case "up" -> mouseRowPosition--;
                case "down" -> mouseRowPosition++;
                case "left" -> mouseColumnPosition--;
                case "right" -> mouseColumnPosition++;
            }

            if (isOutOfBounds(matrixRows, matrixColumns, mouseRowPosition, mouseColumnPosition)) {
                catAttacks = true;
                matrix[mouseOldRowPosition][mouseOldColumnPosition] = 'M';
                break;
            }

            





        }



    }

    public static boolean isOutOfBounds(int rows, int cols, int mouseRowPosition, int mouseColumnPosition) {
        return mouseRowPosition >= rows || mouseColumnPosition >= cols
                || mouseRowPosition < 0 || mouseColumnPosition < 0;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}