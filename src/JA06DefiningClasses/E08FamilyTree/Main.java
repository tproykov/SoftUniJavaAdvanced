package JA06DefiningClasses.E08FamilyTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FamilyTree familyTree = new FamilyTree();

        // Read the first line - it can be EITHER a name or a birth date
        String searchPerson = scanner.nextLine().trim();

        // Create or retrieve that person immediately, so it has the earliest index
        // (If it's a name or date only, we can still do getOrCreatePerson)
        familyTree.getOrCreatePerson(searchPerson);

        String line;
        while (!(line = scanner.nextLine()).equals("End")) {
            if (line.contains(" - ")) {
                // This line specifies a parent-child relationship
                String[] parts = line.split(" - ");
                familyTree.addRelation(parts[0].trim(), parts[1].trim());
            } else {
                // This line is of the form "{FirstName} {LastName} {day/month/year}"
                // which ties together a name and a date for the same person
                String[] parts = line.split(" ");
                String birthDate = parts[parts.length - 1];
                String name = line.substring(0, line.length() - birthDate.length() - 1).trim();
                familyTree.addPersonInfo(name, birthDate);
            }
        }

        // Finally, print the requested person's info
        familyTree.printPerson(searchPerson);
    }
}
