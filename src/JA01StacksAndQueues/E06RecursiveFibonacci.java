package JA01StacksAndQueues;

import java.util.HashMap;
import java.util.Scanner;

public class E06RecursiveFibonacci {

    // Memoization map in a separate class
    private static final HashMap<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(getFibonacci(n));
    }

    public static long getFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        // Check if the value has already been computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Recursive calculation of current Fibonacci number
        long result = getFibonacci(n - 1) + getFibonacci(n - 2);

        // Store the result in memoization map
        memo.put(n, result);

        return result;
    }
}
