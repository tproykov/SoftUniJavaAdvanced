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
        territory[mouseRowPosition][mouseColumnPosition] = '-';

        String command;
        while (!"End".equals(command = scanner.nextLine())) {


            





        }


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

    private static void printTerritory(char[][] territory, Scanner scanner) {
        for (int i = 0; i < territory.length; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                System.out.print(territory[i][j]);
            }
            System.out.println();
        }
    }
}