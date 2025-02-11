package JA06DefiningClasses.E08FamilyTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String identifier) {
        this();
        if (identifier.contains("/")) {
            this.birthDate = identifier;
        } else {
            this.name = identifier;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Person> getParents() {
        return Collections.unmodifiableList(parents);
    }

    public List<Person> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Person child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            child.addParent(this);
        }
    }

    private void addParent(Person parent) {
        if (!this.parents.contains(parent)) {
            this.parents.add(parent);
        }
    }

    public boolean hasName() {
        return this.name != null;
    }

    public boolean hasBirthDate() {
        return this.birthDate != null;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthDate);
    }
}