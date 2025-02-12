package JA09IteratorsAndComparators.E05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        String command;
        while (!(command = scanner.nextLine()).equals("END")) {

            String[] personData = command.split(" ");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            String town = personData[2];
            people.add(new Person(name, age, town));
        }

        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();

        Person personToCompare = people.get(n - 1);

        int equalPeople = 0;
        int notEqualPeople = 0;

        for (Person person : people) {

            if (person.compareTo(personToCompare) == 0) {
                equalPeople++;
            } else {
                notEqualPeople++;
            }
        }

        if (equalPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(equalPeople + " " + notEqualPeople + " " + people.size());
        }
    }
}