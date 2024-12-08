package JA02MultidiensionalArrays;

import java.util.Scanner;

public class L07FindTheRealQueen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] chessBoard = new String[8][8];

        readChessBoard(chessBoard, scanner);

        int[] validPosition = findValidQueen(chessBoard);

        if (validPosition != null) {
            System.out.println(validPosition[0] + " " + validPosition[1]);
        } else {
            System.out.println("No valid queen found");
        }
    }

    private static void readChessBoard(String[][] chessBoard, Scanner scanner) {

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                chessBoard[row][col] = scanner.next();
            }
            scanner.nextLine();
        }
    }

    private static int[] findValidQueen(String[][] chessBoard) {

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                if (chessBoard[row][col].equals("q") && isValidQueen(chessBoard, row, col)) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    private static boolean isValidQueen(String[][] chessBoard, int queenRow, int queenCol) {

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (row == queenRow && col == queenCol) {  // Skip checking against itself
                    continue;
                }

                // If we find another queen, check if it attacks our queen
                if (chessBoard[row][col].equals("q")) {

                    if (row == queenRow || col == queenCol) {
                        return false;
                    }

                    if (Math.abs(row - queenRow) == Math.abs(col - queenCol)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}