package JA10AlgorithmsIntroduction;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class L06Quicksort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort(array);
    }

    private static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {

        if (left < right) {
            int partitioningIndex = partition(array, left, right);
            sort(array, left, partitioningIndex - 1);
            sort(array, partitioningIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {

        int pivot = array[left];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        return i + 1;
    }
}