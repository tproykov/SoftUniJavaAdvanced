package JA05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L04AddVat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .map(price -> price * 1.20)
                .forEach(price -> System.out.printf("%.2f\n", price));
    }
}