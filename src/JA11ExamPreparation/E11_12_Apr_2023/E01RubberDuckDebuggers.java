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

        int darthVaderDucks = 0;
        int thorDucks = 0;
        int bigBlueRubberDucks = 0;
        int smallYellowRubberDucks = 0;

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
                    smallYellowRubberDucks++;
                }
                else if (calculatedTime > 120) {
                    bigBlueRubberDucks++;
                }
                else if (calculatedTime > 60) {
                    thorDucks++;
                }
                else {
                    darthVaderDucks++;
                }

                requiredTimes.pollFirst();
                tasksGiven.pollLast();
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");

        System.out.println("Darth Vader Ducky: " + darthVaderDucks);
        System.out.println("Thor Ducky: " + thorDucks);
        System.out.println("Big Blue Rubber Ducky: " + bigBlueRubberDucks);
        System.out.println("Small Yellow Rubber Ducky: " + smallYellowRubberDucks);
    }
}