package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E08TheHeiganDance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        int[] playerPosition = {8, 8};
        int[][] matrix = new int[15][15];
        int playerPoints = 18500;
        double heiganPoints = 3000000;
        String winner = "";
        boolean activeCloud = false;

        String command = scanner.nextLine();
        while (true) {

            if (activeCloud) {
                playerPoints -= 3500;
                activeCloud = false;
            }

            heiganPoints -= damageToHeigan;
            if (heiganPoints <= 0) {
                winner = "player";
                break;
            }

            String[] tokens = command.split("\\s+");
            String spellType = tokens[0];
            int rowHit = Integer.parseInt(tokens[1]);
            int colHit = Integer.parseInt(tokens[2]);

            for (int row = rowHit - 1; row <= rowHit + 1; row++) {

                for (int col = colHit - 1; col <= colHit + 1; col--) {

                    if (isInside(matrix, row, col)) {
                        matrix[row][col] = 1;
                    }
                }
            }

            printMatrix(matrix);

            int playerCurrentRow = playerPosition[0];
            int playerCurrentCol = playerPosition[1];
            boolean takeTheHit = false;
            if (matrix[playerCurrentRow][playerCurrentCol] == 1) {

                if (isInside(matrix, playerCurrentRow - 1, playerCurrentCol)
                        && matrix[playerCurrentRow - 1][playerCurrentCol] == 0) {

                    playerPosition[0] = playerCurrentRow - 1;
                }
                else if (isInside(matrix, playerCurrentRow, playerCurrentCol + 1)
                        && matrix[playerCurrentRow][playerCurrentCol + 1] == 0) {

                    playerPosition[1] = playerCurrentCol + 1;
                }
                else if (isInside(matrix, playerCurrentRow + 1, playerCurrentCol)
                        && matrix[playerCurrentRow + 1][playerCurrentCol] == 0) {

                    playerPosition[0] = playerCurrentRow + 1;
                }
                else if (isInside(matrix, playerCurrentRow, playerCurrentCol - 1)
                        && matrix[playerCurrentRow][playerCurrentCol - 1] == 0) {

                    playerPosition[1] = playerCurrentCol - 1;
                }
                else {
                    takeTheHit = true;
                }
            }

            if (takeTheHit) {

                switch (spellType) {

                    case "Cloud" -> {
                        playerPoints -= 3500;
                        activeCloud = true;
                    }

                    case "Eruption" -> {
                        playerPoints -= 6000;
                    }
                }
            }

            if (playerPoints <= 0) {
                winner = "heigan";
                break;
            }

            resetMatrix(matrix);
            command = scanner.nextLine();
        }

        System.out.println(winner + ": " + heiganPoints);
        System.out.println(Arrays.toString(playerPosition));
    }

    private static boolean isInside(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

    private static void resetMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}