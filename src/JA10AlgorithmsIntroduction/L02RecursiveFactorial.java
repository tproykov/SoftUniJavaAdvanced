package JA10AlgorithmsIntroduction;

import java.util.Scanner;

public class L02RecursiveFactorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(recursiveFactorial(number));
    }

    public static int recursiveFactorial(int number) {

        if (number == 0) {
            return 1;
        }
        return number * recursiveFactorial(number - 1);
    }
}