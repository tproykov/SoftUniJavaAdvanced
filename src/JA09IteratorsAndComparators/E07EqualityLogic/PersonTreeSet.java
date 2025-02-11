package JA09IteratorsAndComparators.E07EqualityLogic;

import java.util.TreeSet;

public class PersonTreeSet {
    private TreeSet<Person> treeSet;

    public PersonTreeSet() {
        treeSet = new TreeSet<>();
    }

    public void add(Person person) {
        treeSet.add(person);
    }

    public int size() {
        return treeSet.size();
    }
}