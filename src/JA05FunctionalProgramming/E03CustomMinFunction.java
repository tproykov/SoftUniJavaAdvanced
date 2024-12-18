package JA05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class E03CustomMinFunction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findSmallestNo = array -> {
            int minNumber = Integer.MAX_VALUE;
            for (Integer integer : array) {
                if (integer < minNumber) {
                    minNumber = integer;
                }
            }
            return minNumber;
        };

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer smallestNo = findSmallestNo.apply(numbers);

        System.out.println(smallestNo);
    }
}