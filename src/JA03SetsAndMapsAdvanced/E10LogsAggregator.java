package JA03SetsAndMapsAdvanced;

import java.util.*;

public class E10LogsAggregator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, Integer>> usersIpsDuration = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String[] inputParts = scanner.nextLine().split("\\s+");
            String ip = inputParts[0];
            String user = inputParts[1];
            int duration = Integer.parseInt(inputParts[2]);

            usersIpsDuration.putIfAbsent(user, new TreeMap<>());
            usersIpsDuration.get(user).putIfAbsent(ip, 0);
            usersIpsDuration.get(user).put(ip, usersIpsDuration.get(user).get(ip) + duration);
        }

        printOutput(usersIpsDuration);
    }

    private static void printOutput(TreeMap<String, TreeMap<String, Integer>> nestedMap) {

        for (Map.Entry<String, TreeMap<String, Integer>> entry : nestedMap.entrySet()) {

            System.out.print(entry.getKey() + ": ");

            int totalDuration = 0;
            for (String ip : entry.getValue().keySet()) {
                totalDuration += entry.getValue().get(ip);
            }

            System.out.print(totalDuration + " ");

            List<String> ipAddresses = new ArrayList<>(entry.getValue().keySet());
            System.out.println(ipAddresses);
        }
    }
}