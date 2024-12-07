package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E07SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String[] commandParts = scanner.nextLine().split("\\s+");

            switch (commandParts[0]) {

                case "1" -> {
                    String string = commandParts[1];
                    text.append(string);
                    stack.push(text.toString());
                }

                case "2" -> {
                    int count = Integer.parseInt(commandParts[1]);
                    text.delete(text.length() - count, text.length());
                    stack.push(text.toString());
                }

                case "3" -> {
                    int index = Integer.parseInt(commandParts[1]) - 1;
                    char character = text.charAt(index);
                    System.out.println(character);
                }

                case "4" -> {
                    stack.pop();
                    String previousText = stack.peek();
                    text.setLength(0);
                    text.append(previousText);
                }
            }
        }
    }
}
