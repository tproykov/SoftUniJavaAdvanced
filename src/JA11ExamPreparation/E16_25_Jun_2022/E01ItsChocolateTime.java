package JA11ExamPreparation.E16_25_Jun_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01ItsChocolateTime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQuantity = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> cacaoQuantity = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int milkChocolate = 0;
        int darkChocolate = 0;
        int bakingChocolate = 0;
        while (!milkQuantity.isEmpty() && !cacaoQuantity.isEmpty()) {

            double currentMilkQuantity = milkQuantity.pollFirst();
            double currentCacaoQuantity = cacaoQuantity.pollLast();
            double cacaoPercentage = currentCacaoQuantity / (currentMilkQuantity + currentCacaoQuantity) * 100;

            if (cacaoPercentage == 30) {
                milkChocolate++;
            }
            else if (cacaoPercentage == 50) {
                darkChocolate++;
            }
            else if (cacaoPercentage == 100) {
                bakingChocolate++;
            }
            else {
                currentMilkQuantity += 10;
                milkQuantity.offerLast(currentMilkQuantity);
            }
        }

        if (milkChocolate > 0 && darkChocolate > 0 && bakingChocolate > 0) {
            System.out.println("It's a Chocolate Time. All chocolate types are prepared.");
        }
        else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        if (bakingChocolate > 0) {
            System.out.println("# Baking Chocolate --> " + bakingChocolate);
        }
        if (darkChocolate > 0) {
            System.out.println("# Dark Chocolate --> " + darkChocolate);
        }
        if (milkChocolate > 0) {
            System.out.println("# Milk Chocolate --> " + milkChocolate);
        }
    }
}