package JA12Exam_15_Feb_2025.E03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Harbor {

    private String location;
    private int minDepth;
    private List<Ship> ships;

    public Harbor(String location, int minDepth) {
        this.location = location;
        this.minDepth = minDepth;
        this.ships = new ArrayList<>();
    }

    public String addShip(Ship ship) {
        if (this.ships.contains(ship)) {
            return "Ship with this name already exists!";
        }
        else if (ship.getDraft() > this.minDepth) {
            return "The ship " + ship.getName() + " cannot dock due to draft limitations!";
        }
        else {
            this.ships.add(ship);
            return "Ship " + ship.getName() + " added to the harbor.";
        }
    }

    public boolean removeShip(String name) {
        return this.ships.removeIf(ship -> ship.getName().equals(name));
    }

    public String getShipsByType(String type) {
        List<Ship> shipsByType = this.ships.stream()
                .filter(ship -> ship.getType().equals(type))
                .toList();
        if (shipsByType.isEmpty()) {
            return "There are no ships of the requested type.";
        }
        else {
            return "Ships of type " + type + ": " +
                    shipsByType.stream().map(Ship::getName).collect(Collectors.joining(", "));
        }
    }

    public Ship getShipByName(String name) {
        return this.ships.stream()
                .filter(ship -> ship.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String getLargestShip() {
        if (this.ships.isEmpty()) {
            return "No ships in the harbor.";
        }
        else {
            Ship largestShip = this.ships.stream().max(Comparator.comparing(Ship::getTonnage)).orElse(null);
            return largestShip.getName() + " is the largest ship with a tonnage of " + largestShip.getTonnage() + " tons.";
        }
    }

    public int getCount() {
        return this.ships.size();
    }

    public String getStatistics() {
        if (this.ships.isEmpty()) {
            return "No ships docked in " + this.location + ".";
        }
        else {
            StringBuilder statistics = new StringBuilder();
            statistics.append("Ships docked in ").append(location).append(":\n");
            for (Ship ship : this.ships) {
                statistics.append(("* ")).append(ship.getName()).append("\n");
            }
            return statistics.toString();
        }
    }
}