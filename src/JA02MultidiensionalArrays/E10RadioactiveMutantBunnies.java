package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E10RadioactiveMutantBunnies {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] lairDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = lairDimensions[0];
        int columns = lairDimensions[1];

        char[][] lair = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < columns; j++) {
                lair[i][j] = line.charAt(j);
            }
        }

        char[] directions = scanner.nextLine().toCharArray();

        for (int i = 0; i < directions.length; i++) {

            char direction = directions[i];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    if (lair[row][col] == 'B') {

                        int rowNextBunny = row;
                        int colNextBunny = col;
                        switch (direction) {
                            case 'R' -> colNextBunny++;
                            case 'L' -> colNextBunny--;
                            case 'U' -> rowNextBunny--;
                            case 'D' -> rowNextBunny++;
                        }

                        if (isInside(lair, rowNextBunny, colNextBunny)) {
                            lair[rowNextBunny][colNextBunny] = 'B';
                        }
                    }
                }
            }








        }



    }

    private static boolean isInside(char[][] lairs, int row, int column) {
        return row >= 0 && row < lairs.length && column >= 0 && column < lairs[0].length;
    }


}
