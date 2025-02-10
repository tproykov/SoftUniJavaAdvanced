package JA11ExamPreparation.E22_26_Jun_2021;

import java.util.Scanner;

public class E02Python {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int screenSize = Integer.parseInt(scanner.nextLine());

        String[] turns = scanner.nextLine().split(", ");

        char[][] screen = new char[screenSize][screenSize];

        fillScreen(screen, scanner);

        int[] pythonPosition = findPythonPosition(screen);
        int pythonRowPosition = pythonPosition[0];
        int pythonColPosition = pythonPosition[1];
        screen[pythonRowPosition][pythonColPosition] = '*';

        int length = 1;
        for ( int turn = 1; turn <= turns.length; turn++) {

            String command = turns[turn];

            switch (command) {
                case "up" -> pythonRowPosition--;
                case "down" -> pythonRowPosition++;
                case "left" -> pythonColPosition--;
                case "right" -> pythonColPosition++;
            }

            if (isOutOfBounds(screen, pythonRowPosition, pythonColPosition)) {
                teleport(pythonRowPosition, pythonColPosition, command);
            }



        }







    }

    private static boolean isOutOfBounds(char[][] screen, int pythonRowPosition, int pythonColPosition) {
        return pythonRowPosition < 0 || pythonRowPosition >= screen.length || pythonColPosition < 0
                || pythonColPosition >= screen[0].length;
    }

    private static void teleport(int pythonRowPosition, int pythonColPosition, String command) {

    }

    private static void fillScreen(char[][] screen, Scanner scanner) {
        for (int i = 0; i < screen.length; i++) {
            String line = scanner.nextLine().replace(" ", "");
            for (int j = 0; j < line.length(); j++) {
                screen[i][j] = line.charAt(j);
            }
        }
    }

    private static int[] findPythonPosition(char[][] screen) {
        int[] pythonPosition = new int[2];
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length; j++) {
                if (screen[i][j] == 's') {
                    pythonPosition[0] = i;
                    pythonPosition[1] = j;
                }
            }
        }
        return pythonPosition;
    }
}