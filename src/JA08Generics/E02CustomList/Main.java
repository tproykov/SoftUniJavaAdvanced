package JA08Generics.E02CustomList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String command;
        while (!("END".equals(command = scanner.nextLine()))) {

            String[] tokens = command.split("\\s+");
            String commandType = tokens[0];

            switch (commandType) {
                case "Add" -> {
                    String elementToAdd = tokens[1];
                    list.add(elementToAdd);
                }

                case "Remove" -> {
                    int index = Integer.parseInt(tokens[1]);
                    list.remove(index);
                }

                case "Contains" -> {
                    String elementToCheck = tokens[1];
                    System.out.println(list.contains(elementToCheck));
                }

                case "Swap" -> {
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    list.swap(index1, index2);
                }

                case "Greater" -> {
                    String elementToCompareWith = tokens[1];
                    System.out.println(list.countGreaterThan(elementToCompareWith));
                }

                case "Max" -> System.out.println(list.getMax());

                case "Min" -> System.out.println(list.getMin());

                case "Print" -> System.out.println(list);

                case "Sort" -> list.sort();
            }
        }
    }
}