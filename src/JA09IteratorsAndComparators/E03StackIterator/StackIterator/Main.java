

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomStack<Integer> stack = new CustomStack<>();
        boolean printedNoElements = false;

        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            if (line.startsWith("Push")) {
                String[] elements = line.substring(5).trim().split(",\\s+");
                for (String element : elements) {
                    stack.push(Integer.parseInt(element.trim()));
                }
            } else if (line.equals("Pop")) {
                if (stack.isEmpty()) {
                    System.out.println("No elements");
                    printedNoElements = true;
                } else {
                    stack.pop();
                }
            }
        }

        if (!printedNoElements && stack.isEmpty()) {
            System.out.println("No elements");
        } else if (!stack.isEmpty()) {
            for (int i = 0; i < 2; i++) {
                for (Integer element : stack) {
                    System.out.println(element);
                }
            }
        }
    }
}