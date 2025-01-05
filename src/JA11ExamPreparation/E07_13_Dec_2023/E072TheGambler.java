package JA11ExamPreparation.E07_13_Dec_2023;

import java.util.Scanner;

public class E072TheGambler {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];
        int gamblerRowPosition = 0;
        int gamblerColPosition = 0;

        for (int i = 0; i < matrixSize; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'G') {
                    gamblerRowPosition = i;
                    gamblerColPosition = j;
                    matrix[i][j] = '-';
                }
            }
        }

        int money = 100;
        boolean jackpot = false;
        boolean gameOver = false;

        String command;
        while (!"end".equals(command = scanner.nextLine())) {

            matrix[gamblerRowPosition][gamblerColPosition] = '-';

            switch (command) {
                case "up" -> gamblerRowPosition--;
                case "down" -> gamblerRowPosition++;
                case "left" -> gamblerColPosition--;
                case "right" -> gamblerColPosition++;
            }

            if (isOutOfBounds(matrixSize, gamblerRowPosition, gamblerColPosition)) {
                gameOver = true;
                money = 0;
                break;
            }

            matrix[gamblerRowPosition][gamblerColPosition] = 'G';

            if (matrix[gamblerRowPosition][gamblerColPosition] == 'W') {
                money += 100;
            } else if (matrix[gamblerRowPosition][gamblerColPosition] == 'P') {
                money -= 200;
            } else if (matrix[gamblerRowPosition][gamblerColPosition] == 'J') {
                jackpot = true;
                money += 100000;
                break;
            }

            if (money <= 0) {
                gameOver = true;
                break;
            }
        }


    }

    public static boolean isOutOfBounds(int matrixSize, int gamblerRowPosition, int gamblerColPosition) {
        return gamblerRowPosition >= matrixSize || gamblerColPosition >= matrixSize
                || gamblerRowPosition < 0 || gamblerColPosition < 0;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}