package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class E03MaximumElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            String[] inputParts = scanner.nextLine().split("\\s+");
            String inputType = inputParts[0];

            switch (inputType) {
                case "1" -> stack.push(Integer.parseInt(inputParts[1]));
                case "2" -> stack.pop();
                case "3" -> System.out.println(Collections.max(stack));
            }
        }
    }
}