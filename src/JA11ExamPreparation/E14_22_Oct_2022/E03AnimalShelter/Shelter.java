package JA11ExamPreparation.E14_22_Oct_2022.E03AnimalShelter;

import java.util.ArrayList;
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


}
