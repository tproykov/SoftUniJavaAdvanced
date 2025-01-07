package JA12Exam;

import java.util.Scanner;

public class E02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];
        int playerRowPosition = 0;
        int playerColPosition = 0;

        for (int row = 0; row < matrixSize; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'X') {
                    playerRowPosition = row;
                    playerColPosition = col;
                    matrix[row][col] = 'O';
                }
            }
        }

        String command;
        while (!"end".equals(command = scanner.nextLine())) {

            int playerOldRowPosition = playerRowPosition;
            int playerOldColPosition = playerColPosition;


            switch (command) {
                case "up" -> playerRowPosition--;
                case "down" -> playerRowPosition++;
                case "left" -> playerColPosition--;
                case "right" -> playerColPosition++;
            }




        }



    }

    public static boolean isOutOfBounds(int matrixSize, int playerRowPosition, int playerColPosition) {
        return playerRowPosition >= matrixSize || playerColPosition >= matrixSize
                || playerRowPosition < 0 || playerColPosition < 0;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(chars[col]);
            }
        }
        System.out.println();
    }
}