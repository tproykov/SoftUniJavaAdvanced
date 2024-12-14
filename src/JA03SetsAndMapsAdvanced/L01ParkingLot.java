package JA03SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L01ParkingLot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String command;
        while (!"END".equals(command = scanner.nextLine())) {

            String[] tokens = command.split(", ");
            String commandType = tokens[0];
            String carRegistration = tokens[1];

            switch (commandType) {
                case "IN" -> parkingLot.add(carRegistration);
                case "OUT" -> parkingLot.remove(carRegistration);
            }
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        else {
            printSet(parkingLot);
        }
    }

    private static void printSet(Set<String> set) {
        for (String carRegistration : set) {
            System.out.println(carRegistration);
        }
    }
}
