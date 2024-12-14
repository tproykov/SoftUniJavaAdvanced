package JA03SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class E08UserLogs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> usersIps = new TreeMap<>();

        String command;
        while (!"end".equals(command = scanner.nextLine())) {

            String[] commandArgs = command.split("\\s+");
            String ipAddress = commandArgs[0].replace("IP=", "");
            String message = commandArgs[1].replace("message=", "");
            String userName = commandArgs[2].replace("user=", "");

            usersIps.putIfAbsent(userName, new LinkedHashMap<>());
            usersIps.get(userName).putIfAbsent(ipAddress, 0);
            usersIps.get(userName).put(ipAddress, usersIps.get(userName).get(ipAddress) + 1);
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> outerEntry : usersIps.entrySet()) {

            System.out.println(outerEntry.getKey() + ":");

            LinkedHashMap<String, Integer> ips = outerEntry.getValue();

            String result = ips.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " => " + entry.getValue())
                    .collect(Collectors.joining(", "));

            System.out.println(result + ".");
        }
    }
}