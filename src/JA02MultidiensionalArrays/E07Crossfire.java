package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E07Crossfire {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        int[][] matrix = new int[rows][cols];

        populateTheMatrix(matrix);

        String command;
        while (!"Nuke it from orbit".equals(command = scanner.nextLine())) {

            int[] commandParts = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = commandParts[0];
            int col = commandParts[1];
            int radius = commandParts[2];





        }





        printTheMatrix(matrix);

    }

    private static void populateTheMatrix(int[][] matrix) {

        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }

    private static void printTheMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}