package JA06DefiningClasses.E07Google;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        String command;
        while (!("End".equals(command = scanner.nextLine()))) {

            String[] tokens = command.split("\\s+");
            String name = tokens[0];
            String category = tokens[1];

            people.putIfAbsent(name, new Person(name));
            Person person = people.get(name);

            switch (category) {

                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    person.addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    person.addParent(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child child = new Child(childName, childBirthday);
                    person.addChild(child);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    person.setCar(car);
                    break;
            }
        }

        String searchName = scanner.nextLine();
        if (people.containsKey(searchName)) {
            System.out.println(people.get(searchName));
        }
    }
}