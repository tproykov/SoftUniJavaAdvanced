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
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}