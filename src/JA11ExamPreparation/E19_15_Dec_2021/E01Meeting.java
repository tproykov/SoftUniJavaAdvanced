package JA11ExamPreparation.E19_15_Dec_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class E01Meeting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(males::push);

        Deque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(females::offer);

        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {

            int currentMale = males.peek();
            if (currentMale <= 0) {
                males.pop();
                continue;
            }
            if (currentMale % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }

            int currentFemale = females.peek();
            if (currentFemale <= 0) {
                females.poll();
                continue;
            }
            if (currentFemale % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }

            males.pop();
            females.poll();

            if (currentMale != currentFemale) {
                currentMale -= 2;
                males.push(currentMale);
            }
            else {
                matches++;
            }
        }

        System.out.println("Matches: " + matches);
        System.out.print("Males left: ");
        if (males.isEmpty()) {
            System.out.println("none");
        }
        else {
            System.out.println(males.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}