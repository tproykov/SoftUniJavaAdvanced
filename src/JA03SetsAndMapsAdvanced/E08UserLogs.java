package JA03SetsAndMapsAdvanced;

import java.util.*;

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

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : usersIps.entrySet()) {

            System.out.println(entry.getKey() + ":");

            LinkedHashMap<String, Integer> ips = entry.getValue();
            for (Map.Entry<String, Integer> ip : ips.entrySet()) {

                System.out.println(ip.getKey() + " => " + ip.getValue());
            }
        }
    }
}