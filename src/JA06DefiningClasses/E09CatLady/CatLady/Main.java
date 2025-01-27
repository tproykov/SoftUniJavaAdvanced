

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String input;
        while (!("End".equals(input = scanner.nextLine()))) {

            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            Cat cat;
            switch (breed) {
                case "Siamese" -> cat = new Siamese(name, value);
                case "Cymric" -> cat = new Cymric(name, value);
                case "StreetExtraordinaire" -> cat = new StreetExtraordinaire(name, value);
                default -> {
                    continue;
                }
            }

            cats.put(name, cat);
        }

        String catName = scanner.nextLine();

        if (cats.containsKey(catName)) {
            System.out.println(cats.get(catName));
        }
    }
}