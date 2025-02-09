package JA11ExamPreparation.E21_18_Aug_2021;

import java.util.*;

public class E01PastryShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquids::offer);

        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer> foodsCooked = new TreeMap<>();
        foodsCooked.put("Biscuit", 0);
        foodsCooked.put("Cake", 0);
        foodsCooked.put("Pastry", 0);
        foodsCooked.put("Pie", 0);

        Map<String, Integer> foodTable = new HashMap<>();
        foodTable.put("Biscuit", 25);
        foodTable.put("Cake", 50);
        foodTable.put("Pastry", 75);
        foodTable.put("Pie", 100);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int currentLiquid = liquids.poll();
            int currentIngredient = ingredients.pop();
            int mix = currentLiquid + currentIngredient;

            boolean cooked = false;
            for (Map.Entry<String, Integer> entry : foodTable.entrySet()) {
                if (entry.getValue() == mix) {
                    cooked = true;
                    String foodCooked = entry.getKey();
                    foodsCooked.put(foodCooked, foodsCooked.get(foodCooked) + 1);
                }
            }
            if (!cooked) {
                currentIngredient += 3;
                ingredients.push(currentIngredient);
            }
        }



    }
}
