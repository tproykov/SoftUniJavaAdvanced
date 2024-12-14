package JA03SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E05Phonebook {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String command1;
        while (!"search".equals(command1 = scanner.nextLine())) {

            String[] contactParts = command1.split("-");
            String contactName = contactParts[0];
            String contactNumber = contactParts[1];

            phonebook.put(contactName, contactNumber);
        }

        String command2;
        while (!"stop".equals(command2 = scanner.nextLine())) {

            if (!phonebook.containsKey(command2)) {
                System.out.println("Contact " + command2 + " does not exist.");
            }
            else {
                System.out.println(command2 + " -> " + phonebook.get(command2));
            }
        }
    }
}