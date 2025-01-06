package JA11ExamPreparation.E08_21_Oct_2023;

import java.util.Scanner;

public class E082FishingCompetition {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];
        int boatRowPosition = 0;
        int boatColPosition = 0;

        for (int row = 0; row < matrixSize; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'S') {
                    boatRowPosition = row;
                    boatColPosition = col;
                    matrix[row][col] = '-';
                }
            }
        }

        String command;
        while (!"collect the nets".equals(command = scanner.nextLine())) {


        }


    }


}



