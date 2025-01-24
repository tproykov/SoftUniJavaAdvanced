package JA11ExamPreparation.E10_09_Aug_2023;

import java.util.*;
import java.util.stream.Collectors;

public class E01MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> monstersArmour = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        Stack<Integer> strikingImpacts = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(Stack::new));

        int totalMonstersKilled = 0;
        while (!monstersArmour.isEmpty() && !strikingImpacts.isEmpty()) {
            int firstMonsterArmour = monstersArmour.poll();
            int lastStrikingImpacts = strikingImpacts.pop();

            if (lastStrikingImpacts >= firstMonsterArmour) {
                totalMonstersKilled++;
                int remainingStrikingImpact = lastStrikingImpacts - firstMonsterArmour;
                if (remainingStrikingImpact > 0) {
                    if (!strikingImpacts.isEmpty()) {
                        int nextStrike = strikingImpacts.pop();
                        strikingImpacts.push(remainingStrikingImpact + nextStrike);
                    } else {
                        strikingImpacts.push(remainingStrikingImpact);
                    }
                }
            } else {
                int remainingMonsterArmour = firstMonsterArmour - lastStrikingImpacts;
                if (remainingMonsterArmour > 0) {
                    monstersArmour.offer(remainingMonsterArmour);
                }
            }
        }

        if (monstersArmour.isEmpty()) {
            System.out.println("All monsters have been killed!");
        } else {
            System.out.println("The soldier has been defeated.");
        }

        System.out.println("Total monsters killed: " + totalMonstersKilled);
    }
}