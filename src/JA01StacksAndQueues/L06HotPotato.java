package JA01StacksAndQueues;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L06HotPotato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] players = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String player : players) {
            queue.offer(player);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                String currentPlayer = queue.poll();
                queue.offer(currentPlayer);
            }

            String removedPlayer = queue.poll();
            System.out.println("Removed " + removedPlayer);
        }
        System.out.println("Last is " + queue.poll());
    }
}