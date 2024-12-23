package JA06DefiningClasses.E03SpeedRacing;

public class Car {

    private String model;
    private double fuelInTank;
    private double fuelPerKm;
    private int distanceTravelled;

    public Car(String model, int fuelInTank, double fuelPerKm) {
        this.model = model;
        this.fuelInTank = fuelInTank;
        this.fuelPerKm = fuelPerKm;
        this.distanceTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelInTank;
    }

    public void setFuelAmount(int fuelInTank) {
        this.fuelInTank = fuelInTank;
    }

    public double getFuelCostPerKm() {
        return fuelPerKm;
    }

    public void setFuelCostPerKm(double fuelPerKm) {
        this.fuelPerKm = fuelPerKm;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public boolean inFuelRange(String model, int distanceInKms) {
        double fuelNeeded = this.fuelPerKm * distanceInKms;
        if (fuelNeeded <= this.fuelInTank) {
            this.fuelInTank -= fuelNeeded;
            this.distanceTravelled += distanceInKms;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s", this.model, this.fuelInTank, this.distanceTravelled);
    }
}