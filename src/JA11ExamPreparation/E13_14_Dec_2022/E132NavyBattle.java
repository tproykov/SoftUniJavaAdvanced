package JA11ExamPreparation.E13_14_Dec_2022;

import java.util.Scanner;

public class E132NavyBattle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int battlefieldSize = Integer.parseInt(scanner.nextLine());

        char[][] battlefield = new char[battlefieldSize][battlefieldSize];
        int submarineRowPos = 0;
        int submarineColPos = 0;

        for (int i = 0; i < battlefieldSize; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < battlefieldSize; j++) {
                battlefield[i][j] = line.charAt(j);
                if (battlefield[i][j] == 'S') {
                    submarineRowPos = i;
                    submarineColPos = j;
                }
            }
        }

        int hitsTaken = 0;
        int cruisersDestroyed = 0;
        boolean missionSucceeded = false;
        while (true) {

            String command = scanner.nextLine();

            battlefield[submarineRowPos][submarineColPos] = '-';

            switch (command) {
                case "up" -> submarineRowPos--;
                case "down" -> submarineRowPos++;
                case "left" -> submarineColPos--;
                case "right" -> submarineColPos++;
            }

            if (battlefield[submarineRowPos][submarineColPos] == '*') {
                hitsTaken++;
                battlefield[submarineRowPos][submarineColPos] = '-';
                if (hitsTaken == 3) {
                    battlefield[submarineRowPos][submarineColPos] = 'S';
                    break;
                }
            }
            else if (battlefield[submarineRowPos][submarineColPos] == 'C') {
                cruisersDestroyed++;
                battlefield[submarineRowPos][submarineColPos] = '-';
                if (cruisersDestroyed == 3) {
                    missionSucceeded = true;
                    battlefield[submarineRowPos][submarineColPos] = 'S';
                    break;
                }
            }
        }

        if (missionSucceeded) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }
        else {
            System.out.println("Mission failed, U-9 disappeared! Last known coordinates [" + submarineRowPos
                    + ", " + submarineColPos + "]!");
        }

        printBattlefield(battlefield);
    }

    public static void printBattlefield(char[][] battlefield) {
        for (char[] chars : battlefield) {
            for (int j = 0; j < battlefield.length; j++) {
                System.out.print(chars[j] + "");
            }
            System.out.println();
        }
    }
}