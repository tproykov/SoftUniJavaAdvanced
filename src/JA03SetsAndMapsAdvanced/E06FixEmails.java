package JA03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E06FixEmails {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> contactEmails = new LinkedHashMap<>();

        String command;
        while (!"stop".equals(command = scanner.nextLine())) {

            String email = scanner.nextLine();

            String[] emailParts = email.split("\\.");
            if (emailParts[emailParts.length - 1].equals("com")
                    || emailParts[emailParts.length - 1].equals("us")
                    || emailParts[emailParts.length - 1].equals("uk")) {

                continue;
            }

            contactEmails.put(command, email);
        }

        for (Map.Entry<String, String> entry : contactEmails.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}