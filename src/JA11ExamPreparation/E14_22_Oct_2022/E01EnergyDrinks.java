package JA11ExamPreparation.E14_22_Oct_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01EnergyDrinks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeine = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> energyDrinks = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int caffeineConsumed = 0;

        while (!caffeine.isEmpty() && !energyDrinks.isEmpty()) {

            int currentCaffeine = caffeine.peekLast();
            int currentEnergyDrink = energyDrinks.peekFirst();

            int caffeineInDrink = currentCaffeine * currentEnergyDrink;

            if (caffeineInDrink + caffeineConsumed <= 300) {
                caffeineConsumed += caffeineInDrink;
                energyDrinks.pollFirst();
                caffeine.pollLast();
            }
            else {
                caffeine.pollLast();
                energyDrinks.pollFirst();
                energyDrinks.offerLast(currentEnergyDrink);
                caffeineConsumed -= 30;
                if (caffeineConsumed < 0) {
                    caffeineConsumed = 0;
                }
            }
        }

        if (!energyDrinks.isEmpty()) {
            System.out.print("Drinks left: ");
            System.out.println(energyDrinks.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.println("Stamat is going to sleep with " + caffeineConsumed + " mg caffeine.");
    }
}