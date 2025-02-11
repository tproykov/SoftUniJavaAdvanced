package JA09IteratorsAndComparators.E07EqualityLogic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        PersonTreeSet personTreeSet = new PersonTreeSet();
        PersonHashSet personHashSet = new PersonHashSet();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);

            Person person = new Person(name, age);
            personTreeSet.add(person);
            personHashSet.add(person);
        }

        System.out.println(personTreeSet.size());
        System.out.println(personHashSet.size());
    }
}
