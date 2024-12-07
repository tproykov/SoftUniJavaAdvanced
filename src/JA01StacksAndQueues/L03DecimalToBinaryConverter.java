package JA01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L03DecimalToBinaryConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimal == 0) {
            stack.push(0);
        }
        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        for (int item : stack) {
            System.out.print(item);
        }
    }
}