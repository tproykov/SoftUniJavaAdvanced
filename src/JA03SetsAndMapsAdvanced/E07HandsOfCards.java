package JA03SetsAndMapsAdvanced;

import java.util.*;

public class E07HandsOfCards {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        String command;
        while (!"JOKER".equals(command = scanner.nextLine())) {
            String[] tokens = command.split(": ");
            String playerName = tokens[0];
            String[] cards = tokens[1].split(", ");

            playersCards.putIfAbsent(playerName, new LinkedHashSet<>());
            Collections.addAll(playersCards.get(playerName), cards);
        }

        for (Map.Entry<String, Set<String>> entry : playersCards.entrySet()) {
            System.out.println(entry.getKey() + ": " + calculateHandsPower(entry.getValue()));
        }
    }

    private static int calculateHandsPower(Set<String> cards) {
        int totalPower = 0;

        for (String card : cards) {
            String cardPowerString;
            String cardType;

            if (card.length() == 3) {
                cardPowerString = "10";
                cardType = card.substring(2);
            } else {
                cardPowerString = card.substring(0, 1);
                cardType = card.substring(1);
            }

            int cardPower;
            switch (cardPowerString) {
                case "J" -> cardPower = 11;
                case "Q" -> cardPower = 12;
                case "K" -> cardPower = 13;
                case "A" -> cardPower = 14;
                default -> cardPower = Integer.parseInt(cardPowerString);
            }

            int multiplier = switch (cardType) {
                case "S" -> 4;
                case "H" -> 3;
                case "D" -> 2;
                case "C" -> 1;
                default -> 0;
            };

            totalPower += cardPower * multiplier;
        }

        return totalPower;
    }
}