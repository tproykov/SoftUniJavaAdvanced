package JA06DefiningClasses.E08FamilyTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

                for (Person p : peopleByName.values()) {
                    if (identifier.equals(p.getBirthDate()) && p != person) {
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

    private void mergePeople(Person main, Person other) {
        if (main == other) {
            return;
        }

        main.setIndex(Math.min(main.getIndex(), other.getIndex()));

        if (main.getFirstName() == null && other.getFirstName() != null) {
            main.setFirstName(other.getFirstName());
            main.setLastName(other.getLastName());
            String fullName = main.getFirstName() + " " + main.getLastName();
            peopleByName.put(fullName, main);
        }

        if (main.getBirthDate() == null && other.getBirthDate() != null) {
            main.setBirthDate(other.getBirthDate());
            peopleByBirthDate.put(main.getBirthDate(), main);
        }

        for (Person p : other.getParents()) {
            if (!main.getParents().contains(p)) {
                main.getParents().add(p);
            }
        }

        for (Person c : other.getChildren()) {
            if (!main.getChildren().contains(c)) {
                main.getChildren().add(c);
            }
        }

        for (Person parent : other.getParents()) {
            List<Person> parentChildren = parent.getChildren();
            for (int i = 0; i < parentChildren.size(); i++) {
                if (parentChildren.get(i) == other) {
                    parentChildren.set(i, main);
                }
            }
        }

        for (Person child : other.getChildren()) {
            List<Person> childParents = child.getParents();
            for (int i = 0; i < childParents.size(); i++) {
                if (childParents.get(i) == other) {
                    childParents.set(i, main);
                }
            }
        }

        if (other.getFirstName() != null) {
            String fullName = other.getFirstName() + " " + other.getLastName();
            peopleByName.remove(fullName);
        }
        if (other.getBirthDate() != null) {
            peopleByBirthDate.remove(other.getBirthDate());
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

        if (person.getFirstName() == null && person.getBirthDate() != null) {
            person = peopleByBirthDate.get(person.getBirthDate());
        } else if (person.getBirthDate() == null && person.getFirstName() != null) {
            String fullName = person.getFirstName() + " " + person.getLastName();
            person = peopleByName.get(fullName);
        }

        System.out.println(person);

        List<Person> sortedParents = person.getParents().stream()
                .sorted(Comparator.comparingInt(Person::getIndex))
                .toList();
        List<Person> sortedChildren = person.getChildren().stream()
                .sorted(Comparator.comparingInt(Person::getIndex))
                .toList();

        System.out.println("Parents:");
        for (Person parent : sortedParents) {
            System.out.println(parent);
        }

        System.out.println("Children:");
        for (Person child : sortedChildren) {
            System.out.println(child);
        }
    }
}
