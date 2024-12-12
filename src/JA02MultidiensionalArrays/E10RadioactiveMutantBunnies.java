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

        // Read initial lair state
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
            // Save the player's current position
            int playerOldRow = playerRowPosition;
            int playerOldCol = playerColumnPosition;

            // Move player
            switch (move) {
                case 'R' -> playerColumnPosition++;
                case 'L' -> playerColumnPosition--;
                case 'U' -> playerRowPosition--;
                case 'D' -> playerRowPosition++;
            }

            // Remove player from old position
            lair[playerOldRow][playerOldCol] = '.';

            // Check if player is out of bounds (won)
            if (!isInside(lair, playerRowPosition, playerColumnPosition)) {
                playerWon = true;
                playerRowPosition = playerOldRow;
                playerColumnPosition = playerOldCol;
            } else {
                // Check if player moved onto a bunny
                if (lair[playerRowPosition][playerColumnPosition] == 'B') {
                    playerDied = true;
                } else {
                    // Update player position on board
                    lair[playerRowPosition][playerColumnPosition] = 'P';
                }
            }

            // Create a copy of the lair for simultaneous bunny spreading
            char[][] newLair = new char[rows][columns];
            for (int i = 0; i < rows; i++) {
                newLair[i] = Arrays.copyOf(lair[i], columns);
            }

            // Spread bunnies
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    if (lair[row][col] == 'B') {
                        // Spread in all four directions
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

            // Update the lair with new bunny positions
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