package JA08Generics.E03GenericSwapString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            list.add(input);
        }

        String[] indexes = scanner.nextLine().split(" ");
        int index1 = Integer.parseInt(indexes[0]);
        int index2 = Integer.parseInt(indexes[1]);

        for (int i = 0; i < list.size(); i++) {

        }

    }

}
