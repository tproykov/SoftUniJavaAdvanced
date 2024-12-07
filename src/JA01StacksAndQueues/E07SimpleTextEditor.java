package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E07SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String[]> operations = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String[] commandParts = scanner.nextLine().split("\\s+");

            switch (commandParts[0]) {

                case "1" -> {
                    String stringToAppend = commandParts[1];
                    text.append(stringToAppend);
                    operations.push(new String[]{"1", stringToAppend});
                }

                case "2" -> {
                    int countToBeDeleted = Integer.parseInt(commandParts[1]);
                    String deletedText = text.substring(text.length() - countToBeDeleted);
                    text.delete(text.length() - countToBeDeleted, text.length());
                    operations.push(new String[]{"2", deletedText});
                }

                case "3" -> {
                    int index = Integer.parseInt(commandParts[1]) - 1;
                    System.out.println(text.charAt(index));
                }

                case "4" -> {
                    if (!operations.isEmpty()) {
                        String[] lastOperation = operations.pop();
                        if (lastOperation[0].equals("1")) {
                            int lengthToDelete = lastOperation[1].length();
                            text.delete(text.length() - lengthToDelete, text.length());
                        }
                        else if (lastOperation[0].equals("2")) {
                            text.append(lastOperation[1]);
                        }
                    }
                }
            }
        }
    }
}