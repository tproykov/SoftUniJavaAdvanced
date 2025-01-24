package JA11ExamPreparation.E10_09_Aug_2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01MonsterExtermination {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> monstersArmour = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> strikingImpacts = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int totalMonstersKilled = 0;
        while (!monstersArmour.isEmpty() && !strikingImpacts.isEmpty()) {

            int firstMonsterArmour = monstersArmour.peekFirst();
            int lastStrikingImpacts = strikingImpacts.peekLast();

            if (lastStrikingImpacts >= firstMonsterArmour) {
                totalMonstersKilled++;
                monstersArmour.poll();
                strikingImpacts.pop();
                int remainingStrikingImpact = lastStrikingImpacts - firstMonsterArmour;
                if (remainingStrikingImpact > 0 && !strikingImpacts.isEmpty()) {
                    int newStrikingImpact = remainingStrikingImpact + strikingImpacts.pop();
                    strikingImpacts.push(newStrikingImpact);
                }
                else if (strikingImpacts.isEmpty()) {
                    strikingImpacts.push(remainingStrikingImpact);
                }
            }
            else {
                monstersArmour.poll();
                strikingImpacts.pop();
                int remainingMonsterArmour = firstMonsterArmour - lastStrikingImpacts;
                monstersArmour.offer(remainingMonsterArmour);
            }
        }

        if (monstersArmour.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        else {
            System.out.println("The soldiers have bee defeated.");
        }

        System.out.println("Total monsters killed: " + totalMonstersKilled);
    }
}