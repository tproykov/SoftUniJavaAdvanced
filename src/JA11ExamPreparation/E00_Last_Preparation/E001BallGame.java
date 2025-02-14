package JA11ExamPreparation.E00_Last_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

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
                currentStrength -= 10;
                strengthsStack.pop();
                strengthsStack.push(currentStrength);
                accuracyQueue.poll();
                accuracyQueue.offer(currentAccuracy);
            }
        }

        





    }
}
