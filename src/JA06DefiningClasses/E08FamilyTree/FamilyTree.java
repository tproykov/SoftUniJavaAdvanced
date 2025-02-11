package JA06DefiningClasses.E08FamilyTree;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class FamilyTree {
    private Map<String, Person> peopleByName;
    private Map<String, Person> peopleByBirthDate;

    public FamilyTree() {
        this.peopleByName = new HashMap<>();
        this.peopleByBirthDate = new HashMap<>();
    }

    public Person getOrCreatePerson(String identifier) {
        identifier = identifier.trim();

        if (identifier.contains("/")) {

            Person byDate = peopleByBirthDate.get(identifier);
            if (byDate == null) {

                byDate = new Person(identifier);
                peopleByBirthDate.put(identifier, byDate);

                for (Person p : peopleByName.values()) {
                    if (identifier.equals(p.getBirthDate()) && p != byDate) {
                        return mergePreservingEarliest(p, byDate);
                    }
                }
            }
            return byDate;
        } else {

            Person byName = peopleByName.get(identifier);
            if (byName == null) {

                String[] tokens = identifier.split("\\s+");
                byName = new Person(tokens[0], tokens[1]);
                peopleByName.put(identifier, byName);

                for (Person p : peopleByBirthDate.values()) {
                    if (byName.getBirthDate() != null &&
                            byName.getBirthDate().equals(p.getBirthDate()) &&
                            p != byName) {
                        return mergePreservingEarliest(byName, p);
                    }
                }
            }
            return byName;
        }
    }

    private Person mergePreservingEarliest(Person a, Person b) {
        Person earlier = (a.getIndex() <= b.getIndex()) ? a : b;
        Person later   = (earlier == a) ? b : a;

        mergePeople(earlier, later);
        return earlier;
    }

    private void mergePeople(Person main, Person other) {
        if (main == other) {
            return;
        }

        main.setIndex(Math.min(main.getIndex(), other.getIndex()));

        if ((main.getFirstName() == null || main.getLastName() == null) &&
                other.getFirstName() != null && other.getLastName() != null) {
            main.setFirstName(other.getFirstName());
            main.setLastName(other.getLastName());
            String fullName = main.getFirstName() + " " + main.getLastName();
            peopleByName.put(fullName, main);
        }

        if (main.getBirthDate() == null && other.getBirthDate() != null) {
            main.setBirthDate(other.getBirthDate());
            peopleByBirthDate.put(main.getBirthDate(), main);
        }

        for (Person parent : other.getParents()) {
            if (!main.getParents().contains(parent)) {
                main.getParents().add(parent);
                parent.getChildren().remove(other); // remove old child link
                if (!parent.getChildren().contains(main)) {
                    parent.getChildren().add(main);
                }
            }
        }

        for (Person child : other.getChildren()) {
            if (!main.getChildren().contains(child)) {
                main.getChildren().add(child);
                child.getParents().remove(other); // remove old parent link
                if (!child.getParents().contains(main)) {
                    child.getParents().add(main);
                }
            }
        }

        if (other.getFirstName() != null && other.getLastName() != null) {
            String oldName = other.getFirstName() + " " + other.getLastName();
            peopleByName.remove(oldName);
        }
        if (other.getBirthDate() != null) {
            peopleByBirthDate.remove(other.getBirthDate());
        }
    }

    public void addPersonInfo(String name, String birthDate) {

        Person byName = peopleByName.get(name);
        Person byDate = peopleByBirthDate.get(birthDate);

        String[] nameParts = name.split("\\s+");
        String firstName = nameParts[0];
        String lastName  = nameParts[1];

        if (byName == null && byDate == null) {

            Person newPerson = new Person(firstName, lastName);
            newPerson.setBirthDate(birthDate);

            peopleByName.put(name, newPerson);
            peopleByBirthDate.put(birthDate, newPerson);

        } else if (byName != null && byDate == null) {
            byName.setBirthDate(birthDate);
            peopleByBirthDate.put(birthDate, byName);

        } else if (byName == null && byDate != null) {
            byDate.setFirstName(firstName);
            byDate.setLastName(lastName);
            peopleByName.put(name, byDate);

        } else {

            Person merged = mergePreservingEarliest(byName, byDate);

            if (merged.getFirstName() == null || merged.getLastName() == null) {
                merged.setFirstName(firstName);
                merged.setLastName(lastName);
                peopleByName.put(name, merged);
            }
            if (merged.getBirthDate() == null) {
                merged.setBirthDate(birthDate);
                peopleByBirthDate.put(birthDate, merged);
            }
        }
    }

    public void addRelation(String leftSide, String rightSide) {
        Person parent = getOrCreatePerson(leftSide);
        Person child  = getOrCreatePerson(rightSide);

        if (!parent.getChildren().contains(child)) {
            parent.getChildren().add(child);
        }
        if (!child.getParents().contains(parent)) {
            child.getParents().add(parent);
        }
    }

    private Person findPerson(String identifier) {
        Person person = peopleByName.get(identifier);
        if (person == null) {
            person = peopleByBirthDate.get(identifier);
        }
        return person;
    }

    public void printPerson(String identifier) {

        Person person = findPerson(identifier);
        if (person == null) {
            person = getOrCreatePerson(identifier);
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
