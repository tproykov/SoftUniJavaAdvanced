package JA12Exam;

import java.util.Scanner;

public class E02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];
        int playerRowPosition = 0;
        int playerColPosition = 0;

        for (int row = 0; row < matrixSize; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'X') {
                    playerRowPosition = row;
                    playerColPosition = col;
                    matrix[row][col] = 'O';
                }
            }

        }



    }

}
