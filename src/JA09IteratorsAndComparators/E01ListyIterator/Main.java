package JA09IteratorsAndComparators.E01ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ListyIterator<String> listyIterator;

        String input;
        while (!("END".equals(input = scanner.nextLine()))) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {

                case "Create" -> {
                    String[] elements = Arrays.stream(tokens).skip(1).toArray(String[]::new);
                    listyIterator = new ListyIterator(elements);
                }

                case "HasNext"  -> {}

                case "Print" -> {}

                case "Move" -> {}

            }



        }
    }

}
