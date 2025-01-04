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
        int damageCounter = 0;
        boolean jetfighterCrashed = false;
        boolean allEnemiesSHotDown = false;

        while (true) {

            String command = scanner.nextLine();

            int jetfighterOldRowPosition = jetfighterRowPosition;
            int jetfighterOldColPosition = jetfighterColPosition;

            matrix[jetfighterRowPosition][jetfighterColPosition] = '-';

            switch (command) {
                case "up" -> jetfighterRowPosition--;
                case "down" -> jetfighterRowPosition++;
                case "left" -> jetfighterColPosition--;
                case "right" -> jetfighterColPosition++;
            }

            if (matrix[jetfighterRowPosition][jetfighterColPosition] == 'E') {
                if (enemyPlaneCounter != 4 && damageCounter < 3) {
                    enemyPlaneCounter++;
                    damageCounter++;
                    armor -= 100;
                    matrix[jetfighterRowPosition][jetfighterColPosition] = 'J';
                } else if (enemyPlaneCounter == 4) {
                    matrix[jetfighterRowPosition][jetfighterColPosition] = 'J';
                    allEnemiesSHotDown = true;
                    break;
                } else if (damageCounter == 3) {
                    jetfighterCrashed = true;
                    matrix[jetfighterRowPosition][jetfighterColPosition] = 'J';

                }
            }
            else if (matrix[jetfighterRowPosition][jetfighterColPosition] == 'R') {
                armor = 300;
                matrix[jetfighterRowPosition][jetfighterColPosition] = 'J';
            }

            if (armor <= 0) {

            }


        }


    }


}


