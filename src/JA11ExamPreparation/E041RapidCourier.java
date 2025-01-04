package JA11ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class E041RapidCourier {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> packageWeights = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        Queue<Integer> courierCapacities = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        int totalDelivered = 0;
        while (!packageWeights.isEmpty() && !courierCapacities.isEmpty()) {

            int lastPackageWeight = packageWeights.peek();
            int firstCourierCapacity = courierCapacities.peek();

            if (firstCourierCapacity >= lastPackageWeight) {

                int newCourierCapacity = firstCourierCapacity - lastPackageWeight * 2;

                if (newCourierCapacity > 0) {
                    firstCourierCapacity = newCourierCapacity;
                    courierCapacities.offer(firstCourierCapacity);
                }
                else {
                    courierCapacities.poll();
                }

                totalDelivered += lastPackageWeight;
                packageWeights.pop();
            }
            else {
                totalDelivered += firstCourierCapacity;
                int remainingWeight = lastPackageWeight -= firstCourierCapacity;
                packageWeights.pop();
                packageWeights.push(remainingWeight);
                courierCapacities.poll();
            }
        }

        if (packageWeights.isEmpty() && courierCapacities.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        }
        else if (courierCapacities.isEmpty()) {
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            System.out.println(packageWeights
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
        else {
            System.out.print("Couriers are still on duty: ");
            System.out.print(courierCapacities
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
            System.out.println("but there are no more packages to deliver.");
        }
    }
}