package JA11ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E032CollectingStarsGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[fieldSize][fieldSize];
        int playerRowPosition = 0;
        int playerColPosition = 0;

        for (int row = 0; row < fieldSize; row++) {
            char[] line = scanner.nextLine().replaceAll(" ", "").toCharArray();

            for (int col = 0; col < fieldSize; col++) {
                field[row][col] = line[col];
                if (field[row][col] == 'P') {
                    playerRowPosition = row;
                    playerColPosition = col;
                }
            }
        }





        



    }

}
