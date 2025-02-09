package JA11ExamPreparation.E21_18_Aug_2021;

import java.util.Scanner;

public class E02FormulaOne {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int movesNumber = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];
        fillMatrix(matrix, scanner);

        int[] playerPosition = findPlayerStartPosition(matrix);
        int playerRowPosition = playerPosition[0];
        int playerColPosition = playerPosition[1];
        matrix[playerRowPosition][playerColPosition] = '.';

        boolean finish = false;
        for (int move = 1; move < movesNumber; move++) {

            String command = scanner.nextLine();

            switch (command) {
                case "up" -> playerRowPosition--;
                case "down" -> playerRowPosition++;
                case "left" -> playerColPosition--;
                case "right" -> playerColPosition++;
            }

            if (isOutOfBound(matrix, playerRowPosition, playerColPosition)) {
                int[] teleportedPosition = teleport(matrixSize, command, playerRowPosition, playerColPosition);
                playerRowPosition = teleportedPosition[0];
                playerColPosition = teleportedPosition[1];
            }

            if (matrix[playerRowPosition][playerColPosition] == 'B') {
                switch (command) {
                    case "up" -> playerRowPosition--;
                    case "down" -> playerRowPosition++;
                    case "left" -> playerColPosition--;
                    case "right" -> playerColPosition++;
                }
                if (isOutOfBound(matrix, playerRowPosition, playerColPosition)) {
                    int[] teleportedPosition = teleport(matrixSize, command, playerRowPosition, playerColPosition);
                    playerRowPosition = teleportedPosition[0];
                    playerColPosition = teleportedPosition[1];
                }
            }

            if (matrix[playerRowPosition][playerColPosition] == 'T') {
                switch (command) {
                    case "up" -> playerRowPosition++;
                    case "down" -> playerRowPosition--;
                    case "left" -> playerColPosition++;
                    case "right" -> playerColPosition--;
                }
            }

            if (matrix[playerRowPosition][playerColPosition] == 'F') {
                finish = true;
                break;
            }
        }

        matrix[playerRowPosition][playerColPosition] = 'P';

        if (finish) {
            System.out.println("Well done, the player won first place!");
        }
        else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);


    }

    private static int[] teleport(int matrixSIze, String command, int playerRowPosition, int playerColPosition) {
        int[] teleportedPosition = new int[2];
        switch (command) {
            case "up" -> teleportedPosition[0] = matrixSIze + playerRowPosition;
            case "down" -> teleportedPosition[0] = playerRowPosition - matrixSIze;
            case "left" -> teleportedPosition[1] = matrixSIze + playerColPosition;
            case "right" -> teleportedPosition[1] = playerColPosition - matrixSIze;
        }
        return teleportedPosition;
    }

    private static boolean isOutOfBound(char[][] matrix, int playerRowPosition, int playerColPosition) {
        return playerRowPosition >= matrix.length || playerRowPosition < 0 || playerColPosition >= matrix[0].length
                || playerColPosition < 0;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }

    private static int[] findPlayerStartPosition(char[][] matrix) {
        int[] playerPosition = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'P') {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                }
            }
        }
        return playerPosition;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}