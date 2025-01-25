package JA11ExamPreparation.E11_12_Apr_2023;

import java.util.Arrays;
import java.util.Scanner;

public class E02TheSquirrel {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        String[] commands = Arrays.stream(scanner.nextLine().split(", ")).toArray(String[]::new);

        char[][] field = new char[fieldSize][fieldSize];

        int squirrelRowPosition = 0;
        int squirrelColPosition = 0;

        for (int i = 0; i < fieldSize; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = row.charAt(j);
                if (field[i][j] == 's') {
                    squirrelRowPosition = i;
                    squirrelColPosition = j;
                }
            }
        }

        int hazelnutsCollected = 0;
        for (String command : commands) {

            switch (command) {
                case "up" -> squirrelRowPosition--;
                case "down" -> squirrelRowPosition++;
                case "left" -> squirrelColPosition--;
                case "right" -> squirrelColPosition++;
            }



            



        }





        }


    }
}
