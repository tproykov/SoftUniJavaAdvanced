package JA11ExamPreparation.E05_10_Apr_2024;

import java.util.Scanner;

public class E052EscapeTheMaze {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];
        int travellerRowPosition = 0;
        int travellerColPosition = 0;

        for (int i = 0; i < matrixSize; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'P') {
                    travellerRowPosition = i;
                    travellerColPosition = j;
                    matrix[j][i] = '-';
                }
            }
        }

        int health = 100;

        while (true) {

            String command = scanner.nextLine();

            switch (command) {
                case "up" -> travellerRowPosition--;
                case "down" -> travellerRowPosition++;
                case "left" -> travellerColPosition--;
                case "right" -> travellerColPosition++;
            }

            if (isOutOfBounds(matrixSize, travellerRowPosition, travellerColPosition)) {
                continue;
            }

            if (matrix[travellerRowPosition][travellerColPosition] == 'M') {
                health -= 40;
                if (health > 0) {
                    matrix[travellerRowPosition][travellerColPosition] = '-';
                }
                else {
                    health = 0;
                    matrix[travellerRowPosition][travellerColPosition] = 'P';
                    break;
                }
            }
            else if (matrix[travellerRowPosition][travellerColPosition] == 'H') {
                health += 15;
                if (health > 100) {
                    health = 100;
                }
                matrix[travellerRowPosition][travellerColPosition] = '-';
            }
            else if (matrix[travellerRowPosition][travellerColPosition] == 'X') {
                matrix[travellerRowPosition][travellerColPosition] = 'P';
                break;
            }
            else {
                matrix[travellerRowPosition][travellerColPosition] = '-';
            }
        }

        if (health <= 0) {
            System.out.println("Player is dead.Maze over!");
        }
        else {
            System.out.println("Player escaped the maze. Danger passed!");
        }

        System.out.println("Player's health: " + health + " units");

        printMatrix(matrix);
    }

    private static boolean isOutOfBounds(int matrixSize, int playerRowPosition, int playerColPosition) {
        return playerRowPosition >= matrixSize || playerColPosition >= matrixSize
                || playerRowPosition < 0 || playerColPosition < 0;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
    }
}