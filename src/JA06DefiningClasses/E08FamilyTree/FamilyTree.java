package JA06DefiningClasses.E08FamilyTree;

import java.util.HashMap;
import java.util.Map;

public class FamilyTree {
    private Map<String, Person> peopleByName;
    private Map<String, Person> peopleByBirthDate;

    public FamilyTree() {
        this.peopleByName = new HashMap<>();
        this.peopleByBirthDate = new HashMap<>();
    }

    private Person getOrCreatePerson(String identifier) {
        identifier = identifier.trim();
        if (identifier.contains("/")) {
            Person person = peopleByBirthDate.get(identifier);
            if (person == null) {
                person = new Person(identifier);
                peopleByBirthDate.put(identifier, person);

                // Check if this person exists by name
                for (Person p : peopleByName.values()) {
                    if (identifier.equals(p.getBirthDate())) {
                        mergePeople(p, person);
                        return p;
                    }
                }
            }
            return person;
        } else {
            Person person = peopleByName.get(identifier);
            if (person == null) {
                String[] names = identifier.split("\\s+");
                person = new Person(names[0], names[1]);
                peopleByName.put(identifier, person);

                // Check if this person exists by birthdate
                for (Person p : peopleByBirthDate.values()) {
                    if (person.getBirthDate() != null && person.getBirthDate().equals(p.getBirthDate())) {
                        mergePeople(person, p);
                        break;
                    }
                }
            }
            return person;
        }
    }

    private void mergePeople(Person person1, Person person2) {
        if (person1.getFirstName() != null && person2.getBirthDate() != null) {
            person1.setBirthDate(person2.getBirthDate());
            peopleByBirthDate.put(person2.getBirthDate(), person1);

            // Transfer any relationships from person2 to person1
            for (Person parent : person2.getParents()) {
                if (!person1.getParents().contains(parent)) {
                    person1.getParents().add(parent);
                }
            }
            for (Person child : person2.getChildren()) {
                if (!person1.getChildren().contains(child)) {
                    person1.getChildren().add(child);
                }
            }
        } else if (person2.getFirstName() != null && person1.getBirthDate() != null) {
            person2.setBirthDate(person1.getBirthDate());
            peopleByBirthDate.put(person1.getBirthDate(), person2);

            // Transfer any relationships from person1 to person2
            for (Person parent : person1.getParents()) {
                if (!person2.getParents().contains(parent)) {
                    person2.getParents().add(parent);
                }
            }
            for (Person child : person1.getChildren()) {
                if (!person2.getChildren().contains(child)) {
                    person2.getChildren().add(child);
                }
            }
        }
    }

    public void addRelation(String leftSide, String rightSide) {
        Person parent = getOrCreatePerson(leftSide);
        Person child = getOrCreatePerson(rightSide);

        if (!parent.getChildren().contains(child)) {
            parent.getChildren().add(child);
        }
        if (!child.getParents().contains(parent)) {
            child.getParents().add(parent);
        }
    }

    public void addPersonInfo(String name, String birthDate) {
        Person personByName = getOrCreatePerson(name);
        Person personByDate = getOrCreatePerson(birthDate);
        mergePeople(personByName, personByDate);
    }

    public void printPerson(String identifier) {
        Person person = getOrCreatePerson(identifier);

        if (person.getFirstName() == null) {
            person = peopleByBirthDate.get(person.getBirthDate());
        } else if (person.getBirthDate() == null) {
            String fullName = person.getFirstName() + " " + person.getLastName();
            person = peopleByName.get(fullName);
        }

        System.out.println(person);

        if (!person.getParents().isEmpty()) {
            System.out.println("Parents:");
            for (Person parent : person.getParents()) {
                System.out.println(parent);
            }
        }

        if (!person.getChildren().isEmpty()) {
            System.out.println("Children:");
            for (Person child : person.getChildren()) {
                System.out.println(child);
            }
        }
    }
}