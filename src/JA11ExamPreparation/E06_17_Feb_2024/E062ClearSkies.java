package JA11ExamPreparation.E06_17_Feb_2024;

import java.util.Scanner;

public class E062ClearSkies {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];
        int jetfighterRowPosition = 0;
        int jetfighterColPosition = 0;

        for (int row = 0; row < matrixSize; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'J') {
                    jetfighterRowPosition = row;
                    jetfighterColPosition = col;
                    matrix[row][col] = '-';
                }
            }
        }

        int armor = 300;
        int enemyPlaneCounter = 0;
        boolean jetfighterCrashed = false;
        boolean allEnemiesShotDown = false;

        while (true) {
            String command = scanner.nextLine();

            matrix[jetfighterRowPosition][jetfighterColPosition] = '-';

            switch (command) {
                case "up" -> jetfighterRowPosition--;
                case "down" -> jetfighterRowPosition++;
                case "left" -> jetfighterColPosition--;
                case "right" -> jetfighterColPosition++;
            }

            if (matrix[jetfighterRowPosition][jetfighterColPosition] == 'E') {
                enemyPlaneCounter++;
                if (enemyPlaneCounter < 4) {
                    armor -= 100;
                }
                matrix[jetfighterRowPosition][jetfighterColPosition] = '-';

                if (enemyPlaneCounter == 4) {
                    allEnemiesShotDown = true;
                    matrix[jetfighterRowPosition][jetfighterColPosition] = 'J';
                    break;
                }
            }
            else if (matrix[jetfighterRowPosition][jetfighterColPosition] == 'R') {
                armor = 300;
                matrix[jetfighterRowPosition][jetfighterColPosition] = '-';
            }

            matrix[jetfighterRowPosition][jetfighterColPosition] = 'J';

            if (armor <= 0) {
                jetfighterCrashed = true;
                break;
            }
        }

        if (allEnemiesShotDown) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        } else if (jetfighterCrashed) {
            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n",
                    jetfighterRowPosition, jetfighterColPosition);
        }

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}