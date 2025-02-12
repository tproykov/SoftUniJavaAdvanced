package JA09IteratorsAndComparators.E06StrategyPattern;

import java.util.Comparator;

class NameLengthComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int nameLength1 = p1.getName().length();
        int nameLength2 = p2.getName().length();

        if (nameLength1 != nameLength2) {
            return Integer.compare(nameLength1, nameLength2);
        }

        return Character.compare(
                Character.toLowerCase(p1.getName().charAt(0)),
                Character.toLowerCase(p2.getName().charAt(0)));
    }
}