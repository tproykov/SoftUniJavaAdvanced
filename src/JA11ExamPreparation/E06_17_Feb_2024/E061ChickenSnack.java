package JA11ExamPreparation.E06_17_Feb_2024;

import java.util.*;
import java.util.stream.Collectors;

public class E061ChickenSnack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> amountsOfMoney = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        Queue<Integer> pricesOfFood = Arrays.stream(scanner.nextLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        int countOfFoods = 0;

        while (!amountsOfMoney.isEmpty() && !pricesOfFood.isEmpty()) {

            int lastAmountOfMoney = amountsOfMoney.peek();
            int firstPriceOfFood = pricesOfFood.peek();

            if (lastAmountOfMoney == firstPriceOfFood) {
                countOfFoods++;
                amountsOfMoney.pop();
                pricesOfFood.poll();
            }
            else if (lastAmountOfMoney > firstPriceOfFood) {
                countOfFoods++;
                int change = lastAmountOfMoney - firstPriceOfFood;
                pricesOfFood.poll();
                amountsOfMoney.pop();
                int nextAmountOfMoney = amountsOfMoney.pop() + change;
                amountsOfMoney.push(nextAmountOfMoney);
            }
            else {
                amountsOfMoney.pop();
                pricesOfFood.poll();
            }
        }

        if (countOfFoods >= 4) {
            System.out.println("Gluttony of the day! Henry ate " + countOfFoods + " foods.");
        }
        else if (countOfFoods > 0) {
            if (countOfFoods > 1) {
                System.out.println("Henry ate: " + countOfFoods + " foods.");
            }
            else {
                System.out.println("Henry ate: " + countOfFoods + " food.");
            }
        }
        else {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }
    }
}