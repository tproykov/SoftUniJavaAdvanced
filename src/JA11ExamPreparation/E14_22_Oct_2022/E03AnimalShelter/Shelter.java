package JA11ExamPreparation.E14_22_Oct_2022.E03AnimalShelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {

    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Animal> getData() {
        return data;
    }

    public void setData(List<Animal> data) {
        this.data = data;
    }

    public void add(Animal animal) {
        if (this.capacity > this.data.size()) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(animal -> animal.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return this.data.stream()
                .filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker))
                .findFirst()
                .orElse(null);
    }

    public Animal getOldestAnimal() {
        return this.data.stream()
                .max(Comparator.comparing(Animal::getAge))
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {

        StringBuilder statistics = new StringBuilder();
        statistics.append("The shelter has the following animals:\n");
        for (Animal animal : data) {
            statistics.append(animal.toString()).append("\n");
        }
        return statistics.toString();
    }
}