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
                    field[i][j] = '*';
                }
            }
        }

        int hazelnutsCollected = 0;
        for (String command : commands) {

            field[squirrelRowPosition][squirrelColPosition] = '*';

            switch (command) {
                case "up" -> squirrelRowPosition--;
                case "down" -> squirrelRowPosition++;
                case "left" -> squirrelColPosition--;
                case "right" -> squirrelColPosition++;
            }

            if (isOutOfBounds(fieldSize, squirrelRowPosition, squirrelColPosition)) {
                System.out.println("The squirrel is out of the field.");
                System.out.println("Hazelnuts collected: " + hazelnutsCollected);
                return;
            }

            if (field[squirrelRowPosition][squirrelColPosition] == 't') {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                System.out.println("Hazelnuts collected: " + hazelnutsCollected);
                return;
            }

            if (field[squirrelRowPosition][squirrelColPosition] == 'h') {
                hazelnutsCollected++;
                field[squirrelRowPosition][squirrelColPosition] = '*';
                if (hazelnutsCollected == 3) {
                    field[squirrelRowPosition][squirrelColPosition] = 's';
                    System.out.println("Good job! You have collected all hazelnuts!");
                    System.out.println("Hazelnuts collected: " + hazelnutsCollected);
                    return;
                }
            }

            field[squirrelRowPosition][squirrelColPosition] = 's';
        }

        System.out.println("There are more hazelnuts to collect.");
        System.out.println("Hazelnuts collected: " + hazelnutsCollected);
    }

    public static boolean isOutOfBounds(int fieldSize, int squirrelRowPosition, int squirrelColPosition) {

        return squirrelRowPosition >= fieldSize || squirrelColPosition >= fieldSize || squirrelRowPosition < 0
                || squirrelColPosition < 0;
    }
}