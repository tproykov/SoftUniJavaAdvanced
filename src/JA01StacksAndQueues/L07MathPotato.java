package JA01StacksAndQueues;

import java.util.*;

public class L07MathPotato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> queue = new PriorityQueue<>();
        Arrays.stream(players).forEach(queue::offer);

        int cycle = 1;

        while (queue.size() > 1) {
            // Rotate the queue n-1 times
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            // If cycle is prime, just print the child's name
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                // If cycle is composite, remove the child
                System.out.println("Removed " + queue.poll());
            }

            cycle++;
        }

        // Print last child
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {  // Math.sqrt(number) massively optimises the process
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}