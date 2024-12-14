package JA03SetsAndMapsAdvanced;

import java.util.*;

public class L03NumberGame {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerHand = new LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(firstPlayerHand::add);

        Set<Integer> secondPlayerHand = new LinkedHashSet<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(secondPlayerHand::add);

        int round = 0;
        while (round <= 50 && !firstPlayerHand.isEmpty() && !secondPlayerHand.isEmpty()) {

            round++;

            int firstPlayerCard = firstPlayerHand.iterator().next();
            firstPlayerHand.remove(firstPlayerCard);

            int secondPlayerCard = secondPlayerHand.iterator().next();
            secondPlayerHand.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerHand.add(firstPlayerCard);
                firstPlayerHand.add(secondPlayerCard);
            }
            else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerHand.add(firstPlayerCard);
                secondPlayerHand.add(secondPlayerCard);
            }
        }

        if (firstPlayerHand.size() > secondPlayerHand.size()) {
            System.out.println("First player win!");
        }
        else if (secondPlayerHand.size() > firstPlayerHand.size()) {
            System.out.println("Second player win!");
        }
        else {
            System.out.println("Draw!");
        }
    }
}
