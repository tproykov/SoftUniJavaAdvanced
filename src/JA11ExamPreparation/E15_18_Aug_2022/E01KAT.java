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

        while (!licensePlates.isEmpty() && !cars.isEmpty()) {

            int currentLicensePlates = licensePlates.peekFirst();
            int currentCars = cars.peekLast();

            if (currentCars > currentLicensePlates * 2) {
                licensePlates.pollFirst();
                cars.pollLast();
                int leftoverCars = currentCars - currentLicensePlates * 2;
                cars.offerLast(leftoverCars);
            }
            else if (currentCars < currentLicensePlates * 2) {
                licensePlates.pollFirst();
                cars.pollLast();
                int leftoverPlates = currentLicensePlates - currentCars * 2;
                licensePlates.offerFirst(leftoverPlates);
            }
            else {
                
            }










        }



    }



}




