package JA09IteratorsAndComparators.E02Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListyIterator<String> listyIterator = null;

        String command;
        while (!"END".equals(command =scanner.nextLine())) {
            String[] tokens = command.split("\\s+");
            String commandType = tokens[0];

            try {
                switch (commandType) {
                    case "Create" -> {
                        String[] elements = Arrays.copyOfRange(tokens, 1, tokens.length);
                        listyIterator = new ListyIterator<>(elements);
                    }
                    case "Move" -> System.out.println(listyIterator.move());
                    case "Print" -> listyIterator.print();
                    case "HasNext" -> System.out.println(listyIterator.hasNext());
                    case "PrintAll" -> listyIterator.printAll();
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}