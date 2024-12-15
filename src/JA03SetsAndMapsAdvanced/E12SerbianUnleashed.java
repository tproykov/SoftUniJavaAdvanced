package JA03SetsAndMapsAdvanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E12SerbianUnleashed {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venuesSingersRevenue = new LinkedHashMap<>();

        String command;
        while (!"End".equals(command = scanner.nextLine())) {

            String regex = "^(?<singer>[A-Za-z]+(\\s[A-Za-z]+){0,2})\\s@(?<venue>[A-Za-z]+(\\s[A-Za-z]+){0,2})\\s(?<price>\\d+)\\s(?<count>\\d+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(command);

            if (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));

                int revenue = price * count;

                venuesSingersRevenue.putIfAbsent(venue, new LinkedHashMap<>());
                venuesSingersRevenue.get(venue).putIfAbsent(singer, 0);
                venuesSingersRevenue.get(venue).put(singer, venuesSingersRevenue.get(venue)
                        .get(singer) + revenue);
            }
        }

        printOutput(venuesSingersRevenue);
    }

    private static void printOutput(LinkedHashMap<String, LinkedHashMap<String, Integer>> map) {
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey());

            LinkedHashMap<String, Integer> singersRevenue = entry.getValue();

            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(singersRevenue.entrySet());

            sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            for (Map.Entry<String, Integer> singerEntry : sortedList) {
                System.out.println("#  " + singerEntry.getKey() + " -> " + singerEntry.getValue());
            }
        }
    }
}