package JA11ExamPreparation.E04_22_Jun_2024.E043VintageLocos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainStation {

    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
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

    public int getRailGauge() {
        return railGauge;
    }

    public void setRailGauge(int railGauge) {
        this.railGauge = railGauge;
    }

    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    public void setLocomotives(List<Locomotive> locomotives) {
        this.locomotives = locomotives;
    }

    public void addLocomotive(Locomotive locomotive) {
        if (locomotives.size() >= this.capacity) {
            System.out.println("This train station is full!");
        } else if (this.railGauge != locomotive.getGauge()) {
            int difference = Math.abs(this.railGauge - locomotive.getGauge());
            System.out.println("The rail gauge of this station does not match the locomotive gauge! Difference: "
                    + difference + " mm.");
        } else {
            locomotives.add(locomotive);
        }
    }

    public boolean removeLocomotive(String name) {
        return locomotives.removeIf(locomotive -> locomotive.getName().equals(name));
    }

    public String getFastestLocomotive() {

        if (locomotives.isEmpty()) {
            return "There are no locomotives.";
        }

        Locomotive fastestLocomotive = locomotives.stream().max(Comparator.comparing(Locomotive::getMaxSpeed)).get();

        return String.format("%s is the fastest locomotive with a maximum speed of %d km/h."
                , fastestLocomotive.getName(), fastestLocomotive.getMaxSpeed());
    }

    public Locomotive getLocomotive(String name) {
        return locomotives.stream()
                .filter(locomotive -> locomotive.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return locomotives.size();
    }

    public String getOldestLocomotive() {
        if (locomotives.isEmpty()) {
            return "There are no locomotives.";
        }
        else {
            return locomotives.stream()
                    .min(Comparator.comparing(Locomotive::getBuildDate))
                    .map(Locomotive::getName)
                    .orElse("There are no locomotives.");
        }
    }

    public String getStatistics() {

        if (locomotives.isEmpty()) {
            return "There are no locomotives departing from " + this.name + " station.";
        }
        else {

            StringBuilder statistics = new StringBuilder();
            statistics.append("Locomotives departed from ").append(this.name).append(":\n");
            for (int i = 0; i < locomotives.size(); i++) {
                Locomotive locomotive = locomotives.get(i);
                String locomotiveName = locomotive.getName();

                statistics.append(String.format("%d. %s\n", i + 1, locomotiveName));
            }

            return statistics.toString().trim();
        }
    }
}