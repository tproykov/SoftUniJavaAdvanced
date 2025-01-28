package JA11ExamPreparation.E14_22_Oct_2022;

import java.util.Scanner;

public class E02RallyRacing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int carNumber = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        fillMatrix(matrix, scanner);

        int[] tunnelCoordinates;
        tunnelCoordinates = getTunnelCoordinates(matrix);

        int carRowPosition = 0;
        int carColPosition = 0;

        int distance = 0;
        boolean finishReached = false;

        String command;
        while (!"End".equals(command = scanner.nextLine())) {

            matrix[carRowPosition][carColPosition] = '.';

            switch (command) {
                case "up" -> carRowPosition--;
                case "down" -> carRowPosition++;
                case "left" -> carColPosition--;
                case "right" -> carColPosition++;
            }
            if (matrix[carRowPosition][carColPosition] == '.') {
                distance += 10;
            }
            else if (carRowPosition == tunnelCoordinates[0] && carColPosition == tunnelCoordinates[1]) {
                carRowPosition = tunnelCoordinates[2];
                carColPosition = tunnelCoordinates[3];
                distance += 30;
                matrix[carRowPosition][carColPosition] = '.';
            }
            else if (carRowPosition == tunnelCoordinates[2] && carColPosition == tunnelCoordinates[3]) {
                carRowPosition = tunnelCoordinates[0];
                carColPosition = tunnelCoordinates[1];
                distance += 30;
                matrix[carRowPosition][carColPosition] = '.';
            }
            else if (matrix[carRowPosition][carColPosition] == 'F') {
                finishReached = true;
                distance += 10;
                break;
            }
        }

        matrix[carRowPosition][carColPosition] = 'C';

        if (finishReached) {
            System.out.println("Racing car " + carNumber + " finished the stage!");
            System.out.println("Distance covered: " + distance);
        }
        else {
            System.out.println("Racing car " + carNumber + " DNF.");
            System.out.println("Distance covered: " + distance);
        }

        printMatrix(matrix);
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
    }

    private static int[] getTunnelCoordinates(char[][] matrix) {
        int[] tunnelCoordinates = new int[4];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == '.') {
                    tunnelCoordinates[row] = row;
                    tunnelCoordinates[col] = col;
                }
            }
        }
        return tunnelCoordinates;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}