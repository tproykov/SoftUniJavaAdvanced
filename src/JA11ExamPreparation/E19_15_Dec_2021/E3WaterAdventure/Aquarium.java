package JA11ExamPreparation.E19_15_Dec_2021.E3WaterAdventure;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Fish> getFishInPool() {
        return fishInPool;
    }

    public void setFishInPool(List<Fish> fishInPool) {
        this.fishInPool = fishInPool;
    }

    public void addFish(Fish fish) {
        if (this.capacity > fishInPool.size()) {
            fishInPool.add(fish);
        }
    }
}
