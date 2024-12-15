package JA01StacksAndQueues;

import java.util.ArrayList;
import java.util.Scanner;

public class E09PoisonousPlants {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] pesticides = new int[N];
        for (int i = 0; i < N; i++) {
            pesticides[i] = scanner.nextInt();
        }

        System.out.println(countDaysUntilStable(pesticides));

        scanner.close();
    }

    public static int countDaysUntilStable(int[] pesticides) {
        if (pesticides == null || pesticides.length <= 1) {
            return 0;
        }

        int[] current = pesticides.clone();
        int days = 0;

        while (true) {
            ArrayList<Integer> survivors = new ArrayList<>();
            survivors.add(current[0]);
            boolean anyDied = false;

            for (int i = 1; i < current.length; i++) {
                if (current[i] <= current[i - 1]) {
                    survivors.add(current[i]);
                } else {
                    // This plant dies today
                    anyDied = true;
                }
            }

            if (!anyDied) {
                return days;
            }

            days++;

            current = new int[survivors.size()];
            for (int i = 0; i < survivors.size(); i++) {
                current[i] = survivors.get(i);
            }
        }
    }
}