package JA06DefiningClasses.E08FamilyTree;

import java.util.HashMap;
import java.util.Map;

public class FamilyTree {

    Map<String, Person> peopleByName = new HashMap<>();
    Map<String, Person> peopleByBirthDate = new HashMap<>();

    private Person getOrCreatePerson(String identifier) {
        // Check if it's a date (contains '/')
        if (identifier.contains("/")) {
            if (!peopleByBirthDate.containsKey(identifier)) {
                peopleByBirthDate.put(identifier, new Person(identifier));
            }
            return peopleByBirthDate.get(identifier);
        } else {
            // It's a name
            String[] names = identifier.split(" ");
            String key = identifier;
            if (!peopleByName.containsKey(key)) {
                peopleByName.put(key, new Person(names[0], names[1]));
            }
            return peopleByName.get(key);
        }
    }

    private void mergePeople(Person person1, Person person2) {
        if (person1.firstName != null && person2.birthDate != null) {
            person1.birthDate = person2.birthDate;
            peopleByBirthDate.put(person2.birthDate, person1);
        } else if (person2.firstName != null && person1.birthDate != null) {
            person2.birthDate = person1.birthDate;
            peopleByBirthDate.put(person1.birthDate, person2);
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

        // Find the complete person info if we only have partial
        if (person.firstName == null) {
            person = peopleByBirthDate.get(person.birthDate);
        } else if (person.birthDate == null) {
            String fullName = person.firstName + " " + person.lastName;
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