package JA11ExamPreparation.E03_12_Aug_2024;

import java.util.*;
import java.util.stream.Collectors;

public class E031WildSurvival {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> beeGroups = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        Stack<Integer> beeEaterGroups = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        while (!beeGroups.isEmpty() && !beeEaterGroups.isEmpty()) {
            int firstBeeGroup = beeGroups.peek();
            int lastBeeEaterGroup = beeEaterGroups.peek();

            int beesKilled = lastBeeEaterGroup * 7;

            if (beesKilled >= firstBeeGroup) {
                beeGroups.poll();
                if (beesKilled > firstBeeGroup) {
                    beeEaterGroups.pop();
                    int beeEatersSurvived = lastBeeEaterGroup - firstBeeGroup / 7;
                    beeEaterGroups.push(beeEatersSurvived);
                }
                else {
                    beeEaterGroups.pop();
                }
            }
            else {
                int remainingBees = firstBeeGroup - beesKilled;
                beeGroups.poll();
                beeGroups.offer(remainingBees);
                beeEaterGroups.pop();
            }
        }

        System.out.println("The final battle is over!");

        if (beeGroups.isEmpty() && beeEaterGroups.isEmpty()) {
            System.out.println("But no one made it out alive!");
        } else if (!beeGroups.isEmpty()) {
            System.out.print("Bee groups left: ");
            System.out.println(beeGroups.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        else {
            System.out.print("Bee-eater groups left: ");
            System.out.println(beeEaterGroups.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}
