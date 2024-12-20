package JA05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class E07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findLastIndexOfMin = array -> {

            int minVal = array[array.length - 1];
            int minIndex = array.length - 1;

            for (int i = array.length - 2; i >= 0; i--) {
                if (array[i] < minVal) {
                    minVal = array[i];
                    minIndex = i;
                }
            }
            return minIndex;
        };

        System.out.println(findLastIndexOfMin.apply(numbers));
    }
}
