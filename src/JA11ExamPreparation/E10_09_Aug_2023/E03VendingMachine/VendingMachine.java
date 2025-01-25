package JA11ExamPreparation.E10_09_Aug_2023.E03VendingMachine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getButtonCapacity() {
        return buttonCapacity;
    }

    public void setButtonCapacity(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (buttonCapacity > drinks.size()) {
            this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        return this.drinks.removeIf(drink -> drink.getName().equals(name));
    }

    public Drink getLongest() {
        return this.drinks.stream()
                .max(Comparator.comparingInt(Drink::getVolume))
                .orElse(null);
    }

    public Drink getCheapest() {
        return this.drinks.stream()
                .min(Comparator.comparing(Drink::getPrice))
                .orElse(null);
    }

    public String buyDrink(String name) {
        Drink drink = this.drinks.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElse(null);
        return drink != null ? drink.toString().trim() : "";
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Drinks available:").append("\n");
        drinks.forEach(drink -> stringBuilder.append(drink.getName().trim()).append("\n"));
        return stringBuilder.toString();
    }
}