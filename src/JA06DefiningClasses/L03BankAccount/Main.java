package JA06DefiningClasses.L03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String command;
        while (!"End".equals(command = scanner.nextLine())) {

            String[] tokens = command.split("\\s+");
            String commandType = tokens[0];

            switch (commandType) {
                case "Create" -> {
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    System.out.println("Account ID" + account.getId() + " created");
                }

                case "Deposit" -> {
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    if (accounts.containsKey(id)) {
                        accounts.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d\n", amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                }

                case "SetInterest" -> {
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                }

                case "GetInterest" -> {
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (accounts.containsKey(id)) {
                        System.out.printf("%.2f\n", accounts.get(id).getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
            }
        }
    }
}