package JA03SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02SetsOfElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int set1Length = Integer.parseInt(input[0]);
        int set2Length = Integer.parseInt(input[1]);

        Set<String> set1 = new LinkedHashSet<>();
        Set<String> set2 = new LinkedHashSet<>();

        for (int i = 0; i < set1Length; i++) {
            String number = scanner.nextLine();
            set1.add(number);
        }

        for (int i = 0; i < set2Length; i++) {
            String number = scanner.nextLine();
            set2.add(number);
        }

        set1.retainAll(set2);

        String result = String.join(" ", set1);
        System.out.println(result);
    }
}