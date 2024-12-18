package JA05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class E04AppliedArithmetics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        Function<List<Integer>, List<Integer>> add = list -> list.stream()
                .map(n -> n + 1)
                .toList();

        Function<List<Integer>, List<Integer>> multiply = list -> list.stream()
                .map(n -> n * 2)
                .toList();

        Function<List<Integer>, List<Integer>> subtract = list -> list.stream()
                .map(n -> n - 1)
                .toList();

        Consumer<List<Integer>> print = list -> list.forEach(n -> System.out.print(n + " "));

        String command;
        while (!"end".equals(command = scanner.nextLine())) {
            switch (command) {
                case "add" -> numbers = add.apply(numbers);
                case "multiply" -> numbers = multiply.apply(numbers);
                case "subtract" -> numbers = subtract.apply(numbers);
                case "print" -> {
                    print.accept(numbers);
                    System.out.println();
                }
            }
        }
    }
}