package JA06DefiningClasses.E08FamilyTree;

import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree {
    private Person descendent;
    private List<Person> allPeople;
    private Map<String, List<String>> relations;

    public FamilyTree() {
        this.allPeople = new ArrayList<>();
        this.relations = new LinkedHashMap<>();
    }

    public void setDescendent(Person descendent) {
        this.descendent = descendent;
    }

    public void addRelation(String parent, String child) {
        relations.putIfAbsent(parent, new ArrayList<>());
        relations.get(parent).add(child);
    }

    public void addPersonInfo(String name, String birthDate) {

        Person person = findOrCreatePerson(name, birthDate);

        if (person.getName() == null) {
            person.setName(name);
        }
        if (person.getBirthDate() == null) {
            person.setBirthDate(birthDate);
        }

        if (!allPeople.contains(person)) {
            allPeople.add(person);
        }
    }

    public void processInformation() {

        for (Map.Entry<String, List<String>> entry : relations.entrySet()) {
            Person parent = findPerson(entry.getKey());

            if (parent == null) continue;

            for (String childIdentifier : entry.getValue()) {
                Person child = findPerson(childIdentifier);
                if (child == null) continue;

                parent.addChild(child);
            }
        }

        this.descendent = findPerson(getIdentifier(descendent));
    }

    private Person findPerson(String identifier) {
        for (Person person : allPeople) {
            if ((person.getName() != null && person.getName().equals(identifier)) ||
                    (person.getBirthDate() != null && person.getBirthDate().equals(identifier))) {
                return person;
            }
        }
        return null;
    }

    private Person findOrCreatePerson(String name, String birthDate) {

        Person person = findPerson(name);
        if (person == null) {
            person = findPerson(birthDate);
        }

        if (person == null) {
            person = new Person();
            allPeople.add(person);
        }

        return person;
    }

    private String getIdentifier(Person person) {
        return person.hasName() ? person.getName() : person.getBirthDate();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(descendent.toString()).append("\n");

        result.append("Parents:").append("\n");
        if (!descendent.getParents().isEmpty()) {
            String parentsStr = descendent.getParents().stream()
                    .map(Person::toString)
                    .collect(Collectors.joining("\n"));
            result.append(parentsStr).append("\n");
        }
        
        result.append("Children:").append("\n");
        if (!descendent.getChildren().isEmpty()) {
            String childrenStr = descendent.getChildren().stream()
                    .map(Person::toString)
                    .collect(Collectors.joining("\n"));
            result.append(childrenStr);
        }

        return result.toString();
    }
}