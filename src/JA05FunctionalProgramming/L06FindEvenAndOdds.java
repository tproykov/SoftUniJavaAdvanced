package JA05FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class L06FindEvenAndOdds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String condition = scanner.nextLine();

        Predicate<Integer> predicate = condition.equals("even")
                ? number -> number % 2 == 0
                : number -> number % 2 != 0;

        List<Integer> numbers = new ArrayList<>();
        for (int i = bounds[0]; i <= bounds[1]; i++) {
            if (predicate.test(i)) {
                numbers.add(i);
            }
        }

        numbers.forEach(number -> System.out.print(number + " "));
    }
}