package JA11ExamPreparation.E08_21_Oct_2023;

import java.util.*;
import java.util.stream.Collectors;

public class E081OffroadChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> fuel = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        Queue<Integer> additionalConsumption = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        Queue<Integer> fuelNeeded = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        int altitudesToReach = fuel.size();
        int reachedAltitudes = 0;

        while (!fuel.isEmpty()) {

            int lastFuel = fuel.peek();
            int firstAdditionalConsumption = additionalConsumption.peek();
            int firstFuelNeeded = fuelNeeded.peek();

            int fuelAvailable = lastFuel - firstAdditionalConsumption;

            if (fuelAvailable >= firstFuelNeeded) {
                fuel.pop();
                additionalConsumption.poll();
                fuelNeeded.poll();
                System.out.println("John has reached: Altitude " + (reachedAltitudes + 1));
            }
            else {
                System.out.println("John did not reach: Altitude " + (reachedAltitudes + 1));
                break;
            }

            reachedAltitudes++;
        }

        if (reachedAltitudes == altitudesToReach) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        }
        else if (reachedAltitudes == 0) {
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        }
        else {
            System.out.println("John failed to reach the top.");
            System.out.print("Reached altitudes: ");
            for (int i = 1; i < reachedAltitudes; i++) {
                System.out.print("Altitude " + i + ", ");
            }
            System.out.println("Altitude " + reachedAltitudes);
        }
    }
}