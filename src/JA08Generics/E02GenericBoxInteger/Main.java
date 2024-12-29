package JA08Generics.E02GenericBoxInteger;

import JA08Generics.E01GenericBox.Box;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            JA08Generics.E01GenericBox.Box<String> box = new Box<>(line);
            System.out.println(box);
        }

    }

}
