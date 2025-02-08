package JA11ExamPreparation.E18_19_Feb_2022;

import java.util.Scanner;

public class E2PawnWars {
    private static final int BOARD_SIZE = 8;
    private static final char WHITE_PAWN = 'w';
    private static final char BLACK_PAWN = 'b';

    private static class Position {
        int row, col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chessBoard = new char[BOARD_SIZE][BOARD_SIZE];
        fillBoard(chessBoard, scanner);

        Position whitePawn = findPawn(chessBoard, WHITE_PAWN);
        Position blackPawn = findPawn(chessBoard, BLACK_PAWN);

        simulateGame(whitePawn, blackPawn);
    }

    private static void simulateGame(Position white, Position black) {
        while (true) {
            if (canCapture(white, black)) {
                System.out.printf("Game over! White capture on %s%d.%n",
                        columnCode(black.col), BOARD_SIZE - black.row);
                return;
            }

            white.row--;
            if (white.row == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %s8.%n",
                        columnCode(white.col));
                return;
            }

            if (canCapture(white, black)) {
                System.out.printf("Game over! Black capture on %s%d.%n",
                        columnCode(white.col), BOARD_SIZE - white.row);
                return;
            }

            black.row++;
            if (black.row == BOARD_SIZE - 1) {
                System.out.printf("Game over! Black pawn is promoted to a queen at %s1.%n",
                        columnCode(black.col));
                return;
            }
        }
    }

    private static boolean canCapture(Position white, Position black) {
        return Math.abs(white.col - black.col) == 1 && white.row - black.row == 1;
    }

    private static String columnCode(int column) {
        return String.valueOf((char)('a' + column));
    }

    private static Position findPawn(char[][] board, char pawnType) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == pawnType) {
                    return new Position(i, j);
                }
            }
        }
        throw new IllegalStateException("Pawn not found: " + pawnType);
    }

    private static void fillBoard(char[][] board, Scanner scanner) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            String line = scanner.nextLine();
            board[row] = line.toCharArray();
        }
    }
}