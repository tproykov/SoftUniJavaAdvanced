package JA11ExamPreparation.E15_18_Aug_2022.E03ElephantSanctuary;

public class Elephant {

    private String name;
    private int age;
    private String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        this.name = name;
        this.age = age;
        this.retiredFrom = retiredFrom;
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

    public String getRetiredFrom() {
        return retiredFrom;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " - " + this.retiredFrom;
    }
}