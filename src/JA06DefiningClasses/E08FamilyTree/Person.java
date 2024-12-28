package JA06DefiningClasses.E08FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String birthDate) {
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        if (firstName != null) {
            return firstName + " " + lastName + " " + birthDate;
        }
        return birthDate;
    }
}