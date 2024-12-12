package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E10RadioactiveMutantBunnies {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] lairDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = lairDimensions[0];
        int columns = lairDimensions[1];

        char[][] lair = new char[rows][columns];

        int playerRowPosition = 0;
        int playerColumnPosition = 0;
        boolean playerWon = false;
        boolean playerDied = false;

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < columns; j++) {
                char character = line.charAt(j);
                if (character == 'P') {
                    playerRowPosition = i;
                    playerColumnPosition = j;
                }
                lair[i][j] = character;
            }
        }

        char[] directions = scanner.nextLine().toCharArray();

        for (char direction : directions) {

            int playerNewRowPosition = playerRowPosition;
            int playerNewColumnPosition = playerColumnPosition;

            switch (direction) {

                case 'R' -> {
                    playerNewColumnPosition++;
                    if (!isInside(lair, playerRowPosition, playerNewColumnPosition)) {
                        lair[playerRowPosition][playerColumnPosition] = '.';
                        playerWon = true;
                    }
                    else if (steppedOnBunny(lair, playerRowPosition, playerNewColumnPosition)) {
                        lair[playerRowPosition][playerColumnPosition] = '.';
                        playerDied = true;
                    }
                    else {
                        playerColumnPosition = playerNewColumnPosition;
                    }
                }

                case 'L' -> {
                    playerNewColumnPosition--;
                    if (!isInside(lair, playerRowPosition, playerNewColumnPosition)) {
                        lair[playerRowPosition][playerColumnPosition] = '.';
                        playerWon = true;
                    }
                    else if (steppedOnBunny(lair, playerRowPosition, playerNewColumnPosition)) {
                        lair[playerRowPosition][playerColumnPosition] = '.';
                        playerDied = true;
                    }
                    else {
                        playerColumnPosition = playerNewColumnPosition;
                    }
                }

                case 'U' -> {
                    playerNewRowPosition--;
                    if (!isInside(lair, playerNewRowPosition, playerColumnPosition)) {
                        lair[playerRowPosition][playerColumnPosition] = '.';
                        playerWon = true;
                    }
                    else if (steppedOnBunny(lair, playerNewRowPosition, playerColumnPosition)) {
                        lair[playerRowPosition][playerColumnPosition] = '.';
                        playerDied = true;
                    }
                    else {
                        playerRowPosition = playerNewRowPosition;
                    }
                }

                case 'D' -> {
                    playerRowPosition++;
                    if (!isInside(lair, playerNewRowPosition, playerColumnPosition)) {
                        lair[playerRowPosition][playerColumnPosition] = '.';
                        playerWon = true;
                    }
                    else if (steppedOnBunny(lair, playerNewRowPosition, playerColumnPosition)) {
                        lair[playerRowPosition][playerColumnPosition] = '.';
                        playerDied = true;
                    }
                    else {
                        playerRowPosition = playerNewRowPosition;
                    }
                }
            }

            if (playerWon) {
                printLair(lair);
                System.out.print("won: ");
                System.out.print(playerRowPosition + " " + playerColumnPosition);
                return;
            }

            if (playerDied) {
                printLair(lair);
                System.out.print("dead: ");
                System.out.print(playerRowPosition + " " + playerColumnPosition);
                return;
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {

                    if (lair[row][col] == 'B') {

                        for (int bunnyRow = row - 1; bunnyRow <= row + 1; bunnyRow++) {
                            if (isInside(lair, bunnyRow, col)) {
                                if (steppedOnPlayer(lair, bunnyRow, col)) {
                                    playerDied = true;
                                }
                                lair[bunnyRow][col] = 'B';
                            }
                        }
                        for (int bunnyCol = col - 1; bunnyCol <= col + 1; bunnyCol++) {
                            if (isInside(lair, bunnyCol, row)) {
                                if (steppedOnPlayer(lair, row, bunnyCol)) {
                                    playerDied = true;
                                }
                                lair[row][bunnyCol] = 'B';
                            }
                        }
                    }

                    if (playerDied) {
                        printLair(lair);
                        System.out.print("died: ");
                        System.out.print(playerRowPosition + " " + playerColumnPosition);
                        return;
                    }
                }
            }
        }
    }

    private static boolean isInside(char[][] lairs, int row, int column) {
        return row >= 0 && row < lairs.length && column >= 0 && column < lairs[0].length;
    }

    private static boolean steppedOnBunny(char[][] lair, int row, int column) {
        return lair[row][column] == 'B';
    }

    private static boolean steppedOnPlayer(char[][] lair, int row, int column) {
        return lair[row][column] == 'P';
    }

    private static void printLair(char[][] lair) {
        for (char[] row : lair) {
            for (char character : row) {
                System.out.print(character + "");
            }
            System.out.println();
        }
    }
}