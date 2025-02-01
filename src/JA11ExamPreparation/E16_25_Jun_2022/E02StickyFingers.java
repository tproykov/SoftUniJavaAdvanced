package JA11ExamPreparation.E16_25_Jun_2022;

import java.util.Scanner;

public class E02StickyFingers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        String[] directions = scanner.nextLine().split(",");

        char[][] field = new char[fieldSize][fieldSize];

        populateField(field, scanner);

        int[] thiefPosition = findThiefPosition(field);
        int thiefRowPosition = thiefPosition[0];
        int thiefColPosition = thiefPosition[1];

        int moneyStolen = 0;
        boolean goneToJail = false;
        for (String direction : directions) {

            int newRowPosition = thiefRowPosition;
            int newColPosition = thiefColPosition;
            field[newRowPosition][newColPosition] = '+';

            switch (direction) {
                case "up" -> newRowPosition--;
                case "down" -> newRowPosition++;
                case "left" -> newColPosition--;
                case "right" -> newColPosition++;
            }

            if (isOutOfBound(fieldSize, newRowPosition, newColPosition)) {
                System.out.println("You cannot leave the town, there is police outside!");
            }
            else {
                thiefRowPosition = newRowPosition;
                thiefColPosition = newColPosition;
            }

            if (field[thiefRowPosition][thiefColPosition] == '$') {
                int currentMoneyStolen = thiefRowPosition * thiefColPosition;
                moneyStolen += currentMoneyStolen;
                System.out.println("You successfully stole " + currentMoneyStolen + "$.");
                field[thiefRowPosition][thiefColPosition] = '+';
            }
            else if (field[thiefRowPosition][thiefColPosition] == 'P') {
                goneToJail = true;
                break;
            }
        }

        if (goneToJail) {
            field[thiefRowPosition][thiefColPosition] = '#';
            System.out.println("You got caught with " + moneyStolen + "$, and you are going to jail.");
            printField(field);
        }
        else {
            field[thiefRowPosition][thiefColPosition] = 'D';
            System.out.println("Your last theft has finished successfully with " + moneyStolen + "$ in your pocket.");
            printField(field);
        }
    }

    private static void populateField(char[][] field, Scanner scanner) {
        for (int row = 0; row < field.length; row++) {
            String line = scanner.nextLine().replace(" ", "");
            field[row] = line.toCharArray();
        }
    }

    private static int[] findThiefPosition(char[][] field) {
        int[] thiefPosition = new int[2];
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'D') {
                    thiefPosition[0] = row;
                    thiefPosition[1] = col;
                }
            }
        }
        return thiefPosition;
    }

    private static boolean isOutOfBound(int fieldSize, int thiefRowPosition, int thiefColPosition) {
        return thiefRowPosition >= fieldSize || thiefColPosition >= fieldSize || thiefRowPosition < 0
                || thiefColPosition < 0;
    }

    private static void printField(char[][] field) {
        for (char[] chars : field) {
            for (int row = 0; row < field.length; row++) {
                System.out.print(chars[row]);
                if (row < field.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}