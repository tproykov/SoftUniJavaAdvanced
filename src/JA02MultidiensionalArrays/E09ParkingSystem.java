package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        boolean[][] occupied = new boolean[rows][cols];

        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            String[] commandParts = command.split(" ");
            int entryRow = Integer.parseInt(commandParts[0]);
            int destinationRow = Integer.parseInt(commandParts[1]);
            int destinationCol = Integer.parseInt(commandParts[2]);

            if (isRowFull(occupied[destinationRow], cols)) {
                System.out.println("Row " + destinationRow + " full");
            } else {
                int distance = calculateDistance(occupied[destinationRow], entryRow, destinationRow, destinationCol, cols);
                System.out.println(distance);
            }

            command = scanner.nextLine();
        }
    }

    private static boolean isRowFull(boolean[] row, int cols) {
        // Skip first column (index 0) as it's the entrance
        for (int col = 1; col < cols; col++) {
            if (!row[col]) {
                return false;
            }
        }
        return true;
    }

    private static int calculateDistance(boolean[] row, int entryRow, int destinationRow, int destinationCol, int cols) {
        // Base distance: vertical movement + 1 step to enter
        int distance = Math.abs(entryRow - destinationRow) + 1;

        // If desired spot is free
        if (!row[destinationCol]) {
            row[destinationCol] = true;
            return distance + destinationCol;
        }

        // Find nearest free spot efficiently
        int leftSpot = -1;
        int rightSpot = -1;

        // Check left
        for (int col = destinationCol - 1; col > 0; col--) {
            if (!row[col]) {
                leftSpot = col;
                break;
            }
        }

        // Check right
        for (int col = destinationCol + 1; col < cols; col++) {
            if (!row[col]) {
                rightSpot = col;
                break;
            }
        }

        // Determine closest spot
        int finalSpot;
        if (leftSpot == -1 && rightSpot == -1) {
            return -1; // Should never happen as we check isRowFull first
        } else if (leftSpot == -1) {
            finalSpot = rightSpot;
        } else if (rightSpot == -1) {
            finalSpot = leftSpot;
        } else {
            int leftDistance = destinationCol - leftSpot;
            int rightDistance = rightSpot - destinationCol;
            finalSpot = (leftDistance <= rightDistance) ? leftSpot : rightSpot;
        }

        row[finalSpot] = true;
        return distance + finalSpot;
    }
}