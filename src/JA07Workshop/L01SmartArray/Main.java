package JA07Workshop.L01SmartArray;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();

        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);
        smartArray.add(5);
        smartArray.add(6);

        smartArray.add(0, 7);

        System.out.println(smartArray.get(0));
        for (int i = 0; i < smartArray.size(); i++) {
            System.out.print(smartArray.get(i) + " ");
        }
        System.out.println();

        System.out.println(smartArray.contains(3));

        smartArray.forEach(System.out::println);

    }
}