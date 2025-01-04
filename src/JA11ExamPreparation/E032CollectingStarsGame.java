package JA11ExamPreparation;

import java.util.Scanner;

public class E032CollectingStarsGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[fieldSize][fieldSize];
        int playerRowPosition = 0;
        int playerColPosition = 0;

        for (int row = 0; row < fieldSize; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < fieldSize; col++) {
                field[row][col] = line[col].charAt(0);
                if (field[row][col] == 'P') {
                    playerRowPosition = row;
                    playerColPosition = col;
                    field[playerRowPosition][playerColPosition] = '.';
                }
            }
        }

        int stars = 2;
        boolean playerWon = false;
        while (true) {
            String command = scanner.nextLine();

            int playerPreviousRowPosition = playerRowPosition;
            int playerPreviousColPosition = playerColPosition;

            switch (command) {
                case "up" -> playerRowPosition--;
                case "down" -> playerRowPosition++;
                case "left" -> playerColPosition--;
                case "right" -> playerColPosition++;
            }

            if (isOutOfBounds(fieldSize, playerRowPosition, playerColPosition)) {
                playerRowPosition = 0;
                playerColPosition = 0;
            }

            if (field[playerRowPosition][playerColPosition] == '*') {
                stars++;
            }

            if (field[playerRowPosition][playerColPosition] == '#') {
                stars--;
                playerRowPosition = playerPreviousRowPosition;
                playerColPosition = playerPreviousColPosition;
            }

            if (stars == 0) {
                field[playerRowPosition][playerColPosition] = 'P';
                break;
            }
            else if (stars == 10) {
                playerWon = true;
                field[playerRowPosition][playerColPosition] = 'P';
                break;
            }
            else if (field[playerRowPosition][playerColPosition] == '*') {
                field[playerRowPosition][playerColPosition] = '.';
            }
        }

        if (playerWon) {
            System.out.println("You won! You have collected " + stars + " stars.");
        }
        else {
            System.out.println("Game over! You are out of any stars.");
        }

        System.out.printf("Your final position is [%d, %d]\n", playerRowPosition, playerColPosition);

        printStars(field);
    }

    private static boolean isOutOfBounds(int fieldSize, int playerRowPosition, int playerCOlPosition) {
        return playerRowPosition < 0 || playerRowPosition >= fieldSize || playerCOlPosition < 0
                || playerCOlPosition >= fieldSize;
    }

    private static void printStars(char[][] field) {
        for (char[] chars : field) {
            for (int col = 0; col < field.length; col++) {
                System.out.print(chars[col] + " ");
            }
            System.out.println();
        }
    }
}