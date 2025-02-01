package JA11ExamPreparation.E15_18_Aug_2022;

import java.util.Scanner;

public class E02TreasureHunt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] field = new char[rows][cols];
        int playerRowPosition = 0;
        int playerColPosition = 0;

        for (int i = 0; i < rows; i++) {
            char[] line = scanner.nextLine().split(" ").toCharArray();
            String line = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                field[i][j] = line.charAt(j);
                if (field[i][j] == 'Y') {
                    playerRowPosition = i;
                    playerColPosition = j;
                }
            }
        }



    }

    public boolean isOutOfBounds(int rows, int cols, int playerRowPosition, int playerColPosition) {
        return playerRowPosition >= rows || playerColPosition >= cols || playerRowPosition < 0
                || playerColPosition < 0;
    }

    public static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + "");
            }
            System.out.println();
        }
    }
}