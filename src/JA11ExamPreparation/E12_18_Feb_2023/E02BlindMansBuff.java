package JA11ExamPreparation.E12_18_Feb_2023;

import java.util.Scanner;

public class E02BlindMansBuff {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] playGround = new char[rows][cols];

        int playerRowPosition = 0;
        int playerColPosition = 0;

        for (int i = 0; i < rows; i++) {
            char[] row = scanner.nextLine().replace(" ", "").toCharArray();
            for (int j = 0; j < cols; j++) {
                playGround[i][j] = row[j];
                playerRowPosition = i;
                playerColPosition = j;
                playGround[i][j] = '-';
            }
        }

        int peopleTouched = 0;
        int movesMade = 0;
        String command;
        while (!"Finish".equals(command = scanner.nextLine())) {

            int playerRowOldPosition = playerRowPosition;
            int playerColOldPosition = playerColPosition;
            playGround[playerRowOldPosition][playerColOldPosition] = '-';

            switch (command) {
                case "up" -> playerRowPosition--;
                case "down" -> playerRowPosition++;
                case "left" -> playerColPosition--;
                case "right" -> playerColPosition++;
            }

            if (isOutOfBounds(rows, cols, playerRowPosition, playerColPosition)) {
                playerRowPosition = playerRowOldPosition;
                playerColPosition = playerColOldPosition;
            }

            if (playGround[playerRowPosition][playerColPosition] == 'O') {
                playerRowPosition = playerRowOldPosition;
                playerColPosition = playerColOldPosition;
            }
            else if (playGround[playerRowPosition][playerColPosition] == '-') {
                movesMade++;
            }
            else if (playGround[playerRowPosition][playerColPosition] == 'P') {
                peopleTouched++;
                movesMade++;
                if (peopleTouched == 3) {
                    playGround[playerRowPosition][playerColPosition] = 'B';
                    break;
                }
            }
            playGround[playerRowPosition][playerColPosition] = 'B';
        }

        System.out.println("Game over!");
        System.out.println("Touched opponents: " + peopleTouched + " Moves made: " + movesMade);
    }

    private static boolean isOutOfBounds(int rows, int cols, int playerRowPosition, int playerColPosition) {
        return playerRowPosition >= rows || playerColPosition >= cols || playerRowPosition < 0
                || playerColPosition < 0;
    }

    private static void printPlayGround(char[][] playGround) {

        for (int i = 0; i < playGround.length; i++) {
            for (int j = 0; j < playGround[i].length; j++) {
                System.out.print(playGround[i][j] + "");
            }
            System.out.println();
        }
    }
}