package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class L07MathPotato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 1; i < players.length; i++) {
            queue.offer(players[i]);



        }

        int n = Integer.parseInt(scanner.nextLine());
        int rotations = 0;

        while (queue.size() > 1) {

            String firstKid = queue.poll();

            rotations++;

            if (rotations % n == 0) {
                System.out.println("Removed " + firstKid);
            } else {
                queue.offer(firstKid);
            }
        }

        System.out.println("Last is " + queue.poll());
    }
}