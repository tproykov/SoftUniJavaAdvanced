package JA11ExamPreparation.E17_13_Apr_2022.E03EasterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {

    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Egg> getData() {
        return data;
    }

    public void setData(List<Egg> data) {
        this.data = data;
    }

    public void addEgg(Egg egg) {
        if (this.capacity > this.data.size()) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return this.data.removeIf(egg -> egg.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        return this.data.stream()
                .max(Comparator.comparing(Egg::getStrength))
                .orElse(null);
    }

    public Egg getEgg(String color) {
        return this.data.stream()
                .filter(egg -> egg.getColor().equals(color))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(this.material).append(" basket contains:").append(System.lineSeparator());
        for (int i = 0; i < data.size(); i++) {
            report.append(data.get(i).toString());
            if (i != data.size() - 1) {
                report.append(System.lineSeparator());
            }
        }
        return report.toString();
    }
}