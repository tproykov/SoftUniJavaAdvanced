package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E06FibonacciWithStack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Long> stack = new ArrayDeque<>();

        stack.push(0L);
        stack.push(1L);

        int n = Integer.parseInt(scanner.nextLine());

        if (n < 2){
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();

            stack.push(num1);
            stack.push(num1 + num2);
        }

        System.out.println(stack.peek());
    }
}