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

            int currentLicensePlates = licensePlates.peekFirst();
            int currentCars = cars.peekLast();

            if (currentCars * 2 > currentLicensePlates) {
                licensePlates.pollFirst();
                cars.pollLast();
                int leftoverCars = currentCars - currentLicensePlates * 2;
                registeredCars += currentCars - leftoverCars;
                cars.offerFirst(leftoverCars);
            }
            else if (currentCars * 2 < currentLicensePlates) {
                licensePlates.pollFirst();
                cars.pollLast();
                int leftoverPlates = currentLicensePlates - currentCars * 2;
                registeredCars += currentCars;
                licensePlates.offerLast(leftoverPlates);
            }
            else {
                licensePlates.pollFirst();
                cars.pollLast();
                registeredCars += currentCars;
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