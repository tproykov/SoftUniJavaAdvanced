package JA11ExamPreparation.E11_12_Apr_2023;

import java.util.*;
import java.util.stream.Collectors;

public class E01RubberDuckDebuggers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> requiredTimes = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> tasksGiven = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> ducks = new HashMap<>();

        while (!requiredTimes.isEmpty() && !tasksGiven.isEmpty()) {

            int currentTimeRequired = requiredTimes.peekFirst();
            int currentTasksGiven = tasksGiven.peekLast();

            int calculatedTime = currentTimeRequired * currentTasksGiven;

            if (calculatedTime > 240) {
                int tempTasksGiven = tasksGiven.pollLast() - 2;
                tasksGiven.offerLast(tempTasksGiven);
                requiredTimes.pollFirst();
                requiredTimes.offerLast(currentTimeRequired);
            }
            else {
                if (calculatedTime > 180) {
                    ducks.putIfAbsent("Small Yellow Rubber Ducky", 0);
                    ducks.put("Small Yellow Rubber Ducky", ducks.get("Small Yellow Rubber Ducky") + 1);
                }
                else if (calculatedTime > 120) {
                    ducks.putIfAbsent("Big Blue Rubber Ducky", 0);
                    ducks.put("Big Blue Rubber Ducky", ducks.get("Big Blue Rubber Ducky") + 1);
                }
                else if (calculatedTime > 60) {
                    ducks.putIfAbsent("Thor Ducky", 0);
                    ducks.put("Thor Ducky", ducks.get("Thor Ducky") + 1);
                }
                else {
                    ducks.putIfAbsent("Darth Vader Ducky", 0);
                    ducks.put("Darth Vader Ducky", ducks.get("Darth Vader Ducky") + 1);
                }

                requiredTimes.pollFirst();
                tasksGiven.pollLast();
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");

        for (Map.Entry<String, Integer> entry : ducks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}