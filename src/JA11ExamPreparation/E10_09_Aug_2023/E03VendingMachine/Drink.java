package JA11ExamPreparation.E10_09_Aug_2023.E03VendingMachine;

import java.math.BigDecimal;

public class Drink {

    private String name;
    private BigDecimal price;
    private int volume;

    public Drink(String name, BigDecimal price, int volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %.2f, Volume: %d ml", name, price, volume);
    }




}
