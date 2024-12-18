package JA05FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class L01SortEvenNumbers {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> evenNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        printEvenNumbers(evenNumbers);

        Collections.sort(evenNumbers);

        printEvenNumbers(evenNumbers);
    }

    private static void printEvenNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}