package JA06DefiningClasses.E08FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    String firstName;
    String lastName;
    String birthDate;
    private List<Person> parents = new ArrayList<>();
    private List<Person> children = new ArrayList<>();

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Person(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        if (firstName != null) {
            return firstName + " " + lastName + " " + birthDate;
        }
        return birthDate;
    }
}