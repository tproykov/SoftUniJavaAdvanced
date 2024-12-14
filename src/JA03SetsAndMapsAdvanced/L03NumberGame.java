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
            int secondPlayerCard = secondPlayerHand.iterator().next();

            firstPlayerHand.remove(firstPlayerCard);
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

        if (firstPlayerHand.isEmpty()) {
            System.out.println("First player wins!");
        }
        else if (secondPlayerHand.isEmpty()) {
            System.out.println("Second player wins!");
        }
        else {
            System.out.println("Draw!");
        }
    }
}
