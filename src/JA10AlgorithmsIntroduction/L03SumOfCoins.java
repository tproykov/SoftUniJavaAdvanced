package JA10AlgorithmsIntroduction;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class L03SumOfCoins {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().substring(7).split(", ");

        int[] coins = new int[elements.length];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);



        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " coin(s) with value " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {

        Map<Integer, Integer> usedCoins = new HashMap<>();

        for (int coin : coins) {

            if (coin == targetSum) {
                usedCoins.put(coin, 1);
            }
            else {
                int countOfCurrentCoin = targetSum / coin;
            }
            usedCoins.put(coin, usedCoins.getOrDefault(coin, 0) + 1);
        }

        return usedCoins;
    }
}