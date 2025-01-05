package JA11ExamPreparation.E07_13_Dec_2023.E073FishingPond;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pond {

    private int capacity;
    private List<Fish> fishList;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishList = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Fish> getFishList() {
        return fishList;
    }

    public void setFishList(List<Fish> fishList) {
        this.fishList = fishList;
    }

    public void addFish(Fish fish) {
        if (capacity > fishList.size()) {
            fishList.add(fish);
        }
    }

    public boolean removeFish(String species) {
        if (fishList.isEmpty()) {
            return false;
        }
        return fishList.removeIf(fish -> fish.getSpecies().equals(species));
    }

    public Fish getOldestFish() {
        if (fishList.isEmpty()) {
            return null;
        }
        return fishList.stream()
                .max(Comparator.comparing(Fish::getAge))
                .get();
    }

    public Fish getFish(String species) {
        return fishList.stream()
                .filter(Fish -> Fish.getSpecies().equals(species))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return fishList.size();
    }

    public int getVacancies() {
        return this.capacity - fishList.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Fishes in the pond: ").append("\n");

        for (Fish fish : fishList) {
            report.append("This ").append(fish.getSpecies())
                    .append(" is ").append(fish.getAge()).append(" years old and reproduces through ")
                    .append(fish.getMatingSeason()).append("\n");
        }
        return report.toString();
    }
}