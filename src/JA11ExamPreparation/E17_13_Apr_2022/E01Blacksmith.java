package JA11ExamPreparation.E17_13_Apr_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01Blacksmith {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steel = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> coal = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!steel.isEmpty() && !coal.isEmpty()) {

            int currentSteel = steel.pollFirst();
            int currentCoal = coal.pollLast();

            int mix = currentSteel + currentCoal;



        }





    }


}
