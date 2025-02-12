package JA09IteratorsAndComparators.E04Foggy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(", ");

        List<Integer> lakeNumbers = new ArrayList<>();

        for (String number : numbers) {
            lakeNumbers.add(Integer.parseInt(number));
        }

        Lake lake = new Lake(lakeNumbers);

        String command = scanner.nextLine();

        if (command.equals("END")) {

            List<String> result = new ArrayList<>();

            for (Integer number : lake) {
                result.add(String.valueOf(number));
            }

            System.out.println(String.join(", ", result));
        }
    }
}