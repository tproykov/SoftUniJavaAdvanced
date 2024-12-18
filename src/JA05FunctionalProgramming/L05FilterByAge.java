package JA05FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class L05FilterByAge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(args[0]);

        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> filterByAge;
        switch (condition) {
            case "younger" -> filterByAge = age -> age <= ageLimit;
            case "older" -> filterByAge = age -> age >= ageLimit;
            default -> throw new IllegalArgumentException("Invalid condition");
        }

        Consumer<Map.Entry<String, Integer>> printPeople;
        switch (format) {
            case "name" -> printPeople = entry -> System.out.println(entry.getKey());
            case "age" -> printPeople = entry -> System.out.println(entry.getValue());
            case "name age" -> printPeople = entry -> System.out.println(entry.getKey() + " - " + entry.getValue());
            default -> throw new IllegalArgumentException("Invalid format");
        }

        people.entrySet()
                .stream()
                .filter(entry -> filterByAge.test(entry.getValue()))
                .forEach(printPeople);
    }
}