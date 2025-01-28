package JA11ExamPreparation.E14_22_Oct_2022;

import java.util.Scanner;

public class E02RallyRacing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int carNumber = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        fillMatrix(matrix, scanner);

        int[] tunnelCoordinates = getTunnelCoordinates(matrix);

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

            char currentCell = matrix[carRowPosition][carColPosition];

            if (currentCell == 'F') {
                distance += 10;
                finishReached = true;
                break;
            } else if (currentCell == 'T') {
                if (carRowPosition == tunnelCoordinates[0] && carColPosition == tunnelCoordinates[1]) {
                    carRowPosition = tunnelCoordinates[2];
                    carColPosition = tunnelCoordinates[3];
                } else {
                    carRowPosition = tunnelCoordinates[0];
                    carColPosition = tunnelCoordinates[1];
                }
                distance += 30;
                matrix[tunnelCoordinates[0]][tunnelCoordinates[1]] = '.';
                matrix[tunnelCoordinates[2]][tunnelCoordinates[3]] = '.';
            } else {
                distance += 10;
            }
        }

        matrix[carRowPosition][carColPosition] = 'C';

        if (finishReached) {
            System.out.println("Racing car " + carNumber + " finished the stage!");
        } else {
            System.out.println("Racing car " + carNumber + " DNF.");
        }
        System.out.println("Distance covered " + distance + " km.");
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
        boolean firstFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'T') {
                    if (!firstFound) {
                        tunnelCoordinates[0] = row;
                        tunnelCoordinates[1] = col;
                        firstFound = true;
                    } else {
                        tunnelCoordinates[2] = row;
                        tunnelCoordinates[3] = col;
                        return tunnelCoordinates;
                    }
                }
            }
        }
        return tunnelCoordinates;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}