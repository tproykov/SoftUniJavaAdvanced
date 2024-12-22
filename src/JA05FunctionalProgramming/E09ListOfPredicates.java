package JA05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class E09ListOfPredicates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        Predicate<Integer> isDivisible = num -> sequence.stream()
                .filter(x -> x != 0)  // Avoid division by zero
                .allMatch(x -> num % x == 0);

        String result = IntStream.rangeClosed(1, n)
                .filter(num -> isDivisible.test(num))
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + " " + b)
                .orElse("");

        System.out.println(result);
    }
}