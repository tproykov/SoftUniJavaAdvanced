package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L01BrowserHistory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Home")) {

            if (input.equals("back")) {
                if (history.size() > 1) {
                    history.pop();
                    System.out.println(history.peek());
                }
                else {
                    System.out.println("no previous URLs");
                }
            }
            else {
                history.push(input);
                System.out.println(input);
            }
        }
    }
}