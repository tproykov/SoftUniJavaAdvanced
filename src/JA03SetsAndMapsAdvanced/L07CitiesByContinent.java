package JA03SetsAndMapsAdvanced;

import java.util.*;

public class L07CitiesByContinent {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> continentsCountriesCities = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (!continentsCountriesCities.containsKey(continent)) {
                continentsCountriesCities.put(continent, new LinkedHashMap<>());
            }
            if (!continentsCountriesCities.get(continent).containsKey(country)) {
                continentsCountriesCities.get(continent).put(country, new ArrayList<>());
            }
            continentsCountriesCities.get(continent).get(country).add(city);
        }

        printOutput(continentsCountriesCities);
    }

    private static void printOutput(Map<String, LinkedHashMap<String, List<String>>> continentsCountriesCities) {

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> entry : continentsCountriesCities.entrySet()) {

            System.out.println(entry.getKey() + ": ");

            Map<String, List<String>> countriesCities = entry.getValue();

            for (String country : countriesCities.keySet()) {

                System.out.print("  " + country + " -> ");

                List<String> cities = countriesCities.get(country);

                System.out.println(String.join(", ", cities));
            }
        }
    }
}