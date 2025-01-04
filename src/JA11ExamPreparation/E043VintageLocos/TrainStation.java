package JA11ExamPreparation.E043VintageLocos;

import java.util.ArrayList;
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

    
}
