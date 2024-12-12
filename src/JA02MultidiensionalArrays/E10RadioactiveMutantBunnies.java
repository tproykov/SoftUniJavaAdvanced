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

        char[][] lairs = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < columns; j++) {
                lairs[i][j] = line.charAt(j);
            }
        }

        char[] directions = scanner.nextLine().toCharArray();

        for (int i = 0; i < directions.length; i++) {

            char direction = directions[i];




            switch (direction) {

                case 'R' -> {}

                case 'L' -> {}

                case 'U' -> {}

                case 'D' -> {}
            }



        }



    }


}
