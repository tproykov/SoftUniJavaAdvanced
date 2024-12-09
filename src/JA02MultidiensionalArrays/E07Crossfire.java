package JA02MultidiensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E07Crossfire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();
        populateTheMatrix(matrix, rows, cols);

        String command;
        while (!"Nuke it from orbit".equals(command = scanner.nextLine())) {
            int[] commandParts = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int targetRow = commandParts[0];
            int targetCol = commandParts[1];
            int radius = commandParts[2];

            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isInside(matrix, row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }

            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isInside(matrix, targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }

            matrix = removeZeroesFromMatrix(matrix);
        }

        printTheMatrix(matrix);
    }

    private static List<List<Integer>> removeZeroesFromMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> newMatrix = new ArrayList<>();

        for (List<Integer> row : matrix) {
            List<Integer> newRow = new ArrayList<>();
            for (Integer num : row) {
                if (num != 0) {
                    newRow.add(num);
                }
            }
            if (!newRow.isEmpty()) {
                newMatrix.add(newRow);
            }
        }
        return newMatrix;
    }

    private static boolean isInside(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void populateTheMatrix(List<List<Integer>> matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
        }

        int counter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter++);
            }
        }
    }

    private static void printTheMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}