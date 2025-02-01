package JA11ExamPreparation.E15_18_Aug_2022.E03ElephantSanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Elephant elephant) {
        if (capacity > data.size()) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(elephant -> elephant.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream()
                .filter(elephant -> elephant.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }

    public Elephant getOldestElephant() {
        return data.stream().max(Comparator.comparing(Elephant::getAge))
                .orElse(null);
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {

        StringBuilder report = new StringBuilder();
        report.append("Saved elephants in the park:").append(System.lineSeparator());
        for (Elephant elephant : data) {
            report.append(elephant.getName()).append(" came from: ").append(elephant.getRetiredFrom())
                    .append(System.lineSeparator());

        }
        return report.toString();
    }
}