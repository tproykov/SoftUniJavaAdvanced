package JA11ExamPreparation.E15_18_Aug_2022.E03ElephantSanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<Elephant>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Elephant> getData() {
        return data;
    }

    public void setData(List<Elephant> data) {
        this.data = data;
    }

    public void add(Elephant elephant) {
        if (capacity > data.size()) {
            data.add(elephant);
        }
    }


}
