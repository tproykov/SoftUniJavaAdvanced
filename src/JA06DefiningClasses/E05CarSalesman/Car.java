package JA06DefiningClasses.E05CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }

    public Car(String model, Engine engine) {
        this(model, engine, 0, "");
    }



}
