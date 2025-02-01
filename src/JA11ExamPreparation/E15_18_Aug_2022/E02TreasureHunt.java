package JA11ExamPreparation.E15_18_Aug_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02TreasureHunt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] field = new char[rows][cols];
        int playerRowPosition = 0;
        int playerColPosition = 0;

        for (int i = 0; i < rows; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                field[i][j] = tokens[j].charAt(0);
                if (field[i][j] == 'Y') {
                    playerRowPosition = i;
                    playerColPosition = j;
                }
            }
        }

        List<String> directions = new ArrayList<>();
        String command;
        while (scanner.hasNextLine() && !"Finish".equals(command = scanner.nextLine())) {
            int playerLastRowPosition = playerRowPosition;
            int playerLastColPosition = playerColPosition;

            switch (command.toLowerCase()) {  // Handle case sensitivity
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
            if (!directions.isEmpty()) {
                System.out.print("The right path is ");
                System.out.println(String.join(", ", directions));
            }
        } else {
            System.out.println("The map is fake!");
        }
    }

    public static boolean isOutOfBounds(int rows, int cols, int playerRowPosition, int playerColPosition) {
        return playerRowPosition >= rows || playerColPosition >= cols || playerRowPosition < 0
                || playerColPosition < 0;
    }
}