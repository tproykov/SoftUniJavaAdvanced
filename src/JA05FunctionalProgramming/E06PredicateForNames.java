package JA05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class E06PredicateForNames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int wordLengthLimit = Integer.parseInt(scanner.nextLine());

        Predicate<String> checkLength = word -> word.length() <= wordLengthLimit;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(checkLength)
                .forEach(System.out::println);
    }
} 