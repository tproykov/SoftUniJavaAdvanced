package JA01StacksAndQueues;

import java.util.ArrayList;
import java.util.Scanner;

public class E09PoisonousPlants {

    public static int countDaysUntilStable(int[] pesticides) {
        // Handle edge cases
        if (pesticides == null || pesticides.length <= 1) {
            return 0;
        }

        // Create array to store current state
        int[] current = pesticides.clone();
        int days = 0;
        int prevSize = current.length;

        while (true) {
            // Create list for survivors
            ArrayList<Integer> survivors = new ArrayList<>();
            survivors.add(current[0]);  // First plant always survives

            // Check each plant against its left neighbor
            for (int i = 1; i < current.length; i++) {
                if (current[i] <= current[i-1]) {
                    survivors.add(current[i]);
                }
            }

            // If no changes occurred or only one plant remains
            if (survivors.size() == prevSize || survivors.size() <= 1) {
                return days;
            }

            // Update for next day
            days++;
            prevSize = survivors.size();
            current = new int[survivors.size()];
            for (int i = 0; i < survivors.size(); i++) {
                current[i] = survivors.get(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of plants
        int N = scanner.nextInt();

        // Read pesticide values
        int[] pesticides = new int[N];
        for (int i = 0; i < N; i++) {
            pesticides[i] = scanner.nextInt();
        }

        // Calculate and print result
        System.out.println(countDaysUntilStable(pesticides));

        scanner.close();
    }
}
