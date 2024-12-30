package JA09IteratorsAndComparators.E00Demo;

import java.util.Comparator;

public class CarComparator implements Comparator<Car>{

    private CarComparator() {

    }

    static Comparator<Car> carComparator = (car1, car2) -> {
        if (car1.getHorsePower() == car2.getHorsePower()) {
            return 0;
        } else if (car1.getHorsePower() > car2.getHorsePower()) {
            return 1;
        }

        return -1;
    };

    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getHorsePower() == car2.getHorsePower()) {
            return 0;
        } else if (car1.getHorsePower() > car2.getHorsePower()) {
            return 1;
        }

        return -1;
    }
}