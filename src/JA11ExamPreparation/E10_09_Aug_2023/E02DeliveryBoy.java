package JA11ExamPreparation.E10_09_Aug_2023;

import java.util.Scanner;

public class E02DeliveryBoy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] field = new char[rows][cols];

        int deliveryBoyRowPosition = 0;
        int deliveryBoyColPosition = 0;
        int deliveryBoyStartRowPosition = 0;
        int deliveryBoyStartColPosition = 0;

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();

            for (int j = 0; j < cols; j++) {

                field[i][j] = line.charAt(j);

                if (field[i][j] == 'B') {
                    deliveryBoyRowPosition = i;
                    deliveryBoyColPosition = j;
                    deliveryBoyStartRowPosition = i;
                    deliveryBoyStartColPosition = j;
                }
            }
        }

        while (true) {

            String command = scanner.nextLine();

            int deliveryBoyPreviousRowPosition = deliveryBoyRowPosition;
            int deliveryBoyPreviousColPosition = deliveryBoyColPosition;

            switch (command) {
                case "up" -> deliveryBoyRowPosition--;
                case "down" -> deliveryBoyRowPosition++;
                case "left" -> deliveryBoyColPosition--;
                case "right" -> deliveryBoyColPosition++;
            }

            if (isOutOfBounds(rows, cols, deliveryBoyRowPosition, deliveryBoyColPosition)) {
                System.out.println("The delivery is late. Order is canceled.");
                field[deliveryBoyStartRowPosition][deliveryBoyStartColPosition] = ' ';
                break;
            }

            if (field[deliveryBoyRowPosition][deliveryBoyColPosition] == 'P') {
                field[deliveryBoyRowPosition][deliveryBoyColPosition] = 'R';
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            }
            else if (field[deliveryBoyRowPosition][deliveryBoyColPosition] == '*') {
                deliveryBoyRowPosition = deliveryBoyPreviousRowPosition;
                deliveryBoyColPosition = deliveryBoyPreviousColPosition;
            }
            else if (field[deliveryBoyRowPosition][deliveryBoyColPosition] == '-' ||
                    field[deliveryBoyRowPosition][deliveryBoyColPosition] == '.') {
                field[deliveryBoyRowPosition][deliveryBoyColPosition] = '.';
            }
            else if (field[deliveryBoyRowPosition][deliveryBoyColPosition] == 'A') {
                field[deliveryBoyRowPosition][deliveryBoyColPosition] = 'P';
                System.out.println("Pizza is delivered on time! Next order...");
                break;
            }
        }

        printField(field);
    }

    private static boolean isOutOfBounds(int rows, int cols, int deliveryBoyRowPosition, int deliveryBoyColPosition) {
        return deliveryBoyRowPosition < 0 || deliveryBoyColPosition < 0 || deliveryBoyRowPosition >= rows
                || deliveryBoyColPosition >= cols;
    }

    public static void printField(char[][] field) {
        for (char[] chars : field) {
            for (char currentChar : chars) {
                System.out.print(currentChar + "");
            }
            System.out.println();
        }
    }
}