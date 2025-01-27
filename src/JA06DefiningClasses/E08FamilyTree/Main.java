package JA06DefiningClasses.E08FamilyTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FamilyTree familyTree = new FamilyTree();

        String searchPerson = scanner.nextLine().trim();

        familyTree.getOrCreatePerson(searchPerson);

        String line;
        while (!(line = scanner.nextLine()).equals("End")) {

            if (line.contains(" - ")) {
                String[] parts = line.split(" - ");
                familyTree.addRelation(parts[0].trim(), parts[1].trim());
            } else {
                String[] parts = line.split(" ");
                String birthDate = parts[parts.length - 1];
                String name = line.substring(0, line.length() - birthDate.length() - 1).trim();
                familyTree.addPersonInfo(name, birthDate);
            }
        }

        familyTree.printPerson(searchPerson);
    }
}
