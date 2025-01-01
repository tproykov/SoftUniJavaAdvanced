package JA11ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class E021BallGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> requiredStrengths = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(Stack::new));

        Queue<Integer> neededAccuracy = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int goals = 0;

        while (!requiredStrengths.isEmpty() && !neededAccuracy.isEmpty()) {

            int lastStrength = requiredStrengths.peek();
            int firstAccuracy = neededAccuracy.peek();

            int sum = firstAccuracy + lastStrength;

            if (sum == 100) {
                goals++;
                requiredStrengths.pop();
                neededAccuracy.poll();
            } else if (sum < 100) {

                if (lastStrength < firstAccuracy) {
                    requiredStrengths.pop();
                } else if (lastStrength > firstAccuracy) {
                    neededAccuracy.poll();
                } else {
                    requiredStrengths.pop();
                    neededAccuracy.poll();
                    requiredStrengths.push(sum);
                }
            } else {
                requiredStrengths.pop();
                lastStrength -= 10;
                requiredStrengths.push(lastStrength);
                neededAccuracy.poll();
                neededAccuracy.offer(firstAccuracy);
            }
        }

        if (goals == 3) {
            System.out.println("Paul scored a hat-trick!");
        } else if (goals == 0) {
            System.out.println("Paul failed to score a single goal.");
        } else if (goals > 3) {
            System.out.println("Paul performed remarkably well!");
        } else {
            System.out.println("Paul failed to make a hat-trick.");
        }

        if (goals > 0) {
            System.out.println("Goals scored: " + goals);
        }

        if (!requiredStrengths.isEmpty()) {

            System.out.print("Strength values left: ");
            System.out.println(requiredStrengths.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        if (!neededAccuracy.isEmpty()) {
            System.out.print("Accuracy values left: ");
            System.out.println(neededAccuracy.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }


    }

}
