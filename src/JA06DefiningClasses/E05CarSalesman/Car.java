package JA06DefiningClasses.E05CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "";

    }
}
