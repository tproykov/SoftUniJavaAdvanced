package JA01StacksAndQueues;

import java.util.*;

public class E08InfixToPostfix {

    // Method to determine the precedence of an operator
    private static int precedence(String operator) {
        return switch (operator) {
            case "^" -> 3;  // exponentiation has the highest precedence
            case "*", "/" -> 2;  // multiplication and division have medium precedence
            case "+", "-" -> 1;  // addition and subtraction have the lowest precedence
            default -> -1;  // non-operator
        };
    }

    // Method to check if the string is an operator
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")
                || token.equals("^");
    }

    // Method to check if the string is a valid operand (number or letter)
    private static boolean isOperand(String token) {
        // Check if it's a number
        try {
            Double.parseDouble(token);  // Try to parse as a number
            return true;
        } catch (NumberFormatException e) {
            // If not a number, check if it's a single letter (variable)
            return token.matches("[a-z]");  // Matches any single letter (a-z)
        }
    }

    // Method to convert infix expression (tokens) to postfix (RPN) expression
    public static String[] infixToPostfix(String[] infixTokens) {
        Stack<String> operatorStack = new Stack<>();
        List<String> output = new ArrayList<>();

        for (String token : infixTokens) {
            if (isOperand(token)) {
                // If the token is a number, add it to the output queue
                output.add(token);
            } else if (token.equals("(")) {
                // If the token is a left parenthesis, push it onto the operator stack
                operatorStack.push(token);
            } else if (token.equals(")")) {
                // If the token is a right parenthesis, pop from the operator stack until a left parenthesis is encountered
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    output.add(operatorStack.pop());
                }
                // Pop the left parenthesis but don't add it to the output queue
                operatorStack.pop();
            } else if (isOperator(token)) {
                // If the token is an operator
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                    // Pop operators from the stack with higher or equal precedence and add them to the output
                    output.add(operatorStack.pop());
                }
                // Push the current operator onto the stack
                operatorStack.push(token);
            }
        }

        // After reading all the tokens, pop all remaining operators from the stack
        while (!operatorStack.isEmpty()) {
            output.add(operatorStack.pop());
        }

        // Convert the output list to an array and return
        return output.toArray(new String[0]);
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test example: infix expression: "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"
        String[] infix = scanner.nextLine().split("\\s+");

        // Convert to postfix using the Shunting Yard algorithm
        String[] postfix = infixToPostfix(infix);

        // Print the resulting postfix expression
        System.out.println(String.join(" ", postfix));
    }
}