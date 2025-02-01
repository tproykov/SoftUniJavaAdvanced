package JA11ExamPreparation.E15_18_Aug_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read dimensions more robustly using split
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        // Create and populate field more safely
        char[][] field = new char[rows][cols];
        int playerRowPosition = 0;
        int playerColPosition = 0;

        // Read field data more reliably
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine().replace(" ", "");
            field[i] = line.toCharArray();
            // Find player position
            for (int j = 0; j < cols; j++) {
                if (field[i][j] == 'Y') {
                    playerRowPosition = i;
                    playerColPosition = j;
                }
            }
        }

        List<String> directions = new ArrayList<>();
        String command;

        while (!"Finish".equals(command = scanner.nextLine())) {
            int newRow = playerRowPosition;
            int newCol = playerColPosition;

            // Calculate new position without moving yet
            switch (command) {
                case "up" -> newRow--;
                case "down" -> newRow++;
                case "left" -> newCol--;
                case "right" -> newCol++;
            }

            // Validate move before actually moving
            if (!isOutOfBounds(rows, cols, newRow, newCol) && field[newRow][newCol] != 'T') {
                playerRowPosition = newRow;
                playerColPosition = newCol;
                directions.add(command);
            }
        }

        // Check final position
        if (field[playerRowPosition][playerColPosition] == 'X') {
            System.out.println("I've found the treasure!");
            if (!directions.isEmpty()) {
                System.out.println("The right path is " + String.join(", ", directions));
            }
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static boolean isOutOfBounds(int rows, int cols, int row, int col) {
        return row < 0 || row >= rows || col < 0 || col >= cols;
    }
}