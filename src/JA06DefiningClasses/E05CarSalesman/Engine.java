package JA06DefiningClasses.E05CarSalesman;

public class Engine {

    private String model;
    private int horsePower;
    private int displacement;
    private String efficiency;

    public Engine(String model, int horsePower, int displacement, String efficiency) {
        this.model = model;
        this.horsePower = horsePower;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int horsePower, int displacement) {
        this(model, horsePower, displacement, "");
    }

    public Engine(String model, int horsePower, String efficiency) {
        this(model, horsePower, 0, efficiency);
    }

    public Engine(String model, int horsePower) {
        this(model, horsePower, 0, "");
    }


}