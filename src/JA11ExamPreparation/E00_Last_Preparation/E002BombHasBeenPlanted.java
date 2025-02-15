package JA11ExamPreparation.E00_Last_Preparation;

import java.util.Arrays;
import java.util.Scanner;

public class E002BombHasBeenPlanted {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int matrixRows = matrixDimensions[0];
        int matrixColumns = matrixDimensions[1];

        char[][] matrix = new char[matrixRows][matrixColumns];

        fillMatrix(matrix, matrixRows, matrixColumns, scanner);

        int[] counterTerroristPosition = findCounterTerroristPosition(matrix);
        int counterTerroristRowPosition = counterTerroristPosition[0];
        int counterTerroristColumnPosition = counterTerroristPosition[1];
        matrix[counterTerroristRowPosition][counterTerroristColumnPosition] = '*';

        int timeRemaining = 16;
        while (timeRemaining > 0) {

            String command = scanner.nextLine();


            switch (command) {
                case "up" -> counterTerroristRowPosition--;
                case "down" -> counterTerroristRowPosition++;
                case "left" -> counterTerroristColumnPosition--;
                case "right" -> counterTerroristColumnPosition++;
            }

            if (isOutOfBound(matrixRows, matrixColumns, counterTerroristRowPosition, counterTerroristColumnPosition)) {
                continue;
            }



            timeRemaining--;
        }

    }

    private static boolean isOutOfBound(int matrixRows, int matrixColumns, int counterTerroristRowPosition, int counterTerroristColumnPosition) {
        return counterTerroristRowPosition < 0 || counterTerroristColumnPosition < 0
                || counterTerroristRowPosition >= matrixRows || counterTerroristColumnPosition >= matrixColumns;
    }

    private static void fillMatrix(char[][] matrix, int matrixRows, int matrixColumns, Scanner scanner) {
        for (int i = 0; i < matrixRows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < matrixColumns; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }

    private static int[] findCounterTerroristPosition(char[][] matrix) {
        int[] counterTerroristPosition  = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'C') {
                    counterTerroristPosition[0] = i;
                    counterTerroristPosition[1] = j;
                }
            }
        }
        return counterTerroristPosition;
    }
}