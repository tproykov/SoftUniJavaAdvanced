package JA11ExamPreparation.E08_21_Oct_2023.E083Halloween;

import java.util.ArrayList;
import java.util.List;

public class House {

    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.capacity > this.data.size()) {
            data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Kid getKid(String street) {
        return data.stream().filter(e -> e.getStreet().equals(street))
                .findFirst()
                .orElse(null);
    }

    public int getAllKids() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append("Children who visited a house for candy:").append(("\n"));
        for (Kid kid : data) {
            output.append(kid.getName()).append(" from ").append(kid.getStreet()).append(" street").append(("\n"));
        }
        return output.toString();
    }
}