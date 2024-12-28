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
            if (!peopleByBirthDate.containsKey(identifier)) {
                peopleByBirthDate.put(identifier, new Person(identifier));
            }
            return peopleByBirthDate.get(identifier);
        } else {
            if (!peopleByName.containsKey(identifier)) {
                String[] names = identifier.split("\\s+");
                peopleByName.put(identifier, new Person(names[0], names[1]));
            }
            return peopleByName.get(identifier);
        }
    }

    private void mergePeople(Person person1, Person person2) {

        if (person1.getFirstName() != null && person2.getBirthDate() != null) {
            person1.setBirthDate(person2.getBirthDate());
            peopleByBirthDate.put(person2.getBirthDate(), person1);
        } else if (person2.getFirstName() != null && person1.getBirthDate() != null) {
            person2.setBirthDate(person1.getBirthDate());
            peopleByBirthDate.put(person1.getBirthDate(), person2);
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