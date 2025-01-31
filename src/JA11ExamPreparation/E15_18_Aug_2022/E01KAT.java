package JA11ExamPreparation.E15_18_Aug_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01KAT {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlates = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> cars = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int days = 0;
        int registeredCars = 0;
        while (!licensePlates.isEmpty() && !cars.isEmpty()) {

            int currentPlates = licensePlates.peekFirst();
            int currentCars = cars.peekLast();

            int possibleRegistrations = currentPlates / 2;

            if (possibleRegistrations > currentCars) {
                registeredCars += currentCars;
                int leftoverPlates = currentPlates - currentCars * 2;
                if (leftoverPlates > 0) {
                    licensePlates.offerLast(leftoverPlates);
                }
            }
            else {
                registeredCars += possibleRegistrations;
                int leftoverCars = currentCars - possibleRegistrations;
                if (leftoverCars > 0) {
                    cars.addFirst(leftoverCars);
                }
            }

            days++;
        }

        System.out.println(registeredCars + " cars were registered for " + days + " days!");

        if (!licensePlates.isEmpty()) {
            int remainingPlates = licensePlates.stream().mapToInt(Integer::intValue).sum();
            System.out.println(remainingPlates + " license plates remain!");
        }
        else if (!cars.isEmpty()) {
            int remainingCars = cars.stream().mapToInt(Integer::intValue).sum();
            System.out.println(remainingCars + " cars remain without license plates!");
        }
        else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}