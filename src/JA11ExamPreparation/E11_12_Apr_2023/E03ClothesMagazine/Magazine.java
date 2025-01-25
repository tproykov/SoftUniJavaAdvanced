package JA11ExamPreparation.E11_12_Apr_2023.E03ClothesMagazine;

import java.util.ArrayList;
import java.util.List;

public class Magazine {

    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Cloth> getData() {
        return data;
    }

    public void setData(List<Cloth> data) {
        this.data = data;
    }

    
}
