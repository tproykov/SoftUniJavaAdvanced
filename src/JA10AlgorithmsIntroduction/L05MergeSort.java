package JA10AlgorithmsIntroduction;

import java.util.Arrays;
import java.util.Scanner;

public class L05MergeSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.stream(mergeSort(array))
        .mapToObj(String::valueOf)
                .reduce((a,b) -> a + " " + b)
                .orElse(""));
    }

    private static int[] mergeSort(int[] array) {

        if (array.length == 1) {
            return array;
        }

        int halfIndex = array.length / 2;
        int firstArrayLength = halfIndex;
        int secondArrayLength = array.length - halfIndex;

        int[] firstPartition = new int[firstArrayLength];
        int[] secondPartition = new int[secondArrayLength];

        for (int i = 0; i < firstArrayLength; i++) {
            firstPartition[i] = array[i];
        }

        for (int i = firstArrayLength; i < array.length; i++) {
            secondPartition[i - firstArrayLength] = array[i];
        }

        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);

        int mainIndex = 0;
        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;

        while (firstPartitionIndex < firstArrayLength && secondPartitionIndex < secondArrayLength) {
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                array[mainIndex] = firstPartition[firstPartitionIndex];

                mainIndex++;
                firstPartitionIndex++;
            }
            else {
                array[mainIndex] = secondPartition[secondPartitionIndex];

                mainIndex++;
                secondPartitionIndex++;
            }
        }

        while (firstPartitionIndex < firstArrayLength) {
            array[mainIndex] = firstPartition[firstPartitionIndex];

            mainIndex++;
            firstPartitionIndex++;
        }

        while (secondPartitionIndex < secondArrayLength) {
            array[mainIndex] = secondPartition[secondPartitionIndex];

            mainIndex++;
            secondPartitionIndex++;
        }

        return array;
    }
}