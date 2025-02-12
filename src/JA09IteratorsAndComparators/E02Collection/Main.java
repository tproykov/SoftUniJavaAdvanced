package JA09IteratorsAndComparators.E02Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListyIterator<String> listyIterator = null;

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            try {
                switch (command) {
                    case "Create":
                        String[] elements = Arrays.copyOfRange(tokens, 1, tokens.length);
                        listyIterator = new ListyIterator<>(elements);
                        break;
                    case "Move":
                        System.out.println(listyIterator.move());
                        break;
                    case "Print":
                        listyIterator.print();
                        break;
                    case "HasNext":
                        System.out.println(listyIterator.hasNext());
                        break;
                    case "PrintAll":
                        listyIterator.printAll();
                        break;
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }

        scanner.close();
    }
}