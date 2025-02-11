package JA10AlgorithmsIntroduction;

import java.util.*;

public class L03SumOfCoins {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().substring(7).split(", ");

        int[] availableCoins = new int[elements.length];

        for (int i = 0; i < availableCoins.length; i++) {
            availableCoins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(availableCoins, targetSum);

        int returnedSum = usedCoins.entrySet().stream()
                .mapToInt(entry -> entry.getKey() * entry.getValue())
                .sum();

        if (targetSum != returnedSum) {
            System.out.println("Error");
        }
        else {
            System.out.printf("Number of coins to take: %d%n",
                    usedCoins.values().stream().mapToInt(Integer::intValue).sum());

            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
                if (usedCoin.getValue() > 0) {
                    System.out.println(usedCoin.getValue() + " coin(s) with value " + usedCoin.getKey());
                }
            }
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] availableCoins, int targetSum) {

        Arrays.sort(availableCoins);

        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();
        int coinIndex = availableCoins.length - 1;

        while (targetSum > 0 && coinIndex >= 0) {

            int currentCoin = availableCoins[coinIndex];
            int countCurrentCoins = targetSum /currentCoin;

            usedCoins.put(currentCoin, countCurrentCoins);
            targetSum -= countCurrentCoins * currentCoin;

            coinIndex--;
        }

        return usedCoins;
    }
}