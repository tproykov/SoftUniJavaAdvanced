package JA09IteratorsAndComparators.E01Demo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] varArgs = {"2023", "WBAN244348304"};

        Car opel = new Car("Opel", 105);
        Car tesla = new Car("Tesla", 500, "2023");
        Car tesla3 = new Car("Tesla", 700, varArgs);

        int res = opel.compareTo(tesla);

        List<Car> cars = List.of(opel, tesla, tesla3);

                cars.stream()
//            .sorted((car1, car2) -> car1.compareTo(car2))
            .sorted(CarComparator.carComparator.reversed())
            .forEach(System.out::println);

        Comparator<Car> carComparator = CarComparator.carComparator;
        System.out.println(carComparator.compare(opel, tesla));

        someMethod(CarComparator.carComparator, opel, tesla);

        // demo.Garage Iterator example
        Garage garage = new Garage(new Car[] {opel, tesla, tesla3});

//        for (demo.Car car : garage) {
//
//        }
        Iterator<Car> iterator = garage.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    static void someMethod(Comparator<Car> carComparator, Car car1, Car car2){
        System.out.println(carComparator.compare(car1, car2));
    }
}