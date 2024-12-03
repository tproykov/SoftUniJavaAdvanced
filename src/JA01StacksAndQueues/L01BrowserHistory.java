package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L01BrowserHistory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialization
        ArrayDeque<String> history = new ArrayDeque<>();
        String current = "";

        // Input and loop
        String input = scanner.nextLine();
        while (!input.equals("Home")) {

            // Handling the back command
            if (input.equals("back")) {
                if (!history.isEmpty()) {
                    current = history.pop();
                }
                else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            }
            // Handling a new URL
            else {
                if (!current.isEmpty()) {
                    history.push(current);
                }
                current = input;
            }

            // Output and continue
            System.out.println(current);
            input = scanner.nextLine();
        }
    }
}