package JA11ExamPreparation.E08_21_Oct_2023;

import java.util.Scanner;

public class E082FishingCompetition {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];
        int boatRowPosition = 0;
        int boatColPosition = 0;

        for (int row = 0; row < matrixSize; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'S') {
                    boatRowPosition = row;
                    boatColPosition = col;
                    matrix[row][col] = '-';
                }
            }
        }

        int fish = 0;
        boolean boatSank = false;

        String command;
        while (!"collect the nets".equals(command = scanner.nextLine())) {

            int boatOldRowPosition = boatRowPosition;
            int boatOldColPosition = boatColPosition;
            matrix[boatOldRowPosition][boatOldColPosition] = '-';

            switch (command) {
                case "up" -> boatRowPosition--;
                case "down" -> boatRowPosition++;
                case "left" -> boatColPosition--;
                case "right" -> boatColPosition++;
            }

            if (isOutOfBounds(matrixSize, boatRowPosition, boatColPosition)) {
                int[] newBoatPosition = moveToOppositeSide(matrixSize, command, boatOldRowPosition, boatOldColPosition);
                boatRowPosition = newBoatPosition[0];
                boatColPosition = newBoatPosition[1];
            }

            if (Character.isDigit(matrix[boatRowPosition][boatColPosition])) {
                fish += Integer.parseInt(String.valueOf(matrix[boatRowPosition][boatColPosition]));
                matrix[boatRowPosition][boatColPosition] = 'S';
            } else if (matrix[boatRowPosition][boatColPosition] == 'W') {
                boatSank = true;
                fish = 0;
                matrix[boatRowPosition][boatColPosition] = 'S';
                break;
            }
            else {
                matrix[boatRowPosition][boatColPosition] = 'S';
            }
        }

        if (boatSank) {
            System.out.println("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                    "Last coordinates of the ship: [" + boatRowPosition + "," + boatColPosition + "]");
        }
        else {
            if (fish >= 20) {
                System.out.println("Success! You managed to reach the quota!");
            }
            else {
                System.out.print("You didn't catch enough fish and didn't reach the quota! ");
                System.out.println("You need " + (20 - fish) + " tons of fish more.");
            }

            if (fish > 0) {
                System.out.println("Amount of fish caught: " + fish + " tons.");
            }
            printMatrix(matrix);
        }
    }

    public static int[] moveToOppositeSide(int matrixSize, String command, int boatRowPosition,
                                           int boatColPosition) {
        switch (command) {
            case "up" -> boatRowPosition = matrixSize - 1;
            case "down" -> boatRowPosition = 0;
            case "left" -> boatColPosition = matrixSize - 1;
            case "right" -> boatColPosition = 0;
        }
        return new int[]{boatRowPosition, boatColPosition};
    }

    public static boolean isOutOfBounds(int matrixSize, int boatRowPosition, int boatColPosition) {
        return boatRowPosition >= matrixSize || boatColPosition >= matrixSize
                || boatRowPosition < 0 || boatColPosition < 0;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(chars[col]);
            }
            System.out.println();
        }
    }
}