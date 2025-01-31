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

            if (currentLicensePlates == 1) {
                break;
            }

            if (currentCars > currentLicensePlates * 2) {
                licensePlates.pollFirst();
                cars.pollLast();
                int leftoverCars = currentCars - currentLicensePlates * 2;
                registeredCars += currentCars - leftoverCars;
                cars.offerLast(leftoverCars);
            }
            else if (currentCars < currentLicensePlates * 2) {
                licensePlates.pollFirst();
                cars.pollLast();
                int leftoverPlates = currentLicensePlates - currentCars * 2;
                registeredCars += currentCars;
                licensePlates.offerFirst(leftoverPlates);
            }
            else {
                licensePlates.pollFirst();
                cars.pollLast();
            }

            days++;
        }

        System.out.println(registeredCars + " cars were registered for " + days + " days!");

        if (!licensePlates.isEmpty()) {
            int finalLicensePlates = 0;
            while (!licensePlates.isEmpty()) {
                finalLicensePlates += licensePlates.pollFirst();
            }
            System.out.println(finalLicensePlates + " license plates remain!");
        }
        else if (!cars.isEmpty()) {
            int finalCars = 0;
            while (!cars.isEmpty()) {
                finalCars += cars.pollLast();
            }
            System.out.println(finalCars + " cars remain without license plates!");
        }
        else {
            System.out.println("Good job! There is no queue in front of the KAT");
        }
    }
}