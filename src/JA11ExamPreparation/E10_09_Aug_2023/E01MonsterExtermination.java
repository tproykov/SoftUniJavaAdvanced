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
                int remainingStrikingImpact = lastStrikingImpacts - firstMonsterArmour;
                monstersArmour.pollFirst();
                strikingImpacts.pollLast();
                if (remainingStrikingImpact > 0) {
                    if (!strikingImpacts.isEmpty()) {
                        remainingStrikingImpact += strikingImpacts.pollLast();

                    }
                    strikingImpacts.offerLast(remainingStrikingImpact);
                }
            }
            else {
                int remainingMonsterArmour = firstMonsterArmour - lastStrikingImpacts;
                monstersArmour.pollFirst();
                strikingImpacts.pollLast();
                monstersArmour.offerLast(remainingMonsterArmour);
            }
        }

        if (monstersArmour.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        else {
            System.out.println("The soldier has been defeated.");
        }

        System.out.println("Total monsters killed: " + totalMonstersKilled);
    }
}