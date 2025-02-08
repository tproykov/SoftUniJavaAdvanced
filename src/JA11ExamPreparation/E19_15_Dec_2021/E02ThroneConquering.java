package JA11ExamPreparation.E19_15_Dec_2021;

import java.util.Scanner;

public class E02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] sparta = new char[rows][];
        for (int i = 0; i < rows; i++) {
            sparta[i] = scanner.nextLine().toCharArray();
        }

        int parisRow = 0;
        int parisCol = 0;
        for (int i = 0; i < sparta.length; i++) {
            for (int j = 0; j < sparta[i].length; j++) {
                if (sparta[i][j] == 'P') {
                    parisRow = i;
                    parisCol = j;
                    break;
                }
            }
        }

        sparta[parisRow][parisCol] = '-';

        boolean parisRescuedHelen = false;
        while (true) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String direction = tokens[0];
            int enemyRow = Integer.parseInt(tokens[1]);
            int enemyCol = Integer.parseInt(tokens[2]);

            sparta[enemyRow][enemyCol] = 'S';

            energy--;

            int nextRow = parisRow;
            int nextCol = parisCol;
            switch (direction) {
                case "up" -> nextRow--;
                case "down" -> nextRow++;
                case "left" -> nextCol--;
                case "right" -> nextCol++;
            }

            if (isInBounds(sparta, nextRow, nextCol)) {
                parisRow = nextRow;
                parisCol = nextCol;
            }

            if (sparta[parisRow][parisCol] == 'H') {
                sparta[parisRow][parisCol] = '-';
                parisRescuedHelen = true;
                break;
            }

            if (energy <= 0) {
                sparta[parisRow][parisCol] = 'X';
                break;
            }

            if (sparta[parisRow][parisCol] == 'S') {
                energy -= 2;
                sparta[parisRow][parisCol] = '-';
                if (energy <= 0) {
                    sparta[parisRow][parisCol] = 'X';
                    break;
                }
            }
        }

        if (parisRescuedHelen) {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        } else {
            System.out.println("Paris died at " + parisRow + ";" + parisCol + ".");
        }

        for (char[] row : sparta) {
            for (char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }
}
