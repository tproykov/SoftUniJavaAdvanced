package JA02MultidiensionalArrays;

import java.util.*;

public class E06StringMatrixRotation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replace("Rotate(", "").replace(")", "");
        int rotations = Integer.parseInt(input) / 90;

        List<String> words = new ArrayList<>();
        String input2 = scanner.nextLine();
        while (!input2.equals("END")) {
            words.add(input2);
            input2 = scanner.nextLine();
        }

        int longestWordLength = Collections.max(words, Comparator.comparing(String::length)).length();

        char[][] matrix = new char[words.size()][longestWordLength];

        fillTheMatrix(matrix, words);

        for (int i = 1; i <= rotations; i++) {
            matrix = rotate90(matrix);
        }

        printTheMatrix(matrix);
    }

    private static void fillTheMatrix(char[][] matrix, List<String> stringsList) {

        for (int row = 0; row < stringsList.size(); row++) {

            String word = stringsList.get(row);

            for (int col = 0; col < matrix[row].length; col++) {

                if (col < word.length()) {
                    matrix[row][col] = word.charAt(col);
                }
                else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }

    private static char[][] rotate90(char[][] oldMatrix) {

        char[][] newMatrix = new char[oldMatrix[0].length][oldMatrix.length];

        for (int col = 0; col < oldMatrix[0].length; col++) {
            int columnCounter = 0;
            for (int row = oldMatrix.length - 1; row >= 0; row--) {

                newMatrix[col][columnCounter] = oldMatrix[row][col];
                columnCounter++;
            }
        }

        return newMatrix;
    }

    private static void printTheMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}