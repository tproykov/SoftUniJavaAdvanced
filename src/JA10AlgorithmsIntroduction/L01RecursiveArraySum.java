package JA10AlgorithmsIntroduction;

import java.util.Arrays;
import java.util.Scanner;

public class L01RecursiveArraySum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(recursiveArraySum(array));
    }

    public static int recursiveArraySum(int[] array, int index) {

        // base case
        if (index == array.length) {
            return 0;

        }

        return array[index] + recursiveArraySum(array, index + 1);
    }

    public static int recursiveArraySum(int[] array) {
        return recursiveArraySum(array, 0);
    }
}