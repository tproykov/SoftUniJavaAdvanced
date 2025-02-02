package JA11ExamPreparation.E17_13_Apr_2022;

import java.util.*;
import java.util.stream.Collectors;

public class E01Blacksmith {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steel = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carbon = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);

        while (!steel.isEmpty() && !carbon.isEmpty()) {

            int currentSteel = steel.pollFirst();
            int currentCarbon = carbon.pollLast();

            int mix = currentSteel + currentCarbon;

            switch (mix) {
                case 70 -> {
                    swords.putIfAbsent("Gladius", swords.get("Gladius") + 1);
                }
                case 80 -> {
                    swords.putIfAbsent("Shamshir", swords.get("Shamshir") + 1);
                }
                case 90 -> {
                    swords.putIfAbsent("Katana", swords.get("Katana") + 1);
                }
                case 110 -> {
                    swords.putIfAbsent("Sabre", swords.get("Sabre") + 1);
                }
                default -> {
                    currentCarbon += 5;
                    carbon.offerLast(currentCarbon);
                }
            }
        }

        int swordsCount = 0;
        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
            swordsCount += entry.getValue();
        }

        if (swordsCount > 0) {
            System.out.println("You have forged " + swordsCount + " swords");
        } else {
            System.out.println("You did not have enough resources to forge a sword");
        }

        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            System.out.println(steel.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            System.out.println(carbon.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.print(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}