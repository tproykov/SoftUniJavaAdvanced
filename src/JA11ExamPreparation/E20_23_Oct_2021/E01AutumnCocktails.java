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

        Map<String, Integer> cocktailsProduced = mapProducedCocktails();

        Map<String, Integer> cocktailTable = populateCocktailTable();

        mixCocktails(freshnessLevels, ingredients, cocktailTable, cocktailsProduced);

        boolean fourCocktailsDone = true;
        for (Map.Entry<String, Integer> entry : cocktailsProduced.entrySet()) {
            if (entry.getValue() == 0) {
                fourCocktailsDone = false;
            }
        }

        printResults(fourCocktailsDone, ingredients, cocktailsProduced);
    }

    private static void printResults(boolean fourCocktailsDone, Deque<Integer> ingredients,
                                     Map<String, Integer> cocktailsProduced) {
        if (fourCocktailsDone) {
            System.out.println("It's party time! The cocktails are ready!");
        }
        else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            System.out.print("Ingredients left: ");
            int sum = 0;
            for (Integer ingredient : ingredients) {
                sum += ingredient;
            }
            System.out.println(sum);
        }

        for (Map.Entry<String, Integer> entry : cocktailsProduced.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(" # " + entry.getKey() + " --> " + entry.getValue());
            }
        }
    }

    private static void mixCocktails(Deque<Integer> freshnessLevels, Deque<Integer> ingredients,
                                     Map<String, Integer> cocktailTable, Map<String, Integer> cocktailsProduced) {
        while (!freshnessLevels.isEmpty() && !ingredients.isEmpty()) {

            int currentIngredient = ingredients.poll();
            if (currentIngredient == 0) {
                continue;
            }
            int currentFreshnessLevel = freshnessLevels.pop();
            int totalFreshnessLevels = currentFreshnessLevel * currentIngredient;

            boolean cocktailMixed = false;
            for (Map.Entry<String, Integer> entry : cocktailTable.entrySet()) {

                if (entry.getValue() == totalFreshnessLevels) {
                    cocktailMixed = true;
                    String cocktailProduced = entry.getKey();
                    cocktailsProduced.put(cocktailProduced, cocktailsProduced.get(cocktailProduced) + 1);
                }
            }

            if (!cocktailMixed) {
                currentIngredient += 5;
                ingredients.offer(currentIngredient);
            }
        }
    }

    private static Map<String, Integer> mapProducedCocktails() {
        Map<String, Integer> cocktailsProduced = new TreeMap<>();
        cocktailsProduced.put("Pear Sour", 0);
        cocktailsProduced.put("The Harvest", 0);
        cocktailsProduced.put("Apple Hinny", 0);
        cocktailsProduced.put("High Fashion", 0);
        return cocktailsProduced;
    }

    private static Map<String, Integer> populateCocktailTable() {
        Map<String, Integer> cocktailTable = new HashMap<>();
        cocktailTable.put("Pear Sour", 150);
        cocktailTable.put("The Harvest", 250);
        cocktailTable.put("Apple Hinny", 300);
        cocktailTable.put("High Fashion", 400);
        return cocktailTable;
    }
}