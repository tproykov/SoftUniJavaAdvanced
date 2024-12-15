package JA03SetsAndMapsAdvanced;

import java.util.*;

public class E11LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>(); // Using TreeMap for automatic alphabetical sorting

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        String winningMaterial = "";
        String legendaryItem = "";
        boolean legendaryItemObtained = false;

        while (!legendaryItemObtained) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int i = 1; i < input.length; i += 2) {
                String material = input[i].toLowerCase();
                int quantity = Integer.parseInt(input[i - 1]);

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);

                    if (keyMaterials.get(material) >= 250) {
                        legendaryItemObtained = true;
                        winningMaterial = material;
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        break;
                    }
                } else {
                    junkMaterials.put(material, junkMaterials.getOrDefault(material, 0) + quantity);
                }
            }
        }

        switch (winningMaterial) {
            case "shards" -> legendaryItem = "Shadowmourne";
            case "fragments" -> legendaryItem = "Valanyr";
            case "motes" -> legendaryItem = "Dragonwrath";
        }
        System.out.println(legendaryItem + " obtained!");

        keyMaterials.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        junkMaterials.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}