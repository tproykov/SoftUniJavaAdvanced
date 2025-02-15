package JA11ExamPreparation.E00_Last_Preparation;

import java.util.*;
import java.util.stream.Collectors;

public class E001BallGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> strengthsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(strengthsStack::push);

        ArrayDeque<Integer> accuracyQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(accuracyQueue::offer);

        int goalsCount = 0;
        while (!strengthsStack.isEmpty() && !accuracyQueue.isEmpty()) {

            int currentStrength = strengthsStack.peek();
            int currentAccuracy = accuracyQueue.peek();
            int sum = currentStrength + currentAccuracy;

            if (sum == 100) {
                goalsCount++;
                strengthsStack.pop();
                accuracyQueue.poll();
            }
            else if (sum < 100) {
                if (currentStrength < currentAccuracy) {
                    strengthsStack.pop();
                }
                else if (currentStrength > currentAccuracy) {
                    accuracyQueue.poll();
                }
                else {
                    strengthsStack.pop();
                    accuracyQueue.poll();
                    strengthsStack.push(sum);
                }
            }
            else {
                strengthsStack.pop();
                currentStrength -= 10;
                strengthsStack.push(currentStrength);
                accuracyQueue.poll();
                accuracyQueue.offer(currentAccuracy);
            }
        }

        if (goalsCount == 3) {
            System.out.println("Paul scored a hat-trick!");
        }
        else if (goalsCount == 0) {
            System.out.println("Paul failed to score a single goal.");
        }
        else if (goalsCount > 3) {
            System.out.println("Paul performed remarkably well!");
        }
        else {
            System.out.println("Paul failed to make a hat-trick.");
        }

        if (goalsCount > 0) {
            System.out.println("Goals scored: " + goalsCount);
        }

        if (!strengthsStack.isEmpty()) {
            System.out.print("Strength values left: ");
            List<String> reversedList = strengthsStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList());
            Collections.reverse(reversedList);
            System.out.println(String.join(", ", reversedList));
        }
        if (!accuracyQueue.isEmpty()) {
            System.out.print("Accuracy values left: ");
            System.out.println(String.join(", ", accuracyQueue.stream()
                    .map(String::valueOf)
                    .toList()));
        }
    }
}