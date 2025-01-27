package JA06DefiningClasses.E08FamilyTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.List;

public class FamilyTree {
    private Map<String, Person> peopleByName;
    private Map<String, Person> peopleByBirthDate;

    public FamilyTree() {
        this.peopleByName = new HashMap<>();
        this.peopleByBirthDate = new HashMap<>();
    }

    /**
     * Public so we can ensure the “search person” from the first line
     * is created immediately with the correct index.
     */
    public Person getOrCreatePerson(String identifier) {
        identifier = identifier.trim();

        // If identifier is a birth date (contains "/"):
        if (identifier.contains("/")) {
            Person person = peopleByBirthDate.get(identifier);

            // If there's no such person, create a new Person with that date
            if (person == null) {
                person = new Person(identifier);
                peopleByBirthDate.put(identifier, person);

                // Possibly there's a name-based Person that has the same birth date but was created earlier.
                for (Person p : peopleByName.values()) {
                    if (identifier.equals(p.getBirthDate()) && p != person) {
                        // Merge them carefully so the "earlier" one is the main
                        return mergePreservingEarliest(p, person);
                    }
                }
            }
            return person;

            // Otherwise, identifier must be a full name
        } else {
            Person person = peopleByName.get(identifier);

            // If there's no such person, create a new Person with that name
            if (person == null) {
                String[] names = identifier.split("\\s+");
                person = new Person(names[0], names[1]);
                peopleByName.put(identifier, person);

                // Possibly there's a date-based Person that has the same date
                for (Person p : peopleByBirthDate.values()) {
                    // If this newly created person has a known birth date that matches p's
                    if (person.getBirthDate() != null && person.getBirthDate().equals(p.getBirthDate()) && p != person) {
                        // Merge so the earliest is the main
                        return mergePreservingEarliest(person, p);
                    }
                }
            }
            return person;
        }
    }

    /**
     * Merges 'a' and 'b' into whichever has the earlier (smaller) index. Returns that earliest Person.
     */
    private Person mergePreservingEarliest(Person a, Person b) {
        Person earlier = a.getIndex() <= b.getIndex() ? a : b;
        Person later   = (earlier == a) ? b : a;

        mergePeople(earlier, later);
        return earlier;
    }

    /**
     * Merges 'other' into 'main' (i.e. 'main' keeps its identity and obtains
     * missing data/relations from 'other'), then removes 'other' from the maps.
     */
    private void mergePeople(Person main, Person other) {
        if (main == other) {
            return;
        }

        // Keep the earliest index for main
        main.setIndex(Math.min(main.getIndex(), other.getIndex()));

        // Transfer name if main lacks it
        if (main.getFirstName() == null && other.getFirstName() != null) {
            main.setFirstName(other.getFirstName());
            main.setLastName(other.getLastName());
            String fullName = main.getFirstName() + " " + main.getLastName();
            peopleByName.put(fullName, main);
        }

        // Transfer birth date if main lacks it
        if (main.getBirthDate() == null && other.getBirthDate() != null) {
            main.setBirthDate(other.getBirthDate());
            peopleByBirthDate.put(main.getBirthDate(), main);
        }

        // Merge parents
        for (Person parent : other.getParents()) {
            if (!main.getParents().contains(parent)) {
                main.getParents().add(parent);
                parent.getChildren().remove(other);
                if (!parent.getChildren().contains(main)) {
                    parent.getChildren().add(main);
                }
            }
        }

        // Merge children
        for (Person child : other.getChildren()) {
            if (!main.getChildren().contains(child)) {
                main.getChildren().add(child);
                child.getParents().remove(other);
                if (!child.getParents().contains(main)) {
                    child.getParents().add(main);
                }
            }
        }

        // Remove 'other' from the maps, if it was stored under name or birth date
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
        Person child  = getOrCreatePerson(rightSide);

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

        // Merge them ensuring the earliest is the "main"
        mergePreservingEarliest(personByName, personByDate);
    }

    public void printPerson(String identifier) {
        // Make sure we retrieve the final Person by name or date
        Person person = getOrCreatePerson(identifier);

        // If we only know birth date, fetch from the birthdate map
        if (person.getFirstName() == null && person.getBirthDate() != null) {
            person = peopleByBirthDate.get(person.getBirthDate());
        }
        // If we only know name, fetch from the name map
        else if (person.getBirthDate() == null && person.getFirstName() != null) {
            String fullName = person.getFirstName() + " " + person.getLastName();
            person = peopleByName.get(fullName);
        }

        // Print main person info
        System.out.println(person);

        // Sort parents and children by their index (i.e. first appearance)
        List<Person> sortedParents = person.getParents().stream()
                .sorted(Comparator.comparingInt(Person::getIndex))
                .toList();
        List<Person> sortedChildren = person.getChildren().stream()
                .sorted(Comparator.comparingInt(Person::getIndex))
                .toList();

        // Print parents
        System.out.println("Parents:");
        for (Person parent : sortedParents) {
            System.out.println(parent);
        }

        // Print children
        System.out.println("Children:");
        for (Person child : sortedChildren) {
            System.out.println(child);
        }
    }
}
