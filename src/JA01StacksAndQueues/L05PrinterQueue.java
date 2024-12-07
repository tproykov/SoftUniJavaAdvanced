package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L05PrinterQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String filename;
        while (!(filename = scanner.nextLine()).equals("print")) {

            if (filename.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.poll());
                }
            } else {
                queue.offer(filename);
            }
        }

        for (String output : queue) {
            System.out.println(output);
        }
    }
}