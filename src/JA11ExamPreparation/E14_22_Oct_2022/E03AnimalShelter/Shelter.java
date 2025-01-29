package JA11ExamPreparation.E14_22_Oct_2022.E03AnimalShelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {

    private int capacity;
    private List<Animal> animals;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.animals = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    
}
