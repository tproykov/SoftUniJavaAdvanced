package JA06DefiningClasses.E03SpeedRacing;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int fuelAmount = Integer.parseInt(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKm);
            cars.put(car.getModel(), car);
        }

        String command;
        while (!"End".equals(command = scanner.nextLine())) {

            String[] tokens = command.split("\\s+");
            String model = tokens[1];
            int distanceInKms = Integer.parseInt(tokens[2]);

            Car car = cars.get(model);
            if (!car.inFuelRange(model, distanceInKms)) {
                System.out.println("Insufficient fuel for the drive");
            }
        }

        cars.values().forEach(System.out::println);
    }
}