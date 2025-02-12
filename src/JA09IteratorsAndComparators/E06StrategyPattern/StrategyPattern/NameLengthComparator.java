

import java.util.Comparator;

class NameLengthComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int nameLength1 = p1.getName().length();
        int nameLength2 = p2.getName().length();

        int lengthCompare = Integer.compare(nameLength1, nameLength2);
        if (lengthCompare != 0) {
            return lengthCompare;
        }

        int nameCompare = p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
        if (nameCompare != 0) {
            return nameCompare;
        }

        return Integer.compare(p1.getAge(), p2.getAge());
    }
}