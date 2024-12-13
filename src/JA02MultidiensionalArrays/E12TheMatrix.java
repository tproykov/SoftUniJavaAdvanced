package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E12TheMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        String[][] matrix = new String[rows][cols];

        populateStringMatrix(matrix, scanner);

        char 




    }

    private static void populateStringMatrix(String[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.next();
            }
            scanner.nextLine();
        }
    }

}
