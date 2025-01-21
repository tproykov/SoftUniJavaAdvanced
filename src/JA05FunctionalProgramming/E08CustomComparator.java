package JA05FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class E08CustomComparator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Comparator<Integer> customComparator = (first, second) -> {

            if (first % 2 == 0 && second % 2 != 0) {
                return -101;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 101;
            } else {
                return first.compareTo(second);
            }

        };

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(customComparator)
                .forEach(n -> System.out.print(n + " "));
    }
} 