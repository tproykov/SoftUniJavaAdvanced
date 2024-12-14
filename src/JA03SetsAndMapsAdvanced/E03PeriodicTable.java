package JA03SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class E03PeriodicTable {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> elements = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] compound = scanner.nextLine().split(" ");

            elements.addAll(Arrays.asList(compound));
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}