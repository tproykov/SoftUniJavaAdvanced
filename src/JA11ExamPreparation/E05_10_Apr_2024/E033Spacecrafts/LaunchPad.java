package JA11ExamPreparation.E05_10_Apr_2024.E033Spacecrafts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class LaunchPad {

    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
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

    public List<Spacecraft> getSpacecrafts() {
        return spacecrafts;
    }

    public void setSpacecrafts(List<Spacecraft> spacecrafts) {
        this.spacecrafts = spacecrafts;
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (this.capacity == spacecrafts.size()) {
            System.out.println("This launchpad is at full capacity!");
        } else {
            spacecrafts.add(spacecraft);
        }
    }

    public boolean removeSpacecraft(String name) {
        return spacecrafts.removeIf(Spacecraft -> Spacecraft.getName().equals(name));
    }

    public String getHeaviestSpacecraft() {

        if (spacecrafts.isEmpty()) {
            return "This launchpad is empty";
        }

        Spacecraft heaviestSpacecraft = spacecrafts.stream()
                .max(Comparator.comparing(Spacecraft::getWeight))
                .get();

        return String.format("%s - %dkg.", heaviestSpacecraft.getName(), heaviestSpacecraft.getWeight());
    }

    public Spacecraft getSpacecraft(String name) {
        return spacecrafts.stream()
                .filter(Spacecraft -> Spacecraft.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> spacecraftsByMissionType = spacecrafts.stream()
                .filter(Spacecraft -> Spacecraft.getMissionType().equals(missionType))
                .collect(Collectors.toList());

        if (spacecraftsByMissionType.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return spacecraftsByMissionType;
    }

    public String getStatistics() {

        if (spacecrafts.isEmpty()) {
            return String.format("Spacecrafts launched from %s:\nnone\n", this.name);
        } else {
            StringBuilder statistics = new StringBuilder();

            statistics.append("Spacecrafts launched from ").append(this.name).append(":\n");

            for (int i = 0; i < spacecrafts.size(); i++) {
                Spacecraft spacecraft = spacecrafts.get(i);
                statistics.append(String.format("%s. %s\n", i + 1, spacecraft.getName()));
            }

            return statistics.toString();
        }
    }
}