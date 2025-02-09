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

        Map<String, Integer> foodTable = defineFoodTable();

        Map<String, Integer> foodsCooked = trackCookedFoods();

        cookFoods(liquids, ingredients, foodTable, foodsCooked);

        boolean allFoodsCooked = checkIfAllCooked(foodsCooked);

        printResults(allFoodsCooked, liquids, ingredients, foodsCooked);
    }

    private static boolean checkIfAllCooked(Map<String, Integer> foodsCooked) {
        boolean allFoodsCooked = true;
        for (Map.Entry<String, Integer> entry : foodsCooked.entrySet()) {
            if (entry.getValue() == 0) {
                allFoodsCooked = false;
                break;
            }
        }
        return allFoodsCooked;
    }

    private static void cookFoods(Deque<Integer> liquids, Deque<Integer> ingredients, Map<String, Integer> foodTable, Map<String, Integer> foodsCooked) {
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

    private static Map<String, Integer> trackCookedFoods() {
        Map<String, Integer> foodsCooked = new LinkedHashMap<>();
        foodsCooked.put("Biscuit", 0);
        foodsCooked.put("Cake", 0);
        foodsCooked.put("Pie", 0);
        foodsCooked.put("Pastry", 0);
        return foodsCooked;
    }

    private static Map<String, Integer> defineFoodTable() {
        Map<String, Integer> foodTable = new HashMap<>();
        foodTable.put("Biscuit", 25);
        foodTable.put("Cake", 50);
        foodTable.put("Pastry", 75);
        foodTable.put("Pie", 100);
        return foodTable;
    }

    private static void printResults(boolean allFoodsCooked, Deque<Integer> liquids, Deque<Integer> ingredients,
                                     Map<String, Integer> foodsCooked) {
        if (allFoodsCooked) {
            System.out.println("Great! You succeeded in cooking all the food!");
        }
        else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.println("none");
        }
        else {
            System.out.println(liquids.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.println("none");
        }
        else {
            System.out.println(ingredients.toString().replaceAll("[\\[\\]]", ""));
        }

        for (Map.Entry<String, Integer> entry : foodsCooked.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}