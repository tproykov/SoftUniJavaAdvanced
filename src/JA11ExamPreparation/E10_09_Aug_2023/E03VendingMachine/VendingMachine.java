package JA11ExamPreparation.E10_09_Aug_2023.E03VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }






}
