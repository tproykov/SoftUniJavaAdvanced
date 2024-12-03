package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L01BrowserHistory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String input = scanner.nextLine();

        String current = "";

        while (!input.equals("Home")) {

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
            else {
                if (!current.isEmpty()) {
                    history.push(current);
                }
                current = input;
            }
            System.out.println(current);

            input = scanner.nextLine();
        }
    }
}