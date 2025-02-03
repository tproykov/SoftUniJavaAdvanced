package JA11ExamPreparation.E17_13_Apr_2022;

import java.util.Scanner;

public class E02Armory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int armorySize = Integer.parseInt(scanner.nextLine());

        char[][] armory = new char[armorySize][armorySize];

        fillArmory(armory, scanner);
        int[] officerPosition = findOfficerPosition(armory);
        int officerRowPosition = officerPosition[0];
        int officerColPosition = officerPosition[1];

        int gold = 0;
        boolean outOfArmory = false;
        while (gold < 65) {

            String command = scanner.nextLine();

            armory[officerRowPosition][officerColPosition] = '-';

            switch (command) {
                case "up" -> officerRowPosition--;
                case "down" -> officerRowPosition++;
                case "left" -> officerColPosition--;
                case "right" -> officerColPosition++;
            }

            if (isOutOfBounds(armorySize, officerRowPosition, officerColPosition)) {
                outOfArmory = true;
                break;
            }

            if (Character.isDigit(armory[officerRowPosition][officerColPosition])) {
                int swordValue = Integer.parseInt(armory[officerRowPosition][officerColPosition] + "");
                gold += swordValue;
                armory[officerRowPosition][officerColPosition] = 'A';
            }
            else if (armory[officerRowPosition][officerColPosition] == 'M') {
                armory[officerRowPosition][officerColPosition] = '-';
                int[] officerNewPosition = teleport(armory, officerRowPosition, officerColPosition);
                officerRowPosition = officerNewPosition[0];
                officerColPosition = officerNewPosition[1];
            }
        }

        if (outOfArmory) {
            System.out.println("I do not need more swords!");
        }
        else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.println("The king paid " + gold + " gold coins.");

        printArmory(armory);
    }

    private static void fillArmory(char[][] armory, Scanner scanner) {
        for (int i = 0; i < armory.length; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < armory[i].length; j++) {
                armory[i][j] = row.charAt(j);
            }
        }
    }

    private static int[] findOfficerPosition(char[][] armory) {
        for (int i = 0; i < armory.length; i++) {
            for (int j = 0; j < armory[i].length; j++) {
                if (armory[i][j] == 'A') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean isOutOfBounds(int armorySize, int officerRowPosition, int officerColPosition) {
        return officerRowPosition < 0 || officerRowPosition >= armorySize || officerColPosition < 0
                || officerColPosition >= armorySize;
    }

    private static int[] teleport(char[][] armory, int officerRowPosition, int officerColPosition) {

        int[] mirrorPositions = new int[2];
        for (int i = 0; i < armory.length; i++) {
            for (int j = 0; j < armory[i].length; j++) {
                if (armory[i][j] == 'M' && i != officerRowPosition && j != officerColPosition) {
                    mirrorPositions[0] = i;
                    mirrorPositions[1] = j;
                }
            }
        }
        return mirrorPositions;
    }

    private static void printArmory(char[][] armory) {
        for (int i = 0; i < armory.length; i++) {
            for (int j = 0; j < armory[i].length; j++) {
                System.out.print(armory[i][j]);
            }
            System.out.println();
        }
    }
}