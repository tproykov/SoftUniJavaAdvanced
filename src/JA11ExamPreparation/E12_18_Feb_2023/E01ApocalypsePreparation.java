package JA11ExamPreparation.E12_18_Feb_2023;

import java.util.*;
import java.util.stream.Collectors;

public class E01ApocalypsePreparation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textiles = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> medicines = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<Integer, String> table = new HashMap<>();
        table.put(30, "Patch");
        table.put(40, "Bandages");
        table.put(100, "MedKit");

        Map<String, Integer> items = new HashMap<>();

        while (!medicines.isEmpty() && !textiles.isEmpty()) {

            int currentTextile = textiles.peekFirst();
            int currentMedicine = medicines.peekLast();

            int healingItem = currentTextile + currentMedicine;

            if (table.containsKey(healingItem)) {
                if (!items.containsKey(table.get(healingItem))) {
                    items.put(table.get(healingItem), 0);
                }
                items.put(table.get(healingItem), items.get(table.get(healingItem)) + 1);
                textiles.pollFirst();
                medicines.pollLast();
            } else {
                if (healingItem > 100) {
                    if (!items.containsKey("MedKit")) {
                        items.put("MedKit", 0);
                    }
                    items.put("MedKit", items.get("MedKit") + 1);

                    int remainder = healingItem - 100;

                    medicines.pollLast();
                    textiles.pollFirst();

                    if (!medicines.isEmpty()) {
                        medicines.offerLast(medicines.pollLast() + remainder);
                    } else {
                        medicines.offerLast(remainder);
                    }
                } else {
                    textiles.pollFirst();
                    medicines.pollLast();

                    if (!medicines.isEmpty()) {
                        medicines.offerLast(medicines.pollLast() + 10);
                    }
                    else {
                        medicines.offerLast(10);
                    }
                }


            }


        }

        if (textiles.isEmpty() && medicines.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }


    }
}