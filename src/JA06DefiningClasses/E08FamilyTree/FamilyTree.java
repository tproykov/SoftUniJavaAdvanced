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

    /**
     * Looks up or creates a person by either name or date (depending on the identifier).
     * This is used primarily for the lines "X - Y" where X or Y is either a name or date,
     * but never both.
     */
    public Person getOrCreatePerson(String identifier) {
        identifier = identifier.trim();

        if (identifier.contains("/")) {
            // It's a birth date
            Person byDate = peopleByBirthDate.get(identifier);
            if (byDate == null) {
                // Create a new Person known only by this date
                byDate = new Person(identifier);
                peopleByBirthDate.put(identifier, byDate);

                // Check if there's some existing Person by name that actually has this date
                // (rare corner case where name was created first, date second)
                for (Person p : peopleByName.values()) {
                    if (identifier.equals(p.getBirthDate()) && p != byDate) {
                        return mergePreservingEarliest(p, byDate);
                    }
                }
            }
            return byDate;
        } else {
            // It's a full name
            Person byName = peopleByName.get(identifier);
            if (byName == null) {
                // Create a new Person known only by this name
                String[] tokens = identifier.split("\\s+");
                byName = new Person(tokens[0], tokens[1]);
                peopleByName.put(identifier, byName);

                // Check if there's an existing Person by date that matches this new one's date
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

    /**
     * Merges two Person objects, preserving the one with the earlier index as 'main'.
     */
    private Person mergePreservingEarliest(Person a, Person b) {
        Person earlier = (a.getIndex() <= b.getIndex()) ? a : b;
        Person later   = (earlier == a) ? b : a;

        mergePeople(earlier, later);
        return earlier;
    }

    /**
     * Merges 'other' into 'main':
     * - if main is missing name or birth date, fill them from 'other'
     * - unify parent/child relationships
     * - remove 'other' from the maps
     */
    private void mergePeople(Person main, Person other) {
        if (main == other) {
            return;
        }

        // Keep the earliest index
        main.setIndex(Math.min(main.getIndex(), other.getIndex()));

        // Transfer name if main lacks it
        if ((main.getFirstName() == null || main.getLastName() == null) &&
                other.getFirstName() != null && other.getLastName() != null) {
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

        // Merge parent relationships
        for (Person parent : other.getParents()) {
            if (!main.getParents().contains(parent)) {
                main.getParents().add(parent);
                parent.getChildren().remove(other); // remove old child link
                if (!parent.getChildren().contains(main)) {
                    parent.getChildren().add(main);
                }
            }
        }

        // Merge child relationships
        for (Person child : other.getChildren()) {
            if (!main.getChildren().contains(child)) {
                main.getChildren().add(child);
                child.getParents().remove(other); // remove old parent link
                if (!child.getParents().contains(main)) {
                    child.getParents().add(main);
                }
            }
        }

        // Remove 'other' from the maps
        if (other.getFirstName() != null && other.getLastName() != null) {
            String oldName = other.getFirstName() + " " + other.getLastName();
            peopleByName.remove(oldName);
        }
        if (other.getBirthDate() != null) {
            peopleByBirthDate.remove(other.getBirthDate());
        }
    }

    /**
     * Called for lines of the form "{FirstName} {LastName} {day/month/year}"
     * which unify name + birth date for a single person.
     */
    public void addPersonInfo(String name, String birthDate) {
        // We need to unify them without double-counting.
        Person byName = peopleByName.get(name);
        Person byDate = peopleByBirthDate.get(birthDate);

        String[] nameParts = name.split("\\s+");
        String firstName = nameParts[0];
        String lastName  = nameParts[1];

        if (byName == null && byDate == null) {
            // No one exists yet with this name or date -> create a SINGLE new Person
            Person newPerson = new Person(firstName, lastName);
            newPerson.setBirthDate(birthDate);

            // Store in both maps
            peopleByName.put(name, newPerson);
            peopleByBirthDate.put(birthDate, newPerson);

        } else if (byName != null && byDate == null) {
            // A person with this name already exists but has no date set
            byName.setBirthDate(birthDate);
            peopleByBirthDate.put(birthDate, byName);

        } else if (byName == null && byDate != null) {
            // A person with this date already exists but has no (or incomplete) name
            byDate.setFirstName(firstName);
            byDate.setLastName(lastName);
            peopleByName.put(name, byDate);

        } else {
            // Both exist -> we must merge them (they refer to the same real person)
            Person merged = mergePreservingEarliest(byName, byDate);
            // Ensure the merged has the correct name and birth date
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

    /**
     * Called for lines like "X - Y", meaning X is a parent of Y (X and Y each can be name or date).
     */
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

    /**
     * Prints the person with all info, ordering parents/children by
     * their first appearance in the input (the Person's index).
     */
    public void printPerson(String identifier) {
        // Make sure we fetch the final 'merged' person from the correct map
        Person person;
        if (identifier.contains("/")) {
            // It's a birth date
            person = peopleByBirthDate.get(identifier);
        } else {
            // It's a full name
            person = peopleByName.get(identifier);
        }
        // Sanity fallback if missing (should not happen in valid inputs)
        if (person == null) {
            person = getOrCreatePerson(identifier);
        }

        // Print "Name LastName BirthDate" on the first line
        System.out.println(person);

        // Sort parents and children by the index (first appearance)
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
