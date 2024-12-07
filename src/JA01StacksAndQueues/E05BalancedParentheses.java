package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E05BalancedParentheses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            }
            else {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                if (character == '}' && stack.peek() == '{' ||
                        character == ']' && stack.peek() == '[' ||
                        character == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced && stack.isEmpty()) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}