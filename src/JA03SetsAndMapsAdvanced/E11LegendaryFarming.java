package JA03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E11LegendaryFarming {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Map<String, Integer> keyMaterials = new LinkedHashMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        String winningMaterial = "";
        String legendaryItem = "";
        boolean legendaryItemObtained = false;

        while (true) {

            for (int i = 1; i < input.length; i += 2) {

                String material = input[i].toLowerCase();
                int quantity = Integer.parseInt(input[i - 1]);

                if (!keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, quantity);
                } else {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                }

                int totalQuantity = keyMaterials.get(material);
                if (totalQuantity >= 250 && (material.equals("shards")
                        || material.equals("fragments")
                        || material.equals("motes"))) {
                    legendaryItemObtained = true;
                    winningMaterial = material;
                    keyMaterials.put(winningMaterial, keyMaterials.get(winningMaterial) - 250);
                    break;
                }
            }

            if (legendaryItemObtained) {
                switch (winningMaterial) {
                    case "shards" -> legendaryItem = "Shadowmourne";
                    case "fragments" -> legendaryItem = "Valanyr";
                    case "motes" -> legendaryItem = "Dragonwrath";
                }
                System.out.println(legendaryItem + " obtained!");

                System.out.println("shards: " + keyMaterials.get("shards"));
                System.out.println("fragments: " + keyMaterials.get("fragments"));
                System.out.println("motes: " + keyMaterials.get("motes"));

                for (String currentMaterial : keyMaterials.keySet()) {
                    if (!currentMaterial.equals("shards") && !currentMaterial.equals("fragments")
                            && !currentMaterial.equals("motes")) {
                        System.out.println(currentMaterial + ": "
                                + keyMaterials.get(currentMaterial));
                    }
                }
                return;
            }
            input = scanner.nextLine().split("\\s+");
        }
    }
}
