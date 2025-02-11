package JA09IteratorsAndComparators.E07EqualityLogic;

import java.util.HashSet;

public class PersonHashSet {
    private HashSet<Person> hashSet;

    public PersonHashSet() {
        hashSet = new HashSet<>();
    }

    public void add(Person person) {
        hashSet.add(person);
    }

    public int size() {
        return hashSet.size();
    }
}