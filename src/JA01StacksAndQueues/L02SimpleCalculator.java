package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class L02SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+" -> stack.push(String.valueOf(first + second));
                case "-" -> stack.push(String.valueOf(first - second));
            }
        }
        System.out.println(stack.pop());
    }
}