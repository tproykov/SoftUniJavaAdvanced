package JA02MultidiensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class E07Crossfire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1) Read matrix dimensions
        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        // 2) Populate the matrix
        List<List<Integer>> matrix = new ArrayList<>();
        populateTheMatrix(matrix, rows, cols);

        // 3) Process each command
        String command;
        while (!(command = scanner.nextLine()).equals("Nuke it from orbit")) {
            int[] commandParts = Arrays.stream(command.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int targetRow = commandParts[0];
            int targetCol = commandParts[1];
            int radius = commandParts[2];

            // --- 3a) Gather all cells to remove in a Set ---
            // Using "row_col" strings in a set to avoid duplicates
            Set<String> cellsToRemove = new HashSet<>();

            // Vertical cells (same col, rows in [targetRow - radius .. targetRow + radius])
            for (int r = targetRow - radius; r <= targetRow + radius; r++) {
                if (r >= 0 && r < matrix.size()) {
                    // We only add if the column is valid for that row (check later).
                    cellsToRemove.add(r + "_" + targetCol);
                }
            }

            // Horizontal cells (same row, cols in [targetCol - radius .. targetCol + radius])
            if (targetRow >= 0 && targetRow < matrix.size()) {
                int rowSize = matrix.get(targetRow).size();
                for (int c = Math.max(targetCol - radius, 0); c <= targetCol + radius; c++) {
                    if (c >= 0 && c < rowSize) {
                        cellsToRemove.add(targetRow + "_" + c);
                    }
                }
            }

            // --- 3b) Organize removals by row ---
            // Key = row index, Value = list of column indices (to remove in descending order)
            Map<Integer, List<Integer>> removalsByRow = new HashMap<>();
            for (String cell : cellsToRemove) {
                String[] parts = cell.split("_");
                int r = Integer.parseInt(parts[0]);
                int c = Integer.parseInt(parts[1]);

                // Check if (r,c) is inside matrix bounds right now
                if (r >= 0 && r < matrix.size()) {
                    if (c >= 0 && c < matrix.get(r).size()) {
                        removalsByRow.putIfAbsent(r, new ArrayList<>());
                        removalsByRow.get(r).add(c);
                    }
                }
            }

            // --- 3c) Remove cells from each row in descending column order ---
            for (Map.Entry<Integer, List<Integer>> entry : removalsByRow.entrySet()) {
                int r = entry.getKey();
                List<Integer> colsToRemove = entry.getValue();
                // Sort columns descending so we remove from right to left
                colsToRemove.sort((a, b) -> b - a);

                List<Integer> rowData = matrix.get(r);
                for (int colIndex : colsToRemove) {
                    if (colIndex >= 0 && colIndex < rowData.size()) {
                        rowData.remove(colIndex);
                    }
                }
            }

            // --- 3d) Remove any empty rows ---
            matrix.removeIf(List::isEmpty);
        }

        // 4) Print the matrix
        printTheMatrix(matrix);
    }

    private static void populateTheMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> newRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                newRow.add(counter++);
            }
            matrix.add(newRow);
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
