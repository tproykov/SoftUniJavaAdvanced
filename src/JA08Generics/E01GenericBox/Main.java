package JA08Generics.E01GenericBox;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        // Exercise 1: -------------------------------------------
        Box<String> box = new Box<>();
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            box.add(line);
        }
        System.out.println(box.toString());

        // Exercise 2: --------------------------------------------
//        Box<Integer> box = new Box<>();
//        for (int row = 0; row < n; row++) {
//            int number = Integer.parseInt(scanner.nextLine());
//            box.add(number);
//        }
//        System.out.println(box.toString());

        // Exercise 3: --------------------------------------------
//        Box<String> box = new Box<>();
//        for (int row = 0; row < n; row++) {
//            String line = scanner.nextLine();
//            box.add(line);
//        }
//        String[] indexes = scanner.nextLine().split(" ");
//        int index1 = Integer.parseInt(indexes[0]);
//        int index2 = Integer.parseInt(indexes[1]);
//        box.swap(index1, index2);
//        System.out.println(box.toString());

        // Exercise 4: ---------------------------------------------
//        Box<Integer> box = new Box<>();
//        for (int row = 0; row < n; row++) {
//            int number = Integer.parseInt(scanner.nextLine());
//            box.add(number);
//        }
//        String[] indexes = scanner.nextLine().split(" ");
//        int index1 = Integer.parseInt(indexes[0]);
//        int index2 = Integer.parseInt(indexes[1]);
//        box.swap(index1, index2);
//        System.out.println(box.toString());

        // Exercise 5: -----------------------------------------------
//        Box<String> box = new Box<>();
//        for (int row = 0; row < n; row++) {
//            String line = scanner.nextLine();
//            box.add(line);
//        }
//        String valueToCompare = scanner.nextLine();
//        System.out.println(box.countGreaterValues(valueToCompare));

        // Exercise 6: -------------------------------------------------
//        Box<Double> box = new Box<>();
//        for (int row = 0; row < n; row++) {
//            double number = Double.parseDouble(scanner.nextLine());
//            box.add(number);
//        }
//        double valueToCompare = Double.parseDouble(scanner.nextLine());
//        System.out.println(box.countGreaterValues(valueToCompare));
    }
}