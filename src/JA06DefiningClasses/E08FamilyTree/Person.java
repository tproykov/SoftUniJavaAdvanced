package JA06DefiningClasses.E08FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    // Global counter used to track first appearance order
    private static int globalCounter = 0;

    private int index;
    private String firstName;
    private String lastName;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    // Constructor for a Person known by name
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.index = globalCounter++;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    // Constructor for a Person known only by birth date
    public Person(String birthDate) {
        this.birthDate = birthDate;
        this.index = globalCounter++;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        // Usually we want "FirstName LastName BirthDate" if available
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName +
                    (birthDate != null ? " " + birthDate : "");
        }
        // Otherwise, if we only know birth date
        return (birthDate != null ? birthDate : "");
    }
}
