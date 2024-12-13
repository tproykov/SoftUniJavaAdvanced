package JA02MultidiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E12TheMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

    }

}
