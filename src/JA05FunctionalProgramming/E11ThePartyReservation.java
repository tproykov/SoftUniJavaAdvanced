package JA05FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E11ThePartyReservation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> predicateMap = new HashMap<>();


        Predicate<String> predicate;
        String input;
        while (!"Print".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(";");
            String TPRFCommand = tokens[0];
            String type = tokens[1];
            String parameter = tokens[2];
            String predicateName = tokens[1] + ";" + tokens[2];

            switch (TPRFCommand) {

                case "Add filter" -> {

                    switch (type) {

                        case "Starts with" -> {
                            predicate = s -> s.startsWith(parameter);
                            predicateMap.putIfAbsent(predicateName, predicate);
                        }

                        case "Ends with" -> {
                            predicate = s -> s.endsWith(parameter);
                            predicateMap.putIfAbsent(predicateName, predicate);
                        }

                        case "Length" -> {
                            predicate = s -> s.length() == Integer.parseInt(parameter);
                            predicateMap.putIfAbsent(predicateName, predicate);
                        }

                        case "Contains" -> {
                            predicate = s -> s.contains(parameter);
                            predicateMap.putIfAbsent(predicateName, predicate);
                        }
                    }
                }

                case "Remove filter" -> predicateMap.remove(predicateName);
            }
        }

        for (String key : predicateMap.keySet()) {
            Predicate<String> currentPredicate = predicateMap.get(key);
            guests = guests.stream()
                           .filter(currentPredicate.negate())
                           .toList();

        }

        guests.forEach(guest -> System.out.print(guest + " "));
    }
}