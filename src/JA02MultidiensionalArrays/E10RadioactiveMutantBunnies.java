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

        char[] playerMoves = scanner.nextLine().toCharArray();

        for (char move : playerMoves) {

            int playerOldRow = playerRowPosition;
            int playerOldCol = playerColumnPosition;

            switch (move) {
                case 'R' -> playerColumnPosition++;
                case 'L' -> playerColumnPosition--;
                case 'U' -> playerRowPosition--;
                case 'D' -> playerRowPosition++;
            }

            lair[playerOldRow][playerOldCol] = '.';

            if (!isInside(lair, playerRowPosition, playerColumnPosition)) {
                playerWon = true;
                playerRowPosition = playerOldRow;
                playerColumnPosition = playerOldCol;
            } else {
                if (lair[playerRowPosition][playerColumnPosition] == 'B') {
                    playerDied = true;
                } else {
                    lair[playerRowPosition][playerColumnPosition] = 'P';
                }
            }

            char[][] newLair = new char[rows][columns];  // a lair copy for simultaneous bunny spreading
            for (int i = 0; i < rows; i++) {
                newLair[i] = Arrays.copyOf(lair[i], columns);
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    if (lair[row][col] == 'B') {

                        int[][] spreadDirections = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                        for (int[] dir : spreadDirections) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];

                            if (isInside(lair, newRow, newCol)) {
                                if (lair[newRow][newCol] == 'P') {
                                    playerDied = true;
                                }
                                newLair[newRow][newCol] = 'B';
                            }
                        }
                    }
                }
            }

            lair = newLair;

            if (playerWon) {
                printLair(lair);
                System.out.println("won: " + playerRowPosition + " " + playerColumnPosition);
                return;
            }

            if (playerDied) {
                printLair(lair);
                System.out.println("dead: " + playerRowPosition + " " + playerColumnPosition);
                return;
            }
        }
    }

    private static boolean isInside(char[][] lair, int row, int column) {
        return row >= 0 && row < lair.length && column >= 0 && column < lair[0].length;
    }

    private static void printLair(char[][] lair) {
        for (char[] row : lair) {
            for (char character : row) {
                System.out.print(character);
            }
            System.out.println();
        }
    }
}