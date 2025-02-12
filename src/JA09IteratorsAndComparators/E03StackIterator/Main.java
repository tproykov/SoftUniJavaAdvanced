package JA09IteratorsAndComparators.E03StackIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CustomStack<Integer> stack = new CustomStack<>();

        String command;
        while (!"END".equals(command = scanner.nextLine())) {

            switch (command) {
                case "Push" -> {
                    String[] elements = scanner.nextLine().trim().split(", ");
                    for (String element : elements) {
                        stack.push(Integer.parseInt(element));
                    }
                }
                case "Pop" -> {
                    try {
                        stack.pop();
                    } catch (IllegalStateException e) {
                        System.out.println("No elements");
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (Integer element : stack) {
                System.out.println(element);
            }
        }
    }
}