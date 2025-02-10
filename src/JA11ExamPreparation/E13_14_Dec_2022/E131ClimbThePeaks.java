package JA11ExamPreparation.E13_14_Dec_2022;

import java.util.*;
import java.util.stream.Collectors;

public class E131ClimbThePeaks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> food = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stamina = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> peaks = fillPeaksTable();

        List<String> conqueredPeaks = new ArrayList<>();

        for (int day = 1; day <= 7; day++) {
            if (peaks.isEmpty()) {
                break;
            }

            int dailyFood = food.peekLast();
            int dailyStamina = stamina.peekFirst();
            int sum = dailyFood + dailyStamina;

            int difficulty = peaks.entrySet().stream().findFirst().get().getValue();

            if (sum >= difficulty) {
                String peak = peaks.entrySet().stream().findFirst().get().getKey();
                conqueredPeaks.add(peak);
                peaks.remove(peak);
            }

            food.pollLast();
            stamina.pollFirst();
        }

        if (peaks.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            conqueredPeaks.forEach(System.out::println);
        }
    }

    private static Map<String, Integer> fillPeaksTable() {
        Map<String, Integer> peaks = new LinkedHashMap<>();
        peaks.put("Vihren", 80);
        peaks.put("Kutelo", 90);
        peaks.put("Banski Suhodol", 100);
        peaks.put("Polezhan", 60);
        peaks.put("Kamenitza", 70);
        return peaks;
    }
}