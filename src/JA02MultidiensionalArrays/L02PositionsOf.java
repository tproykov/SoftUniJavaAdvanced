package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L02PositionsOf {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensionsMatrix = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensionsMatrix[0];
        int columns = dimensionsMatrix[1];

        int[][] matrix = new int[rows][columns];

        populateMatrix(matrix, scanner);

        int n = Integer.parseInt(scanner.nextLine());

        boolean found = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {

                if (matrix[row][column] == n) {
                    found = true;
                    System.out.println(row + " " + column);
                }
            }
        }
        if (!found) {
            System.out.println("not found");
        }
    }

    private static void populateMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
            scanner.nextLine();
        }
    }
}