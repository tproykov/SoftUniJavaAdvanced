

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ListyIterator<String> listyIterator = null;

        String input;
        while (!("END".equals(input = scanner.nextLine()))) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {

                case "Create" -> {
                    String[] elements = Arrays.stream(tokens).skip(1).toArray(String[]::new);
                    listyIterator = new ListyIterator<>(elements);
                }

                case "Move"  -> {
                    System.out.println(listyIterator.move());
                }

                case "Print" -> {
                    try {
                        listyIterator.print();
                    }
                    catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());;
                    }
                }

                case "HasNext" -> {
                    System.out.println(listyIterator.hasNext());
                }
            }
        }
    }
}