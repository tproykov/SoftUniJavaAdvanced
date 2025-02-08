package JA11ExamPreparation.E18_19_Feb_2022;

import java.util.Arrays;
import java.util.Scanner;

public class E2PawnWars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = new char[8][8];

        fillBoard(chessBoard, scanner);

        int[] pawnsPositions = new int[4];
        findPawnsPositions(chessBoard, pawnsPositions);

        int whiteRowPosition = pawnsPositions[0];
        int whiteColPosition = pawnsPositions[1];
        int blackRowPosition = pawnsPositions[2];
        int blackColPosition = pawnsPositions[3];

        while (true) {

            if (Math.abs(whiteColPosition - blackColPosition) == 1 && whiteRowPosition - blackRowPosition == 1) {
                System.out.println("Game over! White capture on " + columnCode(blackColPosition) +
                        (8 - blackRowPosition) + ".");
                return;
            }

            whiteRowPosition--;
            if (whiteRowPosition == 0) {
                System.out.println("Game over! White pawn is promoted to a queen at "
                        + columnCode(whiteColPosition) + "8.");
                return;
            }

            if (Math.abs(blackColPosition - whiteColPosition) == 1 && whiteRowPosition - blackRowPosition == 1) {
                System.out.println("Game over! Black capture on " + columnCode(whiteColPosition) +
                        (8 - whiteRowPosition) + ".");
                return;
            }

            blackRowPosition++;
            if (blackRowPosition == 7) {
                System.out.println("Game over! Black pawn is promoted to a queen at "
                + columnCode(blackColPosition) + "1.");
                return;
            }
        }
    }

    private static String columnCode(int column) {
        return switch (column) {
            case 0 -> "a";
            case 1 -> "b";
            case 2 -> "c";
            case 3 -> "d";
            case 4 -> "e";
            case 5 -> "f";
            case 6 -> "g";
            case 7 -> "h";
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

    private static void fillBoard(char[][] chessBoard, Scanner scanner) {
        for (int row = 0; row < 8; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < line.length(); col++) {
                chessBoard[row][col] = line.charAt(col);
            }
        }
    }
}