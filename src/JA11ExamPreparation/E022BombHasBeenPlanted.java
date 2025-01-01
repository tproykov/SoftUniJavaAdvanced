package JA11ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class E022BombHasBeenPlanted {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];
        int initialCounterTerroristRow = 0;
        int initialCounterTerroristCol = 0;
        int counterTerroristRowPosition = 0;
        int counterTerroristColumnPosition = 0;


        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'C') {
                    initialCounterTerroristRow = row;
                    initialCounterTerroristCol = col;
                    counterTerroristRowPosition = row;
                    counterTerroristColumnPosition = col;
                    matrix[row][col] = '*';

                }
            }
        }

        int timeLeft = 16;
        int moreTimeNeeded = 0;
        boolean bombExplodes = false;
        boolean bombDefused = false;
        boolean bombNotDefused = false;
        boolean counterTerroristKilled = false;
        boolean startedDefusing = false;
        boolean timeRanOut = false;

        while (true) {
            if (timeLeft <= 0) {
                bombExplodes = true;
                timeRanOut = true;
                break;
            }

            String command = scanner.nextLine();

            if (command.equals("defuse")) {
                if (matrix[counterTerroristRowPosition][counterTerroristColumnPosition] == 'B') {
                    startedDefusing = true;
                    if (timeLeft >= 4) {
                        timeLeft -= 4;
                        bombDefused = true;
                        matrix[counterTerroristRowPosition][counterTerroristColumnPosition] = 'D';
                        break;
                    } else {
                        bombNotDefused = true;
                        moreTimeNeeded = 4 - timeLeft;
                        matrix[counterTerroristRowPosition][counterTerroristColumnPosition] = 'X';
                        break;
                    }
                } else {
                    timeLeft -= 2;
                    continue;
                }
            }

            int counterTerroristPreviousRowPosition = counterTerroristRowPosition;
            int counterTerroristPreviousColumnPosition = counterTerroristColumnPosition;

            switch (command) {
                case "up" -> counterTerroristRowPosition--;
                case "down" -> counterTerroristRowPosition++;
                case "left" -> counterTerroristColumnPosition--;
                case "right" -> counterTerroristColumnPosition++;
            }

            if (isOutOfBounds(rows, cols, counterTerroristRowPosition, counterTerroristColumnPosition)) {
                counterTerroristRowPosition = counterTerroristPreviousRowPosition;
                counterTerroristColumnPosition = counterTerroristPreviousColumnPosition;
                timeLeft--;
                continue;
            }

            if (matrix[counterTerroristRowPosition][counterTerroristColumnPosition] == 'T') {
                matrix[counterTerroristRowPosition][counterTerroristColumnPosition] = '*';
                counterTerroristKilled  = true;
                break;
            }

            timeLeft--;
        }

        if (bombExplodes) {
            System.out.println("Terrorists win!");
            System.out.println("Bomb was not defused successfully!");
            int neededTime = startedDefusing ? 4 : 0;
            System.out.println("Time needed: " + neededTime + " second/s.");
        }

        if (bombNotDefused) {
            System.out.println("Terrorists win!");
            System.out.println("Bomb was not defused successfully!");
            System.out.println("Time needed: " + moreTimeNeeded + " second/s.");
        }

        if (bombDefused) {
            System.out.println("Counter-terrorist wins!");
            System.out.println("Bomb has been defused: " + timeLeft + " second/s remaining.");
        }

        if (counterTerroristKilled) {
            System.out.println("Terrorists win!");
        }

        matrix[initialCounterTerroristRow][initialCounterTerroristCol] = 'C';

        printMatrix(matrix);
    }

    private static boolean isOutOfBounds(int rows, int cols, int counterTerroristRowPosition,
                                  int counterTerroristColumnPosition) {

        return counterTerroristRowPosition < 0 || counterTerroristRowPosition >= rows
                || counterTerroristColumnPosition < 0 || counterTerroristColumnPosition >= cols;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}