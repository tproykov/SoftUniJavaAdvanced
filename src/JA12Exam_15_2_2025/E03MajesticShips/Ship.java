package JA12Exam_15_Feb_2025.E03;

public class Ship {

    private String name;
    private String type;
    private int tonnage;
    private int draft;

    public Ship(String name, String type, int tonnage, int draft) {
        this.name = name;
        this.type = type;
        this.tonnage = tonnage;
        this.draft = draft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTonnage() {
        return tonnage;
    }

    public int getDraft() {
        return draft;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Type: " + this.type + ", Tonnage: " + this.tonnage + " tons, Draft: "
                + this.draft + " meters.";
    }
}