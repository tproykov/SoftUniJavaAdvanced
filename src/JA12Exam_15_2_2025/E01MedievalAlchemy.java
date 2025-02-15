package JA12Exam_15_Feb_2025;

import java.util.*;
import java.util.stream.Collectors;

public class E01MedievalAlchemy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(substancesStack::push);

        ArrayDeque<Integer> crystalsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(crystalsQueue::offer);

        Map<Integer, String> potionsTable = new TreeMap<>(Collections.reverseOrder());
        potionsTable.put(110, "Brew of Immortality");
        potionsTable.put(100, "Essence of Resilience");
        potionsTable.put(90, "Draught of Wisdom");
        potionsTable.put(80, "Potion of Agility");
        potionsTable.put(70, "Elixir of Strength");

        List<String> craftedPotions = new ArrayList<>();
        Set<String> craftedPotionSet = new HashSet<>();

        while (!substancesStack.isEmpty() && !crystalsQueue.isEmpty() && craftedPotions.size() < 5) {

            int currentSubstance = substancesStack.pop();
            int currentCrystal = crystalsQueue.poll();
            int sum = currentSubstance + currentCrystal;

            boolean potionCrafted = false;
            if (potionsTable.containsKey(sum) && !craftedPotionSet.contains(potionsTable.get(sum))) {

                String potionCraftedName = potionsTable.get(sum);
                craftedPotions.add(potionCraftedName);
                craftedPotionSet.add(potionCraftedName);
                potionCrafted = true;
            } else {
                for (Map.Entry<Integer, String> entry : potionsTable.entrySet()) {

                    if (entry.getKey() < sum && !craftedPotionSet.contains(entry.getValue())) {
                        potionCrafted = true;
                        String potionCraftedName = entry.getValue();
                        craftedPotions.add(potionCraftedName);
                        craftedPotionSet.add(potionCraftedName);
                        currentCrystal -= 20;
                        break;
                    }
                }
                if (!potionCrafted) {
                    currentCrystal -= 5;
                }
                if (currentCrystal > 0) {
                    crystalsQueue.offer(currentCrystal);
                }
            }
        }

        if (craftedPotions.size() == 5) {
            System.out.println("Success! The alchemist has forged all potions!");
        } else {
            System.out.println("The alchemist failed to complete his quest.");
        }

        if (!craftedPotions.isEmpty()) {
            System.out.println("Crafted potions: " + String.join(", ", craftedPotions));
        }

        if (!substancesStack.isEmpty()) {
            System.out.println("Substances: " +
                    substancesStack.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ")));
        }

        if (!crystalsQueue.isEmpty()) {
            System.out.println("Crystals: " +
                    crystalsQueue.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ")));
        }
    }
}
