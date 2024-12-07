package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E01ReverseNumbersStacks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(numbers).forEach(stack::push);

        for (Integer number : stack) {
            System.out.print(number + " ");
        }
    }
}