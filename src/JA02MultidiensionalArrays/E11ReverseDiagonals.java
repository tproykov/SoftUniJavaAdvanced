package JA02MultidiensionalArrays;

import java.util.*;

public class E11ReverseDiagonals {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        int[][] matrix = new int[rows][cols];

        populateMatrix(rows, cols, matrix, scanner);

        int maxSum = (rows - 1) + (cols - 1);

        List<List<Integer>> diagonals = new ArrayList<>(maxSum + 1);
        for (int s = 0; s <= maxSum; s++) {
            diagonals.add(new ArrayList<>());
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                diagonals.get(i + j).add(matrix[i][j]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int s = maxSum; s >= 0; s--) {
            List<Integer> diag = diagonals.get(s);
            for (int k = diag.size() - 1; k >= 0; k--) {
                stringBuilder.append(diag.get(k));
                if (k > 0) {
                    stringBuilder.append(' ');
                }
            }
            stringBuilder.append('\n');
        }

        System.out.print(stringBuilder);
    }

    private static void populateMatrix(int rows, int cols, int[][] matrix, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
