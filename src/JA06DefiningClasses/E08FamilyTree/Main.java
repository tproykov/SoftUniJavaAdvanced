package JA06DefiningClasses.E08FamilyTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FamilyTree familyTree = new FamilyTree();

        String searchPerson = scanner.nextLine();
        familyTree.setDescendent(createPerson(searchPerson));

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] tokens = input.split(" - ");

            if (tokens.length == 2) {

                String parent = tokens[0].trim();
                String child = tokens[1].trim();
                familyTree.addRelation(parent, child);
            } else {

                String birthDate = input.substring(input.lastIndexOf(" ") + 1);
                String name = input.substring(0, input.lastIndexOf(" "));
                familyTree.addPersonInfo(name, birthDate);
            }
        }

        familyTree.processInformation();

        System.out.print(familyTree);
    }

    private static Person createPerson(String input) {
        if (input.contains("/")) {
            return new Person(input);
        } else {
            return new Person(input);
        }
    }
}