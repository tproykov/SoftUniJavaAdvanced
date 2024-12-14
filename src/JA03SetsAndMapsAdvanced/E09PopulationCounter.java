package JA03SetsAndMapsAdvanced;

import java.util.*;

public class E09PopulationCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> countriesCitiesPopulation = new LinkedHashMap<>();

        String command;
        while (!"report".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            countriesCitiesPopulation.putIfAbsent(country, new LinkedHashMap<>());
            countriesCitiesPopulation.get(country).putIfAbsent(city, 0);
            countriesCitiesPopulation.get(country)
                    .put(city, countriesCitiesPopulation.get(country).get(city) + population);
        }

        printSortedOutput(countriesCitiesPopulation);
    }

    private static void printSortedOutput(LinkedHashMap<String, LinkedHashMap<String, Integer>> map) {

        Map<String, Long> countryTotals = new LinkedHashMap<>();
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : map.entrySet()) {
            long totalPopulation = entry.getValue().values().stream()
                    .mapToLong(Integer::longValue)
                    .sum();
            countryTotals.put(entry.getKey(), totalPopulation);
        }

        List<Map.Entry<String, Long>> sortedCountries = new ArrayList<>(countryTotals.entrySet());
        sortedCountries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Long> countryEntry : sortedCountries) {
            String country = countryEntry.getKey();
            long totalPopulation = countryEntry.getValue();

            System.out.println(country + " (total population: " + totalPopulation + ")");

            List<Map.Entry<String, Integer>> sortedCities = new ArrayList<>(map.get(country).entrySet());
            sortedCities.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            for (Map.Entry<String, Integer> cityEntry : sortedCities) {
                System.out.println("=>" + cityEntry.getKey() + ": " + cityEntry.getValue());
            }
        }
    }
}