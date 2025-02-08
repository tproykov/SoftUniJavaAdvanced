package JA11ExamPreparation.E20_23_Oct_2021;

import java.util.*;

public class E01AutumnCocktails {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::offer);

        Deque<Integer> freshnessLevels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshnessLevels::push);

        Map<String, Integer> cocktailsProduced = new HashMap<>();
        cocktailsProduced.put("Pear Sour", 0);
        cocktailsProduced.put("The Harvest", 0);
        cocktailsProduced.put("Apple Hinny", 0);
        cocktailsProduced.put("High Fashion", 0);

        Map<String, Integer> cocktailTable = new HashMap<>();
        cocktailTable.put("Pear Sour", 150);
        cocktailTable.put("The Harvest", 250);
        cocktailTable.put("Apple Hinny", 300);
        cocktailTable.put("High Fashion", 400);

        boolean fourCocktailsDone = true;
        while (!freshnessLevels.isEmpty() && !ingredients.isEmpty()) {

            int currentIngredient = ingredients.poll();
            if (currentIngredient == 0) {
                continue;
            }
            int currentFreshnessLevel = freshnessLevels.pop();
            int totalFreshnessLevels = currentFreshnessLevel * currentIngredient;

            for (Map.Entry<String, Integer> entry : cocktailTable.entrySet()) {

                if (entry.getValue() == totalFreshnessLevels) {

                    String cocktailProduced = entry.getKey();
                    cocktailsProduced.put(cocktailProduced, cocktailsProduced.get(cocktailProduced) + 1);
                }
                else {
                    currentIngredient += 5;
                    ingredients.offer(currentIngredient);
                }
            }

            for (Map.Entry<String, Integer> entry : cocktailsProduced.entrySet()) {
                if (entry.getValue() == 0) {
                    fourCocktailsDone = false;
                }
            }

            if (fourCocktailsDone) {
                break;
            }
        }
    }
}