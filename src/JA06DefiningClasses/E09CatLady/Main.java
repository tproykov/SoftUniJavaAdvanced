package JA06DefiningClasses.E09CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            Cat cat;
            switch (breed) {
                case "Siamese":
                    cat = new Siamese(name, value);
                    break;
                case "Cymric":
                    cat = new Cymric(name, value);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, value);
                    break;
                default:
                    continue;
            }
            cats.put(name, cat);
        }

        String catName = scanner.nextLine();
        if (cats.containsKey(catName)) {
            System.out.println(cats.get(catName));
        }
    }
}