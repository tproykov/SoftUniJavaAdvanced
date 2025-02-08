package JA11ExamPreparation.E20_23_Oct_2021;

import java.util.Scanner;

public class E02MouseAndCheese {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int territorySize = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[territorySize][territorySize];

        fillTerritory(territory, scanner);

        int[] mousePosition = findMousePosition(territory);
        int mouseRowPosition = mousePosition[0];
        int mouseColumnPosition = mousePosition[1];

        int cheeseEaten = 0;
        boolean outOfBounds = false;
        String command;
        while (!"end".equals(command = scanner.nextLine())) {

            territory[mouseRowPosition][mouseColumnPosition] = '-';

            switch (command) {
                case "up" -> mouseRowPosition--;
                case "down" -> mouseRowPosition++;
                case "left" -> mouseColumnPosition--;
                case "right" -> mouseColumnPosition++;
            }

            if (isOutOfBound(territory, mouseRowPosition, mouseColumnPosition)) {
                outOfBounds = true;
                break;
            }
            
            if (territory[mouseRowPosition][mouseColumnPosition] == 'c') {
                cheeseEaten++;
            }
            else if (territory[mouseRowPosition][mouseColumnPosition] == 'B') {
                territory[mouseRowPosition][mouseColumnPosition] = '-';
                switch (command) {
                    case "up" -> mouseRowPosition--;
                    case "down" -> mouseRowPosition++;
                    case "left" -> mouseColumnPosition--;
                    case "right" -> mouseColumnPosition++;
                }
                if (isOutOfBound(territory, mouseRowPosition, mouseColumnPosition)) {
                    outOfBounds = true;
                    break;
                }
                if (territory[mouseRowPosition][mouseColumnPosition] == 'c') {
                    cheeseEaten++;
                }
            }

            territory[mouseRowPosition][mouseColumnPosition] = 'M';
        }

        if (!outOfBounds) {
            territory[mouseRowPosition][mouseColumnPosition] = 'M';
        }

        if (outOfBounds) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseEaten < 5) {
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - cheeseEaten)
                    + " cheeses more.");
        }
        else {
            System.out.println("Great job, the mouse is fed " + cheeseEaten + " cheeses!");
        }

        printTerritory(territory);
    }

    private static void fillTerritory(char[][] territory, Scanner scanner) {
        for (int i = 0; i < territory.length; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                territory[i][j] = line.charAt(j);
            }
        }
    }

    public static int[] findMousePosition(char[][] territory) {
        int[] mousePosition = new int[2];
        for (int i = 0; i < territory.length; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                if (territory[i][j] == 'M') {
                    mousePosition[0] = i;
                    mousePosition[1] = j;
                }
            }
        }
        return mousePosition;
    }

    private static boolean isOutOfBound(char[][] territory, int mouseRowPosition, int mouseColumnPosition) {
        return mouseRowPosition < 0 || mouseRowPosition >= territory.length || mouseColumnPosition < 0
                || mouseColumnPosition >= territory[mouseRowPosition].length;
    }

    private static void printTerritory(char[][] territory) {
        for (char[] chars : territory) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}