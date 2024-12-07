package JA01StacksAndQueues;

import java.util.*;

public class E02BasicStackOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] instructions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = instructions[0];
        int s = instructions[1];
        int x = instructions[2];

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.push(array[i]);
        }

//        Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .forEach(stack::push);

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        }
        else if (stack.contains(x)) {
            System.out.println(true);
        }
        else {
            System.out.println(Collections.min(stack));
        }
    }
}