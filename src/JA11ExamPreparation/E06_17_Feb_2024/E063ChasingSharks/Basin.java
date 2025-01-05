package JA11ExamPreparation.E06_17_Feb_2024.E063ChasingSharks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public void addShark(Shark shark) {
        if (this.capacity > this.sharks.size()) {
            this.sharks.add(shark);
        }
        else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind) {
        return sharks.removeIf(shark -> shark.getKind().equals(kind));
    }

    public Shark getLargestShark() {

        if (sharks.isEmpty()) {
            return null;
        }

        Shark LargestShark = sharks.stream()
                .max(Comparator.comparing(Shark::getLength))
                .orElse(null);

        return LargestShark;
    }

    public Shark getShark(String kind) {
        return sharks.stream()
                .filter(Shark -> Shark.getKind().equals(kind))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return sharks.size();
    }

    public int getAverageLength() {
        return (int) sharks.stream()
                .mapToInt(Shark::getLength)
                .average()
                .orElse(0.0);
    }

    public String report() {
        return String.format("Sharks in %s:\n", this.name) +
                sharks.stream()
                        .map(shark -> String.format(
                                "This %s is %d centimeters long, eats %s and inhabits %s.",
                                shark.getKind(), shark.getLength(), shark.getFood(), shark.getHabitation()))
                        .collect(Collectors.joining("\n"));
    }
}