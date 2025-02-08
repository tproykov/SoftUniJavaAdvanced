package JA11ExamPreparation.E19_15_Dec_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class E01Meeting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(males::push);

        Deque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(females::offer);

        while (!males.isEmpty() && !females.isEmpty()) {

            int currentMale = males.pop();
            if (currentMale <= 0) {
                currentMale = males.pop();
            }


            int currentFemale = females.poll();
            if (currentFemale <= 0) {
                currentFemale = females.poll();
            }


            
            if (currentMale != currentFemale) {
                currentMale -= 2;
                males.push(currentMale);
            }
        }









    }
}
