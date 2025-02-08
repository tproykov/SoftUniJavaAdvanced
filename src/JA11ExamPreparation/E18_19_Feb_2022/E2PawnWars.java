package JA11ExamPreparation.E18_19_Feb_2022;

import java.util.Scanner;

public class E2PawnWars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = new char[8][8];

        fillBoard(chessBoard, scanner);

        int[] pawnsPositions = new int[4];
        int whiteRowPosition = pawnsPositions[0];
        int whiteColPosition = pawnsPositions[1];
        int blackRowPosition = pawnsPositions[2];
        int blackColPosition = pawnsPositions[3];

        findPawnsPositions(chessBoard, pawnsPositions);

        while (true) {

            whiteRowPosition++;
            if (whiteRowPosition == 0) {
                System.out.println("Game over! White pawn is promoted to a queen at "
                        + columnCode(whiteColPosition) + "8.");
                return;
            }
            if (Math.abs(whiteColPosition - blackColPosition) == 1 && whiteRowPosition - blackRowPosition == 1) {
                System.out.println("Game over! White capture on " + columnCode(blackColPosition) +
                        (8 - blackRowPosition));
                return;
            }

            blackRowPosition--;
            if (blackRowPosition == 7) {
                System.out.println("Game over! Black pawn is promoted to a queen at "
                + columnCode(blackColPosition) + "1.");
                return;
            }
            if (Math.abs(blackColPosition - whiteColPosition) == 1 && blackRowPosition - whiteRowPosition == 1) {
                System.out.println("Game over! Black capture on " + columnCode(whiteColPosition) +
                        (8 - whiteRowPosition));
                return;
            }
        }
    }

    private static String columnCode(int column) {
        return switch (column) {
            case 0 -> "h";
            case 1 -> "g";
            case 2 -> "f";
            case 3 -> "e";
            case 4 -> "d";
            case 5 -> "c";
            case 6 -> "b";
            case 7 -> "a";
            default -> throw new IllegalStateException("Unexpected value: " + column);
        };
    }

    private static void findPawnsPositions(char[][] chessBoard, int[] pawnsPositions) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (chessBoard[i][j] == 'w') {
                    pawnsPositions[0] = i;
                    pawnsPositions[1] = j;
                }
                if (chessBoard[i][j] == 'b') {
                    pawnsPositions[2] = i;
                    pawnsPositions[3] = j;
                }
            }
        }
    }

    private static void printBoard(char[][] chessBoard) {
        for (char[] chars : chessBoard) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void fillBoard(char[][] chessBoard, Scanner scanner) {
        for (int row = 0; row < 8; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < line.length(); col++) {
                chessBoard[row][col] = line.charAt(col);
            }
        }
    }
}