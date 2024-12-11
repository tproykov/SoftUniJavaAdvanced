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

        int[][] matrix = new int[rows][cols];

        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            String[] commandParts = command.split(" ");
            int entryRow = Integer.parseInt(commandParts[0]);
            int destinationRow = Integer.parseInt(commandParts[1]);
            int destinationCol = Integer.parseInt(commandParts[2]);

            if (isRowFull(matrix, destinationRow)) {
                System.out.println("Row " + destinationRow + " full");
            } else {
                int distance = calculateDistance(matrix, entryRow, destinationRow, destinationCol);
                System.out.println(distance);
            }

            command = scanner.nextLine();
        }
    }

    private static boolean isRowFull(int[][] matrix, int row) {
        for (int col = 1; col < matrix[row].length; col++) {
            if (matrix[row][col] == 0) {
                return false;
            }
        }
        return true;
    }

    private static int calculateDistance(int[][] matrix, int entryRow, int destinationRow, int destinationCol) {
        // Initial distance is the steps from entry to the row + 1 step to enter
        int distance = Math.abs(entryRow - destinationRow) + 1;

        // If desired spot is free
        if (matrix[destinationRow][destinationCol] == 0) {
            matrix[destinationRow][destinationCol] = 1;
            return distance + destinationCol;
        }

        // Find nearest free spot
        int nearestSpot = findNearestFreeSpot(matrix, destinationRow, destinationCol);
        matrix[destinationRow][nearestSpot] = 1;
        return distance + nearestSpot;
    }

    private static int findNearestFreeSpot(int[][] matrix, int row, int desiredCol) {
        int cols = matrix[row].length;

        // Search in both directions from the desired column
        for (int offset = 0; offset < cols; offset++) {
            // Check left if possible
            int leftCol = desiredCol - offset;
            if (leftCol > 0 && matrix[row][leftCol] == 0) {
                return leftCol;
            }

            // Check right if possible
            int rightCol = desiredCol + offset;
            if (rightCol < cols && matrix[row][rightCol] == 0) {
                return rightCol;
            }
        }

        return -1; // Should never reach here as we check isRowFull first
    }
}