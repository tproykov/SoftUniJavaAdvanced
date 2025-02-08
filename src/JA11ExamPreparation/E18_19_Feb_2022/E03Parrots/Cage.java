package JA11ExamPreparation.E18_19_Feb_2022.E03Parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Parrot> getData() {
        return data;
    }

    public void setData(List<Parrot> data) {
        this.data = data;
    }

    public void add(Parrot parrot) {
        if (this.capacity > data.size()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(parrot -> parrot.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        return data.stream()
                .filter(parrot -> parrot.getName().equals(name))
                .findFirst()
                .map(parrot -> {
                    parrot.setAvailable(false);
                    return parrot;
                })
                .orElse(null);
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        return data.stream()
                .filter(parrot -> parrot.getSpecies().equals(species))
                .peek(parrot -> parrot.setAvailable(false))
                .collect(Collectors.toList());
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Parrots available at ").append(this.name).append(":");
        this.data.stream()
                .filter(Parrot::isAvailable)
                .forEach(parrot -> report.append(System.lineSeparator()).append(parrot.toString()));
        return report.toString();
    }
}