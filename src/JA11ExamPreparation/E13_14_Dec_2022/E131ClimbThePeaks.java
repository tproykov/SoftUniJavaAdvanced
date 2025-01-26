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

        Map<String, Integer> table = new LinkedHashMap<>();
        table.put("Vihren", 80);
        table.put("Kutelo", 90);
        table.put("Banski Suhodol", 100);
        table.put("Polezhan", 60);
        table.put("Kamenitza", 70);

        ArrayDeque<String> peaks = new ArrayDeque<>();
        peaks.offerLast("Vihren");
        peaks.offerLast("Kutelo");
        peaks.offerLast("Banski Suhodol");
        peaks.offerLast("Polezhan");
        peaks.offerLast("Kamenitza");

        List<String> conqueredPeaks = new ArrayList<>();

        int days = 0;
        while (!food.isEmpty() && !stamina.isEmpty() && !peaks.isEmpty() && days < 7) {

            int dailyFood = food.peekLast();
            int dailyStamina = stamina.peekFirst();
            int sum = dailyFood + dailyStamina;

            String peakToClimb = peaks.peekFirst();
            int difficulty = table.get(peakToClimb);

            if (sum >= difficulty) {
                conqueredPeaks.add(peakToClimb);
                peaks.pollFirst();
            }

            food.pollLast();
            stamina.pollFirst();

            days++;
        }

        if (conqueredPeaks.size() == 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            System.out.println("Conquered peaks:");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()) {
            conqueredPeaks.forEach(System.out::println);
        }
    }
}