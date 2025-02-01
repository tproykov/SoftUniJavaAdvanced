package JA11ExamPreparation.E15_18_Aug_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02TreasureHunt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] field = readField(scanner, rows);
        int playerRowPosition = 0;
        int playerColPosition = 0;

        for (int i = 0; i < rows; i++) {
            field[i] = scanner.nextLine().replace(" ", "").toCharArray();
        }

        List<String> directions = new ArrayList<>();
        String command;
        while (!"Finish".equals(command = scanner.nextLine())) {

            int playerLastRowPosition = playerRowPosition;
            int playerLastColPosition = playerColPosition;

            switch (command) {
                case "up" -> playerRowPosition--;
                case "down" -> playerRowPosition++;
                case "left" -> playerColPosition--;
                case "right" -> playerColPosition++;
            }

            if (isOutOfBounds(rows, cols, playerRowPosition, playerColPosition)) {
                playerRowPosition = playerLastRowPosition;
                playerColPosition = playerLastColPosition;
                continue;
            }

            if (field[playerRowPosition][playerColPosition] == 'T') {
                playerRowPosition = playerLastRowPosition;
                playerColPosition = playerLastColPosition;
                continue;
            }

            directions.add(command);
        }

        if (field[playerRowPosition][playerColPosition] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.println(String.join(", ", directions));
        } else {
            System.out.println("The map is fake!");
        }
    }

    public static char[][] readField(Scanner scanner, int rows) {
        char[][] field = new char[rows][];
        for (int i = 0; i < rows; i++) {
            field[i] = scanner.nextLine().replace(" ", "").toCharArray();
        }
        return field;
    }

    private static String[] readDirections(Scanner scanner) {
        String command = scanner.nextLine();
        List<String> directions = new ArrayList<>();
        while (!"Finish".equals(command)) {
            directions.add(command);
        }
        return directions.toArray(String[]::new);
    }

    private static boolean isOutOfBounds(int rows, int cols, int playerRowPosition, int playerColPosition) {
        return playerRowPosition >= rows || playerColPosition >= cols || playerRowPosition < 0
                || playerColPosition < 0;
    }

    private static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + "");
            }
            System.out.println();
        }
    }
}