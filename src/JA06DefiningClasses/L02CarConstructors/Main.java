package JA06DefiningClasses.L02CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String brand = input[0];

            if (input.length == 1) {
                Car car = new Car(brand);
                cars.add(car);
            }
            else {
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);
                Car car = new Car(brand, model, horsePower);
                cars.add(car);
            }
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}