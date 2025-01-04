package JA11ExamPreparation.E06_17_Feb_2024.E063ChasingSharks;

import java.util.ArrayList;
import java.util.List;

public class Basin {

    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
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

    public List<Shark> getSharks() {
        return sharks;
    }

    public void setSharks(List<Shark> sharks) {
        this.sharks = sharks;
    }


}