package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class L04MatchingBrackets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {

            StringBuilder expression = new StringBuilder();

            char character = input.charAt(i);

            if (character == '(') {
                stack.push(i);
            }
            else if (character == ')') {
                int startIndex = stack.pop();
                int endIndex = i + 1;
                System.out.println(input.substring(startIndex, endIndex));
            }
        }
    }
}