package JA11ExamPreparation.E18_19_Feb_2022;

import java.util.Scanner;

public class E2PawnWars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = new char[8][8];

        fillBoard(chessBoard, scanner);


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