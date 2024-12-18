package JA05FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class L06FindEvenAndOdds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);
        String condition = scanner.nextLine();

        Predicate<Integer> predicate = condition.equals("even")
                ? number -> number % 2 == 0
                : number -> number % 2 != 0;

        List<Integer> numbers = new ArrayList<>();
        for (int i = lowerBound; i <= upperBound; i++) {
            if (predicate.test(i)) {
                numbers.add(i);
            }
        }

        numbers.forEach(number -> System.out.print(number + " "));
    }
}