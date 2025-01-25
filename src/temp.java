import java.util.*;
import java.util.stream.Collectors;

public class temp {

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
        table.put(40, "Bandage");
        table.put(100, "MedKit");

        Map<String, Integer> items = new HashMap<>();

        while (!medicines.isEmpty() && !textiles.isEmpty()) {

            int currentTextile = textiles.peekFirst();
            int currentMedicine = medicines.peekLast();

            int healingItem = currentTextile + currentMedicine;

            if (table.containsKey(healingItem)) {
                items.putIfAbsent(table.get(healingItem), 0);
                items.put(table.get(healingItem), items.get(table.get(healingItem)) + 1);

                textiles.pollFirst();
                medicines.pollLast();
            } else {
                if (healingItem > 100) {
                    items.putIfAbsent("MedKit", 0);
                    items.put("MedKit", items.get("MedKit") + 1);

                    int remainder = healingItem - 100;
                    medicines.pollLast();
                    textiles.pollFirst();

                    // Keep the original logic: If empty, add the remainder as a new medicament
                    if (!medicines.isEmpty()) {
                        medicines.offerLast(medicines.pollLast() + remainder);
                    } else {
                        medicines.offerLast(remainder);
                    }
                } else {
                    textiles.pollFirst();
                    // "Can't create anything" -> remove only textile, add 10 to the medicament
                    medicines.offerLast(medicines.pollLast() + 10);
                }
            }
        }

        // Print which collection is empty
        if (textiles.isEmpty() && medicines.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        // Sort and print created items
        List<Map.Entry<String, Integer>> orderedItems = new ArrayList<>(items.entrySet());
        orderedItems.sort(
                Comparator
                        .comparing(Map.Entry<String, Integer>::getValue).reversed()
                        .thenComparing(Map.Entry<String, Integer>::getKey)
        );

        for (Map.Entry<String, Integer> item : orderedItems) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        // Print leftover textiles if any
        if (!textiles.isEmpty()) {
            System.out.println(
                    "Textiles left: " +
                            String.join(", ", textiles.toString()
                                    .replace("[", "")
                                    .replace("]", "")
                                    .trim())
            );
        }

        // Print leftover medicaments if any, reversing them like your second code
        if (!medicines.isEmpty()) {
            // Push all medicaments onto a stack to reverse the order
            Stack<Integer> reverseStack = new Stack<>();
            for (Integer medicament : medicines) {
                reverseStack.push(medicament);
            }

            // Pop from the stack into a list of strings
            List<String> reversedOutput = new ArrayList<>();
            while (!reverseStack.isEmpty()) {
                reversedOutput.add(String.valueOf(reverseStack.pop()));
            }

            System.out.println("Medicaments left: " + String.join(", ", reversedOutput));
        }
    }
}