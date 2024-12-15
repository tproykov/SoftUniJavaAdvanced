package JA03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E12SerbianUnleashed {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venuesSingersRevenue = new LinkedHashMap<>();

        String command;
        while (!"End".equals(command = scanner.nextLine())) {

            String regex = "(?<singer>[A-Z][a-z]+\\s*[A-Z]*[a-z]*)\\s@(?<venue>[A-Z][a-z]+\\s*[A-Z]*[a-z]*)\\s(?<price>\\d+)\\s(?<count>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(command);

            while (matcher.find()) {

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
    }
}