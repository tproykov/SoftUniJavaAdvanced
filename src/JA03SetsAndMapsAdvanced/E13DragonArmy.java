package JA03SetsAndMapsAdvanced;

import java.util.*;

public class E13DragonArmy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> dragonStats = new LinkedHashMap<>();
        Map<String, Integer> dragonTypeCount = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String dragonType = input[0];
            String dragonName = input[1];
            String dragonTypeName = dragonType + " " + dragonName;

            int damage;
            if (input[2].equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(input[2]);
            }

            int health;
            if (input[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(input[3]);
            }

            int armor;
            if (input[4].equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(input[4]);
            }

            dragonStats.put(dragonTypeName, new ArrayList<>(Arrays.asList(damage, health, armor)));
            dragonTypeCount.put(dragonType, dragonTypeCount.getOrDefault(dragonType, 0) + 1);
        }

        Map<String, List<String>> dragonTypeName = new LinkedHashMap<>();

        for (String key : dragonStats.keySet()) {
            String dragonType = key.split(" ")[0];
            dragonTypeName.putIfAbsent(dragonType, new ArrayList<>());
            dragonTypeName.get(dragonType).add(key);
        }

        for (Map.Entry<String, List<String>> entry : dragonTypeName.entrySet()) {

            String dragonType = entry.getKey();
            List<String> dragons = entry.getValue();
            Collections.sort(dragons);

            double totalDamage = 0;
            double totalHealth = 0;
            double totalArmor = 0;

            for (String dragon : dragons) {
                List<Integer> stats = dragonStats.get(dragon);
                totalDamage += stats.get(0);
                totalHealth += stats.get(1);
                totalArmor += stats.get(2);
            }

            double averageDamage = totalDamage / dragons.size();
            double averageHealth = totalHealth / dragons.size();
            double averageArmor = totalArmor / dragons.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", dragonType, averageDamage, averageHealth, averageArmor);

            for (String typeDragon : dragons) {
                String dragon = typeDragon.split(" ")[1];
                int dragonDamage = dragonStats.get(typeDragon).get(0);
                int dragonHealth = dragonStats.get(typeDragon).get(1);
                int dragonArmor = dragonStats.get(typeDragon).get(2);
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                        dragon, dragonDamage, dragonHealth, dragonArmor);
            }
        }
    }
}
