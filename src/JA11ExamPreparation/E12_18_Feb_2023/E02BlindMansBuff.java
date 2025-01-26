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
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                playGround[i][j] = row[j].charAt(0);
                if (playGround[i][j] == 'B') {
                    playerRowPosition = i;
                    playerColPosition = j;
                }
            }
        }

        int peopleTouched = 0;
        int movesMade = 0;
        String command;

        while (!"Finish".equals(command = scanner.nextLine())) {
            int playerRowOldPosition = playerRowPosition;
            int playerColOldPosition = playerColPosition;

            switch (command) {
                case "up" -> playerRowPosition--;
                case "down" -> playerRowPosition++;
                case "left" -> playerColPosition--;
                case "right" -> playerColPosition++;
            }

            if (isOutOfBounds(rows, cols, playerRowPosition, playerColPosition)) {
                playerRowPosition = playerRowOldPosition;
                playerColPosition = playerColOldPosition;
                continue;
            }

            if (playGround[playerRowPosition][playerColPosition] == 'O') {
                playerRowPosition = playerRowOldPosition;
                playerColPosition = playerColOldPosition;
                continue;
            }

            playGround[playerRowOldPosition][playerColOldPosition] = '-';

            if (playGround[playerRowPosition][playerColPosition] == 'P') {
                peopleTouched++;
            }

            if (playGround[playerRowPosition][playerColPosition] != 'O') {
                movesMade++;
            }

            playGround[playerRowPosition][playerColPosition] = 'B';

            if (peopleTouched == 3) {
                break;
            }
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n", peopleTouched, movesMade);
    }

    private static boolean isOutOfBounds(int rows, int cols, int playerRowPosition, int playerColPosition) {
        return playerRowPosition >= rows || playerColPosition >= cols || playerRowPosition < 0
                || playerColPosition < 0;
    }
}