package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class L02SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        // Initialize the stack
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);   // Adds all elements from the input array into the stack.
                                            // Please note this adds them from the tail!!
        // Process the expression
        while (stack.size() > 1) {
            int firstOperand = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondOperand = Integer.parseInt(stack.pop());

            // Perform operation
            switch (operator) {
                case "+" -> stack.push(String.valueOf(firstOperand + secondOperand));
                case "-" -> stack.push(String.valueOf(firstOperand - secondOperand));
            }
        }

        // Output the result
        System.out.println(stack.pop());
    }
}