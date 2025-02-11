package JA09IteratorsAndComparators.E09LinkedListTraversal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Add" -> list.add(number);
                case "Remove" -> list.remove(number);
            }
        }

        System.out.println(list.getSize());

        for (Integer num : list) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}