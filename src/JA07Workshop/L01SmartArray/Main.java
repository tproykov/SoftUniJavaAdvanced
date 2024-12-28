package JA07Workshop.L01SmartArray;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SmartArray smartArray = new SmartArray();

        smartArray.add(5);
        smartArray.add(7);
        smartArray.add(8);
        smartArray.add(9);
        smartArray.add(10);






        for (int i = 0; i < smartArray.size(); i++) {
            System.out.print(smartArray.get(i) + " ");
        }



    }

}
