package JA05FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E10PredicateParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command;
        while (!"Party!".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");
            String commandName = tokens[0];
            String commandType = tokens[1];
            String parameter = tokens[2];

            Predicate<String> predicate = createPredicate(commandType, parameter);

            if (commandName.equals("Remove")) {
                guests = removeGuests(guests, predicate);
            } else if (commandName.equals("Double")) {
                guests = doubleGuests(guests, predicate);
            }
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            System.out.print(String.join(", ", guests));
            System.out.println(" are going to the party!");
        }
    }

    private static Predicate<String> createPredicate(String commandType, String parameter) {
        return switch (commandType) {
            case "StartsWith" -> guest -> guest.startsWith(parameter);
            case "EndsWith" -> guest -> guest.endsWith(parameter);
            case "Length" -> guest -> guest.length() == Integer.parseInt(parameter);
            default -> guest -> false;
        };
    }

    private static List<String> removeGuests(List<String> guests, Predicate<String> predicate) {
        return guests.stream()
                .filter(predicate.negate())
                .collect(Collectors.toList());
    }

    private static List<String> doubleGuests(List<String> guests, Predicate<String> predicate) {
        List<String> guestsToAdd = guests.stream()
                .filter(predicate)
                .toList();
        List<String> result = new ArrayList<>(guests);
        result.addAll(guestsToAdd);
        return result;
    }
} 