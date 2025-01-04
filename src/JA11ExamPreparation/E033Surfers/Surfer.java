package JA11ExamPreparation.E033Surfers;

public class Surfer {

    private String name;
    private int age;
    private int experience;
    private Boolean ownsASurfBoard;
    private int money;

    public Surfer(String name, int age, int experience, boolean ownsASurfBoard, int money) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.ownsASurfBoard = ownsASurfBoard;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public boolean ownsASurfBoard() {
        return ownsASurfBoard;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.format("Surfer %s is %d years old and has %d years surfing experience.", name, age, experience);
    }
}