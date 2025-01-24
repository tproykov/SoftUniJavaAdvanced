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
            int firstMonsterArmour = monstersArmour.peek();
            int lastStrikingImpacts = strikingImpacts.peek();

            if (lastStrikingImpacts >= firstMonsterArmour) {
                totalMonstersKilled++;
                int remainingStrikingImpact = lastStrikingImpacts - firstMonsterArmour;

                if (remainingStrikingImpact > 0) {
                    monstersArmour.poll();
                    if (strikingImpacts.size() == 1) {
                        strikingImpacts.pop();
                        strikingImpacts.push(remainingStrikingImpact);
                    }
                    else {
                        strikingImpacts.pop();
                        int tempStrikingImpact = remainingStrikingImpact;
                        int previousStrike = strikingImpacts.pop();
                        strikingImpacts.push(previousStrike + tempStrikingImpact);
                    }
                }
                else {
                    strikingImpacts.pop();
                    monstersArmour.poll();
                }
            } else {
                int remainingMonsterArmour = firstMonsterArmour - lastStrikingImpacts;
                strikingImpacts.pop();
                monstersArmour.poll();
                monstersArmour.offer(remainingMonsterArmour);
            }
        }

        if (monstersArmour.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }

        if (strikingImpacts.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.println("Total monsters killed: " + totalMonstersKilled);
    }
}