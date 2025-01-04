package JA11ExamPreparation.E04_22_Jun_2024;

import java.util.Scanner;

public class E042Beesy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];
        int beeRowPosition = 0;
        int beeColPosition = 0;

        for (int row = 0; row < matrixSize; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'B') {
                    beeRowPosition = row;
                    beeColPosition = col;
                    matrix[row][col] = '-';
                }
            }
        }

        int energy = 15;
        int collectedNectar = 0;
        boolean energyRestored = false;
        boolean hiveReached = false;

        while (true) {
            String command = scanner.nextLine();

            matrix[beeRowPosition][beeColPosition] = '-';

            switch (command) {
                case "up" -> beeRowPosition--;
                case "down" -> beeRowPosition++;
                case "left" -> beeColPosition--;
                case "right" -> beeColPosition++;
            }

            if (isOutOfBounds(matrixSize, beeRowPosition, beeColPosition)) {
                int[] updatedPosition = moveToOppositeSide(matrixSize, command, beeRowPosition, beeColPosition);
                beeRowPosition = updatedPosition[0];
                beeColPosition = updatedPosition[1];
            }

            if (Character.isDigit(matrix[beeRowPosition][beeColPosition])) {
                int nectar = Integer.parseInt("" + matrix[beeRowPosition][beeColPosition]);
                collectedNectar += nectar;
                matrix[beeRowPosition][beeColPosition] = '-';
            } else if (matrix[beeRowPosition][beeColPosition] == 'H') {
                matrix[beeRowPosition][beeColPosition] = 'B';
                hiveReached = true;
            }

            energy--;

            if (energy <= 0) {
                if (!energyRestored && collectedNectar >= 30) {
                    int topUpEnergy = collectedNectar - 30;
                    energy += topUpEnergy;
                    collectedNectar = 30;
                    energyRestored = true;
                } else {
                    break;
                }
            }

            if (hiveReached) {
                break;
            }
        }

        matrix[beeRowPosition][beeColPosition] = 'B';

        if (hiveReached && collectedNectar >= 30) {
            System.out.println("Great job, Beesy! The hive is full. Energy left: " + energy);
        } else if (hiveReached) {
            System.out.println("Beesy did not manage to collect enough nectar.");
        } else {
            System.out.println("This is the end! Beesy ran out of energy.");
        }

        printMatrix(matrix);
    }

    public static boolean isOutOfBounds(int matrixSize, int beeRowPosition, int beeColPosition) {
        return beeRowPosition >= matrixSize || beeColPosition >= matrixSize
                || beeRowPosition < 0 || beeColPosition < 0;
    }

    public static int[] moveToOppositeSide(int matrixSize, String command, int beeRowPosition, int beeColPosition) {
        switch (command) {
            case "up" -> beeRowPosition = matrixSize - 1;
            case "down" -> beeRowPosition = 0;
            case "left" -> beeColPosition = matrixSize - 1;
            case "right" -> beeColPosition = 0;
        }
        return new int[]{beeRowPosition, beeColPosition};
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
}